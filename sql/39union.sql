# (INNER) JOIN
# LEFT (OUTER) JOIN
# RIGHT (OUTER) JOIN
# FULL (OUTER) JOIN -> mariadb 에는 UNION 이 대체

# UNION : 합집합
USE mydb2;

CREATE TABLE table10
(
    col1 INT
);
CREATE TABLE table11
(
    cola INT
);

INSERT INTO table10
VALUES (3),
       (4),
       (4),
       (5);
INSERT INTO table11
VALUES (3),
       (4),
       (7);

SELECT *
FROM table10
UNION
SELECT *
FROM table11;

# LEFT JOIN
SELECT *
FROM table10
         LEFT JOIN table11 ON col1 = cola

# UNION
UNION

# RIGHT JOIN
SELECT *
FROM table10
         RIGHT JOIN table11 ON col1 = cola;


# UNION ALL : 중복 제거를 원하지 않을 때 사용

SELECT *
FROM table10
         LEFT JOIN table11 ON col1 = cola

UNION ALL

SELECT *
FROM table10
         RIGHT JOIN table11 ON col1 = cola;