USE w3schools;

#LIMIT : 조회 결과 수를 제한

SELECT *
FROM Customers
LIMIT 5;

SELECT *
FROM Products
ORDER BY Price DESC
LIMIT 6;

SELECT *
FROM Employees
ORDER BY BirthDate DESC
LIMIT 2;

SELECT *
FROM Products
WHERE CategoryID = 1
ORDER BY Price
LIMIT 3;

SELECT *
FROM Orders
ORDER BY OrderDate
LIMIT 1;

SELECT *
FROM Orders
ORDER BY OrderDate DESC
LIMIT 5;

SELECT *
FROM Employees
ORDER BY BirthDate
LIMIT 1;

SELECT *
FROM Products
WHERE CategoryID = 3
ORDER BY Price DESC
LIMIT 2;

# LIMIT OFFSET, n
# OFFSET 으로부터 n개로 제한
SELECT *
FROM Products
ORDER BY Price
LIMIT 1, 5;

# paging
# 한 페이지에 10개씩 조회할 때
# 1페이지 : LIMIT 0, 10
SELECT CustomerID, CustomerName
FROM Customers
ORDER BY CustomerID
LIMIT 0, 10;

# 2페이지 : LIMIT 10, 10
SELECT CustomerID, CustomerName
FROM Customers
ORDER BY CustomerID
LIMIT 10, 10;

# 3페이지 : LIMIT 20, 10
SELECT CustomerID, CustomerName
FROM Customers
ORDER BY CustomerID
LIMIT 20, 10;

# n 페이지 : LIMIT (n-1)*페이지 당 게시물의 수, 페이지 당 게시물 수