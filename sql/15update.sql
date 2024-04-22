USE w3schools

# UPDATE 테이블명
# SET 컬럼명 = 바꿀 값, 컬럼명 = 바꿀 값....
# WHERE 레코드의 조건

SELECT *
FROM Customers
WHERE CustomerID = 10;

UPDATE Customers
SET Address = 'Stark Tower', City = 'Manhattan', PostalCode = '12345'
WHERE CustomerID = 10;

UPDATE Customers
SET ContactName = 'Tony Stark'
WHERE CustomerID = 10;

SELECT * FROM Customers
WHERE Country = 'UK';

UPDATE Customers
SET Country = 'United Kingdom'
WHERE Country = 'UK';

SELECT * FROM Customers
WHERE Country = 'United Kingdom';