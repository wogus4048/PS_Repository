-- 코드를 입력하세요
SELECT p.product_code, (sum(sales_amount) * p.price) as sales
from offline_sale o
join product p 
on o.product_id = p.product_id
group by o.product_id
order by sales desc , p.product_code