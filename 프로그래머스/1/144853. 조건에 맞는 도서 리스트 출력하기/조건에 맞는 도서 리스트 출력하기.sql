-- 코드를 입력하세요
SELECT book_id,Date_format(published_date,'%Y-%m-%d')  from book
where category = '인문' and published_date like '2021%'
order by published_date