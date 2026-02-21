-- 코드를 작성해주세요
SELECT
    YEAR(e.differentiation_date) AS YEAR, 
    m.max_size - e.size_of_colony AS YEAR_DEV,
    e.id AS ID                              
FROM ecoli_data e
JOIN (
    SELECT 
        YEAR(differentiation_date) AS year,
        MAX(size_of_colony) AS max_size               
    FROM ecoli_data
    GROUP BY YEAR(differentiation_date)
) m
ON YEAR(e.differentiation_date) = m.year 
ORDER BY 
    YEAR ASC,
    YEAR_DEV ASC;