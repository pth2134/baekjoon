-- 코드를 작성해주세요
select e.ID, ifnull(p.CHILD_COUNT, 0) as CHILD_COUNT
from ecoli_data e left join (
select parent_id as ID, count(*) AS CHILD_COUNT
from ecoli_data
group by parent_id
) p on e.id = p.id
order by e.id