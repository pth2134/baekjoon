-- 코드를 입력하세요
SELECT CAR_ID, round(avg(duration),1) as AVERAGE_DURATION
from (
    select car_id, datediff(end_date, start_date) + 1 as duration
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY
) d
group by car_id having average_duration >= 7
order by average_duration desc, car_id desc