-- 코드를 작성해주세요
select d.ID, d.EMAIL, d.FIRST_NAME, d.LAST_NAME
from developers d join skillcodes s on s.name in ('Python','C#')
where (d.skill_code & s.code) <> 0
group by d.id, d.email, d.first_name, d.last_name
order by d.id