-- 코드를 입력하세요

select ff.product_id,ff.product_name,(f.total * ff.price) as TOTAL_SALES
from food_product ff
join (
SELECT product_id , sum(amount) as total
from food_order
where PRODUCE_DATE like '2022-05%'
group by product_id
) as f
on ff.product_id = f.product_id
order by TOTAL_SALES desc, ff.product_id


