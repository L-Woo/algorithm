SELECT DISTINCT c.CAR_ID
FROM CAR_RENTAL_COMPANY_CAR AS c
JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY AS h
ON c.CAR_ID = h.CAR_ID
WHERE c.CAR_TYPE = '세단' AND MONTH(h.START_DATE) = 10
ORDER BY c.CAR_ID DESC;
