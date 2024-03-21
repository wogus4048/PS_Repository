-- 코드를 입력하세요
SELECT b.title,b.board_id,r.reply_id,r.writer_id,r.contents,Date_format(r.created_date,'%Y-%m-%d') 
from USED_GOODS_BOARD b
join USED_GOODS_REPLY r
on b.board_id = r.board_id
where b.created_date >= '2022-10-01' and b.created_date < '2022-11-01'
order by r.created_date , b.title


# where b.created_date like '2022-10-%'
# where b.created_date between '2022-10-01' and '2022-11-01'