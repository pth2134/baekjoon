-- 코드를 작성해주세요
select g.total_SCORE as SCORE, g.EMP_NO, e.EMP_NAME, e.POSITION, e.EMAIL
from 
(select sum(score) as total_score, EMP_NO
 from hr_grade
group by emp_no
order by total_score desc
limit 1) g
join hr_employees e on g.emp_no = e.emp_no
