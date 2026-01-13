# Write your MySQL query statement below

WITH 
  RankedEmployees as(
    select *, dense_rank() over(order by salary desc) as rank_no
    from Employee)
select max(salary) as SecondHighestSalary
from RankedEmployees
where rank_no=2;