USE w3schools;

# order by : 조회 순서 결정
# order by 컬럼명
# default : ASC(오름차순)
SELECT *
FROM Products
ORDER BY ProductID;

# DESC(내림차순)
SELECT *
FROM Products
ORDER BY Price DESC;

# 여러 컬럼 기준 ',' 사용
SELECT *
FROM Products
ORDER BY ProductID, Price;

SELECT *
FROM Products
ORDER BY SupplierID, CategoryID, Price;

SELECT *
FROM Products
ORDER BY 4, 6;

SELECT ProductName, CategoryID, Price, Unit
FROM Products
ORDER BY 2, 3;
-- ORDER BY CategoryId, Price;

SELECT *
FROM Employees
ORDER BY BirthDate;

SELECT *
FROM Customers
ORDER BY Country, City;

SELECT *
FROM Suppliers
ORDER BY City;

SELECT *
FROM Employees
ORDER BY FirstName DESC;
