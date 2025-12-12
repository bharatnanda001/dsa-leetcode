# Write your MySQL query statement below
select SalesPerson.name
from Orders
inner join company
    on  (Orders.com_id =Company.com_id and Company.name='RED')
right join SalesPerson
    using(sales_id)
where orders.sales_id is null; 