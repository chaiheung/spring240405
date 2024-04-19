USE w3schools;

# INSERT INTO 테이블명(컬럼명 나열)
# VALUE 또는 VALUES(데이터(들))

SELECT *
FROM Employees
ORDER BY EmployeeID DESC;
DESC Employees;

INSERT INTO Employees(LastName)
VALUES ('ironman');

INSERT INTO Employees(FirstName)
VALUES ('tony');

INSERT INTO Employees
    (LastName, FirstName, BirthDate, Photo, Notes)
VALUES ('captain', 'steve', '1990-01-01', 'pic1', 'america');

INSERT INTO Employees
    (FirstName, LastName)
VALUES ('natasha', 'widow');

SELECT *
FROM Customers
ORDER BY CustomerID DESC;

INSERT INTO Customers
    Value ();

SELECT *
FROM Employees
ORDER BY EmployeeID DESC;