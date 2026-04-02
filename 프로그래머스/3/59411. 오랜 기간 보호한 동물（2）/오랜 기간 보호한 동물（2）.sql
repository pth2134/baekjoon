-- 코드를 입력하세요
SELECT o.ANIMAL_ID, o.NAME
from animal_outs o left join animal_ins i
on o.animal_id = i.animal_id
order by datediff(o.datetime, i.datetime) desc
limit 2