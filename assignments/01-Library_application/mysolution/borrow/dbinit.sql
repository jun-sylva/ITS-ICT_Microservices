CREATE DATABASE "Borrowing" OWNER postgres;
\connect order
ALTER DATABASE "Borrowing" SET TIMEZONE TO 'Europe/Rome';
SET TIMEZONE TO 'Europe/Rome';

CREATE TABLE "borrowings"
(
    borrowID integer,
    startDate character varying,
    stopDate character varying,
    customerID character varying,
    bookID character varying,
    notifyPhoneNum character varying
) TABLESPACE pg_default;

ALTER TABLE "borrow"
    OWNER to postgres;
