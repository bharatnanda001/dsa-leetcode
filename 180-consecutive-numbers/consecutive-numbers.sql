# Write your MySQL query statement belo
select distinct  l1.num AS ConsecutiveNums
From Logs l1
Join Logs l2 On l1.id = l2.id - 1 And l1.num = l2.num
Join Logs l3 ON l1.id = l3.id - 2 AND l1.num = l3.num;