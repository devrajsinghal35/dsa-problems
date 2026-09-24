# Write your MySQL query statement below
Select name as customers
from customers a
left join orders b
on a.id =b.customerId
where b.customerId is null;