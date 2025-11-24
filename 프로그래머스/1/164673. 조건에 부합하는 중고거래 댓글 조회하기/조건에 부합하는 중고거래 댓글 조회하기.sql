SELECT TITLE, b.BOARD_ID, REPLY_ID, r.WRITER_ID, r.CONTENTS, date_format(r.created_date, '%Y-%m-%d') as CREATED_DATE
from used_goods_reply as r left join used_goods_board as b on r.board_id = b.board_id
where b.created_date >= '2022-10-01' and b.created_date <= '2022-10-31'
order by r.created_date asc, b.title asc