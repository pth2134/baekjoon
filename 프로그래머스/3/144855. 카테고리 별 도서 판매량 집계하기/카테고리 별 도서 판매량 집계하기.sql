-- 코드를 입력하세요
SELECT CATEGORY, sum(TOTAL_SALES) as TOTAL_SALES
from book b
left join (
    select book_id, sum(sales) as total_sales
    from book_sales
    where sales_date < '2022-02-01' and sales_date >= '2022-01-01'
    group by book_id
    ) s 
    on b.book_id = s.book_id
group by category
order by category