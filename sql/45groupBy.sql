USE w3schools;

# GROUP BY : 집계함수(avg, sum, count, min, max)를 그룹별로 결과 냄
SELECT CategoryID, COUNT(ProductID)
FROM Products
GROUP BY CategoryID;

SELECT CategoryID,
       (SELECT c.CategoryName
        FROM Categories c
        WHERE c.CategoryID = p.CategoryID),
       COUNT(ProductID)
FROM Products p
GROUP BY CategoryID;

SELECT c.CategoryID, c.CategoryName, COUNT(p.ProductID)
FROM Categories c
         JOIN Products p
              ON c.CategoryID = p.CategoryID
GROUP BY c.CategoryID;


SELECT e.EmployeeId, e.LastName, e.FirstName, SUM(od.Quantity * p.Price) 매출액
FROM Orders o
         JOIN OrderDetails od
              ON o.OrderID = od.OrderID
         JOIN Products p
              ON od.ProductID = p.ProductID
         JOIN Employees e
              ON o.EmployeeID = e.EmployeeID
WHERE OrderDate BETWEEN '1997-01-01' AND '1997-01-31'
GROUP BY e.EmployeeId
ORDER BY 매출액 DESC;

# 1999년 7월 기준 고객별 소비금액 높은 순서 top5 조회
SELECT c.CustomerID, c.CustomerName, SUM(od.Quantity * p.Price) 소비금액
FROM Orders o
         JOIN OrderDetails od ON o.OrderID = od.OrderID
         JOIN Products p ON od.ProductID = p.ProductID
         JOIN Customers c ON o.CustomerID = c.CustomerID
WHERE OrderDate BETWEEN '1997-07-01' AND '1997-07-31'
GROUP BY c.CustomerID
ORDER BY 소비금액 DESC
LIMIT 5;

SELECT Country, City, COUNT(CustomerID)
FROM Customers
GROUP BY Country, City;

# 고객별, 상품별 주문량
SELECT c.CustomerName, p.ProductName, SUM(Quantity) 상품주문수
FROM OrderDetails od
         JOIN Orders o ON od.OrderID = o.OrderID
         JOIN Customers c ON o.CustomerID = c.CustomerID
         JOIN Products p ON od.ProductID = p.ProductID
GROUP BY o.CustomerID, p.ProductID
ORDER BY o.CustomerID, 상품주문수 DESC;