SELECT TITLE, a.BOARD_ID, REPLY_ID, b.WRITER_ID, b.CONTENTS, DATE_FORMAT(b.CREATED_DATE, '%Y-%m-%d') as CREATED_DATE
from used_goods_reply as b left join used_goods_board as a on a.board_id = b.board_id
where a.created_date >= '2022-10-01' and a.created_date <= '2022-10-31'
order by b.created_date asc, title asc