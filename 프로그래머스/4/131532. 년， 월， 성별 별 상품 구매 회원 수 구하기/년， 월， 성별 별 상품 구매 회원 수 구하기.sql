-- 코드를 입력하세요
select y as YEAR, m as MONTH, GENDER, count(*) as USERS
from (   
    SELECT user_id, year(sales_date) as y, month(sales_date) as m
    from online_sale
    group by user_id, year(sales_date), month(sales_date)
) s 
left join user_info i
on s.user_id = i.user_id
where gender is not null
group by y,m,gender
order by y, m, gender
