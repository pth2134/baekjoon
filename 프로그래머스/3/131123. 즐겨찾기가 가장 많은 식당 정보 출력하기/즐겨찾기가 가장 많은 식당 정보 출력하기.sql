-- 코드를 입력하세요
SELECT r.FOOD_TYPE, REST_ID, REST_NAME, r.FAVORITES
from rest_info r
inner join (
    select food_type ,max(favorites) as favorites
    from rest_info
    group by food_type) i
on r.food_type = i.food_type and r.favorites = i.favorites
order by food_type desc
