-- Create the Loans table

create table Loans(
    LoanID number(10) not null,
    CustomerID number(10) not null,
    Balance number(10,2) not null,
    InterestRate number(5,2) not null,
    Age number(3) not null,
    DueDate date not null,
    IsVip NUMBER(1) DEFAULT 0 CHECK (IsVip IN (0, 1)),
    CustomerName varchar2(30),
    Primary Key (LoanID)
);

-- INSERT statements for Loans table (I HAVE USED SYSDATE + N FORMAT FOR DATES SO THAT THE RESULTS DO NOT DEPEND UPON THE DATE OF RUNNING THE PROGRAM)

insert into loans values (1, 101, 9500.00, 5.25, 45, sysdate + 24, 0, 'Alice');
insert into loans values (2, 102, 15000.00, 4.75, 67, sysdate + 260, 0, 'Bob');
insert into loans values (3, 103, 8500.00, 6.00, 34, sysdate + 22, 0, 'Charlie');
insert into loans values (4, 104, 20000.00, 3.95, 72, sysdate + 320, 0, 'Diane');
insert into loans values (5, 105, 12000.00, 5.10, 38, sysdate + 14, 0, 'Evan');
insert into loans values (6, 106, 6200.00, 6.50, 61, sysdate + 60, 0, 'Fiona');
insert into loans values (7, 107, 30000.00, 2.75, 59, sysdate + 370, 0, 'George');
insert into loans values (8, 108, 10500.00, 4.25, 64, sysdate + 28, 0, 'Hannah');
insert into loans values (9, 109, 4800.00, 7.25, 28, sysdate + 10, 0, 'Ibrahim');
insert into loans values (10, 110, 16000.00, 3.90, 75, sysdate + 355, 0, 'Julia');
insert into loans values (11, 111, 7200.00, 5.80, 30, sysdate + 70, 0, 'Karan');
insert into loans values (12, 112, 18000.00, 4.10, 62, sysdate + 300, 0, 'Laila');
insert into loans values (13, 113, 9800.00, 6.20, 55, sysdate + 32, 0, 'Mike');
insert into loans values (14, 114, 10900.00, 5.15, 69, sysdate + 145, 0, 'Nina');
insert into loans values (15, 115, 4500.00, 7.00, 40, sysdate + 18, 0, 'Oscar');



-- PL/SQL CODE

begin
    for Loan_Cursor in(
        select LoanID, InterestRate, Age, Balance from Loans
    )
    loop
        if Loan_Cursor.Age > 60 then
            update Loans 
            set InterestRate= InterestRate - 1
            where LoanID = Loan_Cursor.LoanID;
        end if;

        if Loan_Cursor.Balance>10000 then
            update Loans
            set IsVip=1
            where LoanID = Loan_Cursor.LoanID;
        end if;
    end loop;
    
    for loan_rec in (
        select loanid, customername, duedate
        from loans
        where duedate between sysdate and sysdate + 30
    ) 
    loop
        dbms_output.put_line('Reminder: Loan ID ' || loan_rec.loanid || ' for customer ' || loan_rec.customername || ' is due on ' || to_char(loan_rec.duedate, 'dd-mon-yyyy'));
    end loop;
end; 
/           
            

            



