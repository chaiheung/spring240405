USE w3schools

# aggregate function : 집계함수
# 평균, 합계, 갯수, 최댓값, 최솟값
# NULL 값은 집계 제외



# COUNT : 갯수
SELECT COUNT(EmployeeID)
FROM Employees;

SELECT COUNT(Notes)
FROM Employees;

SELECT COUNT(DISTINCT Country)
FROM Customers;

# MIN : 최솟값
# MAX : 최댓값

SELECT MAX(Price)
FROM Products;
SELECT MIN(Price)
FROM Products;

-- 가장 어린 사람의 생년월일
SELECT MAX(BirthDate)
FROM Employees;

-- 가장 나이 많음 사람의 생년월일
SELECT MIN(BirthDate)
FROM Employees;

# SUM : 합계
SELECT SUM(Price)
FROM Products;

# AVG : 평균
SELECT AVG(Price)
FROM Products;