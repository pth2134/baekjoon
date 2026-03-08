-- 코드를 입력하세요
select month(start_date) as MONTH, CAR_ID, count(*) as RECORDS
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where year(start_date) = 2022 and month(start_date) in (8,9,10) and car_id in 
(SELECT car_id
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where year(start_date) = 2022 and month(start_date) in (8,9,10)
group by car_id having count(*) >= 5)
group by month(start_date), car_id
order by month, car_id desc


