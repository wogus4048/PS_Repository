-- 코드를 입력하세요

select member_name, review_text, date_format(review_date,'%Y-%m-%d')
from member_profile mp
join rest_review r
on mp.member_id = r.member_id
where mp.member_id in (
SELECT member_id
from REST_REVIEW
group by member_id
having count(*) = (SELECT count(*)  
from REST_REVIEW
group by member_id
order by count(*) desc
limit 1)
)
order by review_date,review_text









