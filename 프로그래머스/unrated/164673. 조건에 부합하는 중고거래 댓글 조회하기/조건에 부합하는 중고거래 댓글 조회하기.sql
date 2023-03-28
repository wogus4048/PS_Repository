-- 코드를 입력하세요
SELECT 
u.title,
r.board_id,
r.reply_id,
r.writer_id,
r.contents,
date_format(r.created_date,'%Y-%m-%d') 
from USED_GOODS_BOARD u
join used_goods_reply r
on u.board_id = r.board_id
where u.created_date like '2022-10-%'
order by r.created_date,u.title

