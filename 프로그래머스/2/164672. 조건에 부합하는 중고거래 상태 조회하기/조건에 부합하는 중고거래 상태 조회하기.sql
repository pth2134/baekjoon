-- 코드를 입력하세요
SELECT BOARD_ID, WRITER_ID, TITLE, PRICE,
    case when status = 'DONE' then '거래완료'
        when status = 'SALE' then '판매중'
        else '예약중'
    end as STATUS
from used_goods_board
WHERE CREATED_DATE >= '2022-10-05 00:00:00'
  AND CREATED_DATE <  '2022-10-06 00:00:00'
order by board_id desc