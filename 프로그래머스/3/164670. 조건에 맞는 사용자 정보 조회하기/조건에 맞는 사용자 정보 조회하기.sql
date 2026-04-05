-- 코드를 입력하세요
SELECT u.USER_ID, 
NICKNAME, concat(city, ' ', street_address1, ' ', street_address2) as '전체주소', 
CONCAT(
        SUBSTRING(u.TLNO, 1, 3), '-', 
        SUBSTRING(u.TLNO, 4, 4), '-', 
        SUBSTRING(u.TLNO, 8, 4)
    ) AS '전화번호'
from (
    select writer_id
    from used_goods_board
    group by writer_id 
    having count(*) >= 3
) w left join used_goods_user u
on w.writer_id = u.user_id
order by w.writer_id desc