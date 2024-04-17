USE w3schools;
# SELECT 에 컬럼명
# FROM 테이블명
SELECT CustomerName, City, Country
FROM Customers
WHERE City = 'Berlin';
SELECT CustomerName, City, Country
FROM Customers
WHERE Country = 'Germany';

# 컬럼명 - 비교연산자 - 값 순으로 나열
# 값은 ''로 감싸기 (but, 수 형식은 생략 가능)
SELECT *
FROM Customers
WHERE CustomerID = 1;
-- '1'도 가능하나 비권장

# 비교연산자 : 같다 =, 작다 <, 작거나 같다 <=, 크다 >, 크거나 같다 >=, 같지 않다 !=, <>
SELECT *
FROM Customers
WHERE CustomerID = 3;
SELECT *
FROM Customers
WHERE CustomerID < 3;
SELECT *
FROM Customers
WHERE CustomerID > 3;
SELECT *
FROM Customers
WHERE CustomerID <= 3;
SELECT *
FROM Customers
WHERE CustomerID >= 3;
SELECT *
FROM Customers
WHERE CustomerID != 3;
SELECT *
FROM Customers
WHERE CustomerID <> 3;

# 문자열 형식(대소문자 구분 X)
SELECT *
FROM Customers
WHERE CustomerName >= 'S'; -- 's' 가능
SELECT *
FROM Customers
WHERE Country = 'germany';

# 날짜 형식
SELECT *
FROM Employees
WHERE BirthDate <= '1992-11-23';

SELECT *
FROM Suppliers
WHERE Country = 'usa';

SELECT *
FROM Employees
WHERE LastName = 'fuller';

SELECT *
FROM Products
WHERE CategoryID = 3;

SELECT *
FROM Products
WHERE Price >= 20.00;

SELECT *
FROM Orders
WHERE OrderDate < '1997-01-01';