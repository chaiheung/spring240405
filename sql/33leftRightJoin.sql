USE mydb2;

# LEFT JOIN (OUTER JOIN)
# INNER JOIN + 왼쪽 테이블에만 있는 레코드

# 1, 2, 3, 4
SELECT *
FROM table1;

# 2, 2, 3, 4, 5
SELECT *
FROM table2;

# INNER JOIN
SELECT *
FROM table1
         JOIN table2 ON col_a = col_b;

# LEFT JOIN
SELECT *
FROM table1
         LEFT JOIN table2 ON col_a = col_b;

# 지우고 재할당
DELETE
FROM table1;
DELETE
FROM table2;
INSERT INTO table1
VALUES (1),
       (2),
       (2),
       (3),
       (4);
INSERT INTO table2
VALUES (3),
       (4),
       (5),
       (5);

# LEFT JOIN
SELECT *
FROM table1
         LEFT JOIN table2 ON col_a = col_b;
SELECT *
FROM table2
         LEFT JOIN table1 ON col_a = col_b;

# RIGHT JOIN
SELECT *
FROM table2
         RIGHT JOIN table1 ON col_a = col_b;
SELECT *
FROM table1
         RIGHT JOIN table2 ON col_a = col_b;


# 예제
DELETE
FROM table3;
DELETE
FROM table4;
INSERT INTO table3
VALUES (3),
       (4),
       (5),
       (6);
INSERT INTO table4
VALUES (5),
       (6),
       (7),
       (7),
       (8);

# 카테시안 곱 조인
SELECT *
FROM table3
         JOIN table4;

# INNER JOIN
SELECT *
FROM table3
         JOIN table4 ON col_a = col_b;

# LEFT OUTER JOIN
SELECT *
FROM table3
         LEFT JOIN table4 ON col_a = col_b;
SELECT *
FROM table4
         LEFT JOIN table3 ON col_a = col_b;

# RIGHT OUTER JOIN
SELECT *
FROM table4
         RIGHT JOIN table3 ON col_a = col_b;
SELECT *
FROM table3
         LEFT JOIN table4 ON col_a = col_b;