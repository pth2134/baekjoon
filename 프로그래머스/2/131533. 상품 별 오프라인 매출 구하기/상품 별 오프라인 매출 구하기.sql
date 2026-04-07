-- 코드를 입력하세요
SELECT PRODUCT_CODE, price * IFNULL(s.total_sales, 0) as SALES
from product p 
left join (
    select product_id ,sum(sales_amount) as total_sales
    from offline_sale
    group by product_id
    ) s
    on p.product_id = s.product_id
order by sales desc, p.product_code