-- 코드를 입력하세요
# SELECT ri.rest_id,rest_name,food_type,favorites,address, round(avg(review_score),2)as rvg 
# from rest_info ri
# join rest_review rv
# on ri.rest_id = rv.rest_id
# where address like '서울%'
# order by rvg desc, favorites desc

SELECT ri.rest_id,rest_name,food_type,favorites,address, round(avg(review_score),2)as rvg 
from rest_info ri
join rest_review rv
on ri.rest_id = rv.rest_id
where address like '서울%'
group by ri.rest_id
order by rvg desc, favorites desc