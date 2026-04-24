-- 코드를 작성해주세요
with recursive tree as (
    select id, 1 as depth
    from ecoli_data
    where parent_id is null
    
    union all
    
    select e.id, t.depth + 1
    from ecoli_data e
    join tree t on e.parent_id = t.id
    where t.depth < 3
)
select ID
from tree
where depth = 3
order by id;