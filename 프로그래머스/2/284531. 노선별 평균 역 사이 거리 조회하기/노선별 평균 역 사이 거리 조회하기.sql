-- 코드를 작성해주세요
select ROUTE,
    concat(round(SUM(d_between_dist), 1), 'km') AS TOTAL_DISTANCE,
    concat(round(AVG(d_between_dist), 2), 'km') AS AVERAGE_DISTANCE
from subway_distance
group by route
order by ROUND(SUM(D_BETWEEN_DIST),1) DESC;