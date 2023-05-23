select fp.product_id,fp.product_name,  sum(fo.amount*fp.price) as total_sales
from food_product fp
join food_order fo
on fp.product_id = fo.product_id
# where fo.produce_date like '2022-05%'
where date_format(fo.produce_date,'%Y-%m-%d') between '2022-05-01' and '2022-05-31'
group by fp.product_id
order by total_sales desc , fp.product_id asc


# 











# select ff.product_id,ff.product_name,(f.total * ff.price) as TOTAL_SALES
# from food_product ff
# join (
# SELECT product_id , sum(amount) as total
# from food_order
# where PRODUCE_DATE like '2022-05%'
# group by product_id
# ) as f
# on ff.product_id = f.product_id
# order by TOTAL_SALES desc, ff.product_id