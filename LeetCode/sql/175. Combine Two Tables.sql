SELECT p.firstName, p.lastName, a.city, a.state
FROM Person as p
left JOIN Address as A
ON A.personId = p.personId
