-- 코드를 입력하세요
SELECT YEAR(SALES_DATE) YEAR, 
MONTH(SALES_DATE) MONTH, GENDER, COUNT(DISTINCT o.USER_ID) USERS 
FROM USER_INFO as u
JOIN ONLINE_SALE as o
ON u.USER_ID = o.USER_ID
WHERE GENDER IS NOT NULL
GROUP BY YEAR, MONTH, GENDER
ORDER BY YEAR ASC, MONTH ASC, GENDER ASC
