-- 코드를 입력하세요
SELECT CONCAT('/home/grep/src/', f.board_id, '/', file_id, file_name, file_ext) as FILE_PATH
from USED_GOODS_FILE f
JOIN (
    SELECT board_id
    FROM USED_GOODS_BOARD
    ORDER BY views DESC
    LIMIT 1
) b ON f.board_id = b.board_id
order by file_id desc