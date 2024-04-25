# Third Normal Form (3NF, 제3정규화)

# 1) 2NF 테이블
# 2) 키가 아닌 컬럼끼리 종속되면 안됨 (이행적 종속 제거)

USE mydb1;
DROP TABLE customer;
DROP TABLE phone_number;

CREATE TABLE customer
(
    id         INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(3),
    last_name  VARCHAR(3),
    level      INT,
    benefit    VARCHAR(100)
);
INSERT INTO customer
    (first_name, last_name, level, benefit)
VALUES ('hm', 'son', 1, '무료배송'),
       ('ki', 'lee', 1, '무료배송'),
       ('hs', 'kim', 2, '할인'),
       ('jh', 'lee', 2, '할인'),
       ('cap', 'ame', 3, '라운지');
SELECT *
FROM customer;

DROP TABLE customer;
DROP TABLE customer_benefit;

CREATE TABLE customer
(
    id         INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(3),
    last_name  VARCHAR(3),
    level      INT,
    FOREIGN KEY (level) REFERENCES customer_benefit (level)
);
CREATE TABLE customer_benefit
(
    level   INT PRIMARY KEY,
    benefit VARCHAR(100)
);
INSERT INTO customer
    (first_name, last_name, level)
VALUES ('hm', 'son', 1),
       ('ki', 'lee', 1),
       ('hs', 'kim', 2),
       ('jh', 'lee', 2),
       ('cap', 'ame', 3);
INSERT INTO customer_benefit
    (level, benefit)
VALUES (1, '무료배송'),
       (2, '할인'),
       (3, '라운지');
SELECT *
FROM customer;
SELECT *
FROM customer_benefit;