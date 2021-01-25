package org.library.borrow.repos;

import org.library.borrow.models.Borrow;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowRepository extends CrudRepository<Borrow, Long> {
}
