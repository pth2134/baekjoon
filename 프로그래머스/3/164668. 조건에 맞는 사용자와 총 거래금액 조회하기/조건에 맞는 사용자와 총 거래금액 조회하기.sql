-- 코드를 입력하세요
SELECT USER_ID, NICKNAME, sum as TOTAL_SALES
from (
    select writer_id, sum(price) as sum
    from USED_GOODS_BOARD
    where status = 'DONE'
    group by writer_id
    having sum >= 700000
) b 
left join used_goods_user u on b.writer_id = u.user_id
order by TOTAL_SALES