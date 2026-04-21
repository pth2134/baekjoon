-- 코드를 작성해주세요
select e.ID, e.GENOTYPE, p.genotype as PARENT_GENOTYPE
from ecoli_data e
join ecoli_data p
on e.parent_id = p.id
where e.genotype & p.genotype = p.genotype
order by e.id