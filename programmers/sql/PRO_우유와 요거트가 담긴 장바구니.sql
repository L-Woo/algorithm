-- 코드를 입력하세요
-- NAME에 Milk, Yogurt 둘 중 하나를 가지고 있는 컬럼들을
-- CART_ID로 그룹핑하여 
-- Milk또는 Yogurt가 두 개 있는 경우를 제외시키기 위해서 중복제거를 하여
-- COUNT가 2개인 CART_ID를 조회
SELECT CART_ID
FROM CART_PRODUCTS
WHERE NAME IN ('Milk', 'Yogurt')
GROUP BY CART_ID
HAVING COUNT(DISTINCT NAME) = 2
