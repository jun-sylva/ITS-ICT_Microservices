package org.library.borrow.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "borrow")
public class Borrow {

    @Id
    private long borrowID;
    private String startDate;
    private String stopDate;
    private String customerID;
    private String bookID;
    private String notifyPhoneNum;

    public long getBorrowID() {
        return borrowID;
    }

    public void setBorrowID(long borrowID) {
        this.borrowID = borrowID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getNotifyPhoneNum() {
        return notifyPhoneNum;
    }

    public void setNotifyPhoneNum(String notifyPhoneNum) {
        this.notifyPhoneNum = notifyPhoneNum;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getStopDate() {
        return stopDate;
    }

    public void setStopDate(String stopDate) {
        this.stopDate = stopDate;
    }

    @Override
    public String toString() {
        return "Borrow{" +
                "borrowID=" + borrowID +
                ", start Date='" + startDate + '\'' +
                ", stop Date='" + stopDate + '\'' +
                ", customerID='" + customerID + '\'' +
                ", bookID='" + bookID + '\'' +
                ", notifyPhoneNum='" + notifyPhoneNum + '\'' +
                '}';
    }
}
