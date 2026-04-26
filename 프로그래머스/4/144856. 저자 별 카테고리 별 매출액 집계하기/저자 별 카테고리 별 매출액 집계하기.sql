SELECT 
    b.author_id,
    a.author_name,
    b.category,
    SUM(s.sales * b.price) AS total_sales
FROM book_sales s
JOIN book b
    ON s.book_id = b.book_id
JOIN author a
    ON b.author_id = a.author_id
WHERE s.sales_date >= '2022-01-01'
  AND s.sales_date < '2022-02-01'
GROUP BY b.author_id, a.author_name, b.category
ORDER BY b.author_id, b.category DESC;