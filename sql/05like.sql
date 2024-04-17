USE w3schools;

# LIKE : 와일드카드로 조회
# 와일드카드
# _ : 한글자 아무거나
# % : 0개 이상의 글자 아무거나

# Cha 이후 아무글자 두개
SELECT *
FROM Products
WHERE ProductName Like 'cha__';

SELECT *
FROM Orders
WHERE OrderDate LIKE '1996-07-0_';

SELECT *
FROM Orders
WHERE OrderDate LIKE '____-07-__';

SELECT *
FROM Products
WHERE ProductName LIKE 'cha%';

SELECT *
FROM Products
WHERE ProductName LIKE '%ng';

SELECT *
FROM Products
WHERE ProductName LIKE 's%s';

SELECT *
FROM Products
WHERE ProductName LIKE '%od%';

SELECT *
FROM Products
WHERE ProductName LIKE '%anton%';

SELECT *
FROM Customers
WHERE CustomerName LIKE 'b%';

SELECT *
FROM Customers
WHERE Country LIKE '%a';

SELECT *
FROM Orders
WHERE OrderDate LIKE '%01';