-- 코드를 입력하세요
SELECT a.animal_id,a.name
from animal_ins a
join animal_outs o
on a.animal_id = o.animal_id
where a.datetime > o.datetime
order by a.datetime