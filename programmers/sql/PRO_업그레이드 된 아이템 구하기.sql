-- 코드를 작성해주세요
SELECT i.ITEM_ID, ITEM_NAME, RARITY
FROM ITEM_INFO as i
JOIN ITEM_TREE as t
ON i.ITEM_ID = t.ITEM_ID
WHERE t.PARENT_ITEM_ID IN (SELECT ITEM_ID
                          FROM ITEM_INFO
                          WHERE RARITY = 'RARE')
ORDER BY i.ITEM_ID DESC
