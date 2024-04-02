
select to_char(sales_date,'YYYY-MM-DD'),product_id,user_id,sales_amount 
from (select sales_date,product_id,user_id,sales_amount 
from online_sale
union
select sales_date,product_id,NULL user_id,sales_amount 
from offline_sale
)
where to_char(sales_date,'MM') = 3 and to_char(sales_date,'YYYY') = 2022
order by sales_date asc , product_id asc ,user_id asc
