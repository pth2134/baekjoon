-- 코드를 작성해주세요
select i.ID, n.FISH_NAME, i.LENGTH
from fish_info i
join (
    select fish_type, max(length) as max_length
    from fish_info
    group by fish_type
) m 
    on i.fish_type = m.fish_type 
    and i.length = m.max_length
left join fish_name_info n 
    on i.fish_type = n.fish_type
order by i.id