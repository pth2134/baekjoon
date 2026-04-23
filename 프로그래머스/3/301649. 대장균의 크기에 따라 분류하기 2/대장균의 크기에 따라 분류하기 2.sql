select e.ID, 
case when e.COLONY_NAME <= 0.25 then 'CRITICAL'
     when e.COLONY_NAME <= 0.5 then 'HIGH'
     when e.COLONY_NAME <= 0.75 then 'MEDIUM'
     else 'LOW'
end as COLONY_NAME
from (
    select
    ID,
    row_number() over(order by size_of_colony desc) * 1.0 / count(*) over() as COLONY_NAME
    from ecoli_data
    order by ID
) e
