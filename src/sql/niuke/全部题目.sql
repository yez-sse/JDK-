drop table if exists  `employees` ;
drop table if exists  `salaries` ;
CREATE TABLE `employees` (
                             `emp_no` int(11) NOT NULL,
                             `birth_date` date NOT NULL,
                             `first_name` varchar(14) NOT NULL,
                             `last_name` varchar(16) NOT NULL,
                             `gender` char(1) NOT NULL,
                             `hire_date` date NOT NULL,
                             PRIMARY KEY (`emp_no`));
CREATE TABLE `salaries` (
                            `emp_no` int(11) NOT NULL,
                            `salary` int(11) NOT NULL,
                            `from_date` date NOT NULL,
                            `to_date` date NOT NULL,
                            PRIMARY KEY (`emp_no`,`from_date`));
INSERT INTO employees VALUES(10001,'1953-09-02','Georgi','Facello','M','1986-06-26');
INSERT INTO employees VALUES(10002,'1964-06-02','Bezalel','Simmel','F','1985-11-21');
INSERT INTO employees VALUES(10003,'1959-12-03','Parto','Bamford','M','1986-08-28');
INSERT INTO employees VALUES(10004,'1954-05-01','Chirstian','Koblick','M','1986-12-01');
INSERT INTO salaries VALUES(10001,88958,'2002-06-22','9999-01-01');
INSERT INTO salaries VALUES(10002,72527,'2001-08-02','9999-01-01');
INSERT INTO salaries VALUES(10003,43311,'2001-12-01','9999-01-01');
INSERT INTO salaries VALUES(10004,74057,'2001-11-27','9999-01-01');

CREATE TABLE `departments` (
                               `dept_no` char(4) NOT NULL,
                               `dept_name` varchar(40) NOT NULL,
                               PRIMARY KEY (`dept_no`));
CREATE TABLE `dept_emp` (
                            `emp_no` int(11) NOT NULL,
                            `dept_no` char(4) NOT NULL,
                            `from_date` date NOT NULL,
                            `to_date` date NOT NULL,
                            PRIMARY KEY (`emp_no`,`dept_no`));
INSERT INTO departments VALUES('d001','Marketing');
INSERT INTO departments VALUES('d002','Finance');
INSERT INTO departments VALUES('d003','Human Resources');
INSERT INTO dept_emp VALUES(10001,'d001','1986-06-26','9999-01-01');
INSERT INTO dept_emp VALUES(10002,'d001','1996-08-03','9999-01-01');
INSERT INTO dept_emp VALUES(10003,'d002','1990-08-05','9999-01-01');


-- 212 获取当前薪水第二多的员工的emp_no以及其对应的薪水salary
select e.emp_no, s.salary
from employees e join salaries s
on e.emp_no = s.emp_no
order by s.salary desc
limit 1, 1;
-- 说不能用order by
select e.emp_no, s.salary, e.last_name, e.first_name
from employees e join salaries s on e.emp_no = s.emp_no
where s.salary = (
    select  max(salary)
    from salaries
    where s.salary < (
        select max(s.salary)
        from salaries
        )
    );

-- 213
select e.last_name, e.first_name, d.dept_name
from employees e right join dept_emp de on e.emp_no = de.emp_no
join departments d on de.dept_no = d.dept_no
