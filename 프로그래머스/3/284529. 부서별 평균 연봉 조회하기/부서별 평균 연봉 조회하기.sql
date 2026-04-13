-- 코드를 작성해주세요
select d.DEPT_ID, DEPT_NAME_EN, round(avg_sal,0) as AVG_SAL
from hr_department d
join (
    select DEPT_ID, avg(sal) as avg_sal
    from hr_employees
    group by dept_id
) e
on d.dept_id = e.dept_id
order by avg_sal desc