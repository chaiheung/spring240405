USE w3schools;

# HAVING : 집계함수의 조건절
SELECT *
FROM (SELECT CategoryID, COUNT(ProductID) 상품수
      FROM Products
      GROUP BY CategoryID) c
WHERE 상품수 >= 10;

SELECT CategoryID, COUNT(ProductID) 상품수
FROM Products
GROUP BY CategoryID
HAVING 상품수 >= 10;

# 고객이 5명 이상인 국가 조회
SELECT Country, COUNT(CustomerID) 고객수
FROM Customers
GROUP BY Country
HAVING 고객수 >= 5
ORDER BY 고객수 DESC;

# 1997년 7월 매출액(SUM(상품가격 *갯수))이
# 10000 달러 이상인 직원 조회

SELECT e.FirstName, e.LastName, SUM(p.price * od.Quantity) 매출액
FROM Employees e
         JOIN Orders o ON e.EmployeeID = o.EmployeeID
         JOIN OrderDetails od ON o.OrderID = od.OrderID
         JOIN Products p ON od.ProductID = p.ProductID
WHERE o.OrderDate BETWEEN '1997-07-01' AND '1997-07-31'
GROUP BY e.EmployeeID
HAVING 매출액 >= 10000
ORDER BY 매출액 DESC;