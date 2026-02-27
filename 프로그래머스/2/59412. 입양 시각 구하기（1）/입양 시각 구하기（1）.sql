-- 코드를 입력하세요
SELECT hour(datetime) as HOUR, count(*) as COUNT
from animal_outs
group by hour(datetime)
having hour < 20 and hour >= 9
order by hour