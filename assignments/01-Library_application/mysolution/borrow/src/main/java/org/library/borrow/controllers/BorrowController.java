package org.library.borrow.controllers;


import lombok.extern.slf4j.Slf4j;
import org.library.borrow.models.Borrow;
import org.library.borrow.repos.BorrowRepository;
import org.library.borrow.service.NotificationClient;
import org.library.borrow.service.TraceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
@RequestMapping(value = "/lib/borrowings/")
public class BorrowController {

    @Autowired
    TraceService traceService;

    @Autowired
    NotificationClient notificationClient;

    @Value("${kafka.sms.message}")
    private String message;

    @Autowired
    private final BorrowRepository borrowRepository;

    public BorrowController(BorrowRepository borrowRepository){
        this.borrowRepository = borrowRepository;
    }

    //CREATE NEW BORROWING
    @RequestMapping(method = RequestMethod.PUT)
    public Borrow AddNewBorrowing(@Valid @RequestBody Borrow borrow){
        notificationClient.sendSMS(borrow);
        return borrowRepository.save(borrow);
    }

    //READ SINGLE BORROWING
    @RequestMapping(value = "/{borrowID}", method = RequestMethod.GET)
    public Borrow getBorrowing(@PathVariable Long borrowID){
        Optional<Borrow> borrowOptional = borrowRepository.findById(borrowID);
        if(borrowOptional.isPresent()){
            return borrowOptional.get();
        }else{
            return null;
        }
    }

    //READ ALL BORROWINGS
    @RequestMapping(method = RequestMethod.GET)
    public Collection<Borrow> getAllBorrowing(){
        List<Borrow> borrowings = new ArrayList<Borrow>();
        Iterable<Borrow> iterable = borrowRepository.findAll();
        iterable.forEach(borrowings::add);
        return borrowings;
    }

    //UPDATE SINGLE BORROWING
    @RequestMapping(value = "/{borrowID}", method = RequestMethod.POST)
    public Borrow modifyBorrowing(@RequestBody Borrow borrow, @RequestBody String borrowID){
        return borrowRepository.save(borrow);
    }

    //DELETE SINGLE BORROWING
    @RequestMapping(value = "/{borrowID}", method = RequestMethod.DELETE)
    public void deleteBorrowing(@PathVariable Long borrowID) {
        borrowRepository.deleteById(borrowID);
    }

    //DELETE ALL BORROWINGS
    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteAllBorrowing() {
        borrowRepository.deleteAll();
    }
}
