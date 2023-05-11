



select 
year(o.sales_date) as year, 
month(o.sales_date) as month,
count(distinct o.user_id) as puchased_users,
round( count(distinct o.user_id) / 
      (SELECT count(*)
        from user_info 
    where joined like '2021%') ,1) as puchased_ratio
from user_info u
join online_sale o
on u.user_id = o.user_id
where u.joined like '2021%'
group by year , month




