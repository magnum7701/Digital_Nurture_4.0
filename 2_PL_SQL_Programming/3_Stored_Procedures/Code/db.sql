create table Accounts (
    AccountID int primary key,
    CustomerName varchar(100),
    AccountType varchar(20), -- e.g., 'Savings', 'Checking', etc.
    Balance decimal(10, 2)
);

create table Employees (
    EmployeeID int primary key,
    EmployeeName varchar(100),
    Department varchar(50),
    Salary decimal(10, 2)
);

insert into Accounts values (101, 'Alice Sharma', 'Savings', 10000.00);
insert into Accounts values (102, 'Rahul Das', 'Savings', 15000.50);
insert into Accounts values (103, 'Priya Verma', 'Savings', 8000.75);
insert into Accounts values (201, 'Arjun Kapoor', 'Checking', 20000.00);
insert into Accounts values (202, 'Meena Pillai', 'Checking', 25000.00);
insert into Accounts values (203, 'Ravi Singh', 'Savings', 18000.00);
insert into Accounts values (204, 'Kajal Yadav', 'Checking', 10000.00);

insert into Employees values (1, 'Raj Mehta', 'HR', 50000.00);
insert into Employees values (2, 'Anita Roy', 'IT', 70000.00);
insert into Employees values (3, 'Suresh Kumar', 'IT', 65000.00);
insert into Employees values (4, 'Neha Jain', 'Finance', 55000.00);

-- SCENARIO 1 --
create or replace procedure ProcessMonthlyInterest is
begin
    update Accounts
    set Balance = Balance + (Balance * 0.01)
    where AccountType = 'Savings';
    
    dbms_output.put_line('Monthly interest applied to all savings accounts.');
end;
/


-- SCENARIO 2 --
create or replace procedure UpdateEmployeeBonus(
    dept_name in varchar2,
    bonus_percent in number
) is
begin
    update Employees
    set Salary = Salary + (Salary * bonus_percent / 100)
    where Department = dept_name;
    
    dbms_output.put_line('Bonus applied to department: ' || dept_name);
end;
/


-- SCENARIO 3 --
create or replace procedure TransferFunds(
    from_account in number,
    to_account in number,
    amount in number
) is
    from_balance number;
begin
    -- Check if source account exists and get balance
    select Balance into from_balance
    from Accounts
    where AccountID = from_account
    for update;

    if from_balance < amount then
        raise_application_error(-20001, 'Insufficient funds in source account.');
    end if;

    -- Deduct from source
    update Accounts
    set Balance = Balance - amount
    where AccountID = from_account;

    -- Add to destination
    update Accounts
    set Balance = Balance + amount
    where AccountID = to_account;

    dbms_output.put_line('Transferred ' || amount || ' from account ' || from_account || ' to account ' || to_account);
end;
/

