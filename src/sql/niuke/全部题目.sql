

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

-- 218
select
    b.dept_no,
    a.emp_no,
    d.salary
from
    employees a,
    dept_emp b,
    dept_manager c,
    salaries d
where
        a.emp_no = b.emp_no
  and a.emp_no = d.emp_no
  -- 后面两句是关键，把c中每个manager和b中每个员工（包括自己）对应连起来
  -- 然后将自己剔除出去
  and b.dept_no = c.dept_no
  and b.emp_no != c.emp_no;

-- 第二种解法。第二种解法笛卡尔积更少一些？？
select de.dept_no, a.emp_no, s.salary from
(
    select emp_no from employees where emp_no not in
       (
           select emp_no from dept_manager
       )
) a inner join dept_emp de on a.emp_no=de.emp_no
    inner join salaries s on a.emp_no=s.emp_no;

-- 219
-- 这道题其实很典型了，遇到要比较大小关系怎么做
-- 此外从这一题开始应该注意到SQL的书写规范的问题
select
    a.emp_no,
    b.manager_no,
    a.emp_salary,
    b.manager_salary
from
    (
        select
            de.dept_no,
            de.emp_no,
            s.salary as emp_salary
        from
            dept_emp de,
            salaries s
        where
            de.emp_no = s.emp_no
    ) a,
    (
        select
            dm.dept_no,
            dm.emp_no as manager_no,
            s.salary as manager_salary
        from
            dept_manager dm,
            salaries s
        where
            dm.emp_no = s.emp_no
    ) b
where
    a.dept_no = b.dept_no
    and a.emp_salary > b.manager_salary;

-- 220
# select dm.dept_no, dm.dept_name, ti.title, count(*) as count
# from
#     departments dm
#     inner join
#     dept_emp de on dm.dept_no = de.dept_no
#     inner join
#     titles ti on de.emp_no = ti.emp_no
# count(*)的使用需要group by吗，为什么这个跑不了，对于联表查询还有很多没弄懂啊
# group by dm.dept_no