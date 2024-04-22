USE w3schools

SELECT * FROM Employees
ORDER BY EmployeeID DESC;

# 지우기 전에 반드시 같은 WHERE로 SELECT 해보기
DELETE FROM Employees
WHERE EmployeeID = 2044;

DELETE FROM Employees
WHERE LastName = 1;

# 모든 레코드 지우기 : WHERE 안 쓰면 됨
SELECT * FROM Employees;
DELETE FROM Employees;