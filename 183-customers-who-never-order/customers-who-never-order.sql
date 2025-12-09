# Write your MySQL query statement below
select Customers.name as customers
from customers
left join orders on(Customers.id = Orders.customerId)
where Orders.id is null;