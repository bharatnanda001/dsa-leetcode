# Write your MySQL query statement below
with 
    ProductToYear as(
        select product_id , MIN(year) as year
        from Sales
        group by 1
    )
select 
    Sales.product_id,
    ProductToYear.year AS first_year,
    Sales.quantity,
    Sales.price
from Sales
Inner join ProductToYear
    using(product_id, year);