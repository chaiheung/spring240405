USE mydb2;

CREATE TABLE employee
(
    id         INT PRIMARY KEY,
    name       VARCHAR(10) NOT NULL,
    info       VARCHAR(10) NOT NULL,
    manager_id INT
);

INSERT INTO employee
VALUES (1, '손흥민', '과장', 6),
       (2, '이강인', '사원', 1),
       (3, '김민재', '대리', 1),
       (4, '황희찬', '대리', 1),
       (5, '차범근', '사장', null),
       (6, '박지성', '차장', 5);

# 손흥민의 직속 상사
SELECT e2.name
FROM employee e1
         JOIN employee e2
              ON e1.manager_id = e2.id
WHERE e1.name = '손흥민';

# 이강인의 직속상사
SELECT m.name
FROM employee e
         JOIN employee m
              ON e.manager_id = m.id
WHERE e.name = '이강인';

# 손흥민의 직속직원들
SELECT e.name
FROM employee e
         JOIN employee m
              ON e.manager_id = m.id
WHERE m.name = '손흥민';

SELECT name
FROM employee
WHERE manager_id = (SELECT id
                    FROM employee
                    WHERE name = '손흥민');


