USE w3schools

# AS : 컬럼 ( 또는 테이블 ) 에 별칭을 줌
SELECT ProductID AS id, ProductName AS name, Price AS 가격
FROM Products;

# AS 생략 가능
SELECT ProductID id, ProductName name, Price 가격
FROM Products;
