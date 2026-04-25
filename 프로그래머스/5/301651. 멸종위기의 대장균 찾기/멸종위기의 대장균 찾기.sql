with recursive tree as(
    select id, parent_id, 1 as depth
    from ecoli_data
    where parent_id is null
    
    union all
    
    select e.id, e.parent_id, t.depth + 1
    from ecoli_data e 
    join tree t
    on e.parent_id = t.id
)
select count(*) as COUNT, depth as GENERATION
from tree t
left join ecoli_data e
on t.id = e.parent_id
where e.id is null
group by depth
order by depth