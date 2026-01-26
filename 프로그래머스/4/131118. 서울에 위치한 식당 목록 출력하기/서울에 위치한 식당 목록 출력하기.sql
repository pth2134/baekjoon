-- 코드를 입력하세요
SELECT
    i.REST_ID,                 
    i.REST_NAME,               
    i.FOOD_TYPE,               
    i.FAVORITES,               
    i.ADDRESS,                 
    ROUND(r.score, 2) AS SCORE 
FROM rest_info i
inner JOIN (
    SELECT REST_ID, AVG(REVIEW_SCORE) as score
    FROM rest_review
    GROUP BY REST_ID
) r ON i.REST_ID = r.REST_ID 
WHERE i.address LIKE '서울%'                
ORDER BY
    SCORE DESC,                
    i.FAVORITES DESC;