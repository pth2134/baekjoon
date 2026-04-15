-- 코드를 작성해주세요
select FISH_COUNT, MAX_LENGTH, FISH_TYPE
from (
    select fish_type, count(*) as fish_count, avg(ifnull(length,10)) as avl, max(length) as max_length
    from fish_info
    group by fish_type
    ) f
where f.avl >= 33
order by fish_type
