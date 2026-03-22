select concat(ceil(month(DIFFERENTIATION_DATE)/3),'Q') as QUARTER, count(*) as ECOLI_COUNT
from ecoli_data
group by QUARTER
order by QUARTER