

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

-- 215
select b.emp_no, (b.salary - a.salary) as growth
from
    (select e.emp_no, s.salary
     from employees e left join salaries s using (emp_no)
     where e.hire_date=s.from_date) as a
        inner join
    (select e.emp_no, s.salary
     from employees e left join salaries s using (emp_no)
     where s.to_date='9999-01-01') as b
    using (emp_no)
order by growth;

-- 217
select emp_no, salary,
       dense_rank() over (order by salary desc) as s_rank
from salaries
where to_date='9999-01-01'
order by s_rank asc,emp_no asc;