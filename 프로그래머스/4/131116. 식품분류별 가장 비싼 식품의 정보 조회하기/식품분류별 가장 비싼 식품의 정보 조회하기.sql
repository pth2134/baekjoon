-- 코드를 입력하세요
select c.CATEGORY, c.MAX_PRICE, PRODUCT_NAME
from (
    SELECT category, max(price) as MAX_PRICE
    from food_product
    where category in ('과자','국','김치','식용유')
    group by category
) c
left join food_product p
on c.category = p.category and c.max_price = p.price
order by price desc