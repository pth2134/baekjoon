-- 코드를 작성해주세요
select count(*) as FISH_COUNT, n.FISH_NAME
from fish_info i
left join fish_name_info n on i.fish_type = n.fish_type
group by i.fish_type, n.fish_name
order by fish_count desc