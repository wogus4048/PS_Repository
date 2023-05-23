select m.member_name,r.review_text,date_format(r.review_date,'%Y-%m-%d') as review_date
from member_profile m
join rest_review r
on m.member_id = r.member_id
where m.member_id in(select member_id
from rest_review
group by member_id
having count(*) = (
 select count(*) 
from rest_review
group by member_id
order by count(*)  desc
    limit 1
))
order by review_date asc , review_text asc























# select member_name, review_text, date_format(review_date,'%Y-%m-%d')
# from member_profile mp
# join rest_review r
# on mp.member_id = r.member_id
# where mp.member_id in (
# SELECT member_id
# from REST_REVIEW
# group by member_id
# having count(*) = (SELECT count(*)  
# from REST_REVIEW
# group by member_id
# order by count(*) desc
# limit 1)
# )
# order by review_date,review_text