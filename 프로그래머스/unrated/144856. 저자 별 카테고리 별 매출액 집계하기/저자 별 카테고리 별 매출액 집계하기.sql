-- 코드를 입력하세요
# SELECT *
# from book b
# join author a
# on b.author_id = a.author_id
# join book_sales bs
# on b.book_id = bs.book_id
# group by date_format(bs.sales_date,'%Y-%m')
# having bs.sales_date like '2022-01%'

# b.author_id, a.author_name,b.category, (sum(sales) * price) as total_sales


select b.author_id, a.author_name,b.category, sum(sales * b.price) as total_sales
from book_sales bs
join book b 
on b.book_id = bs.book_id 
join author a
on b.author_id = a.author_id
where month(bs.sales_date) = 1 and year(bs.sales_date) = 2022
group by a.author_id,b.category
order by b.author_id, b.category desc

# join 전에 where를 하려고했는데 안됬다. join후에 where를 해야함..

