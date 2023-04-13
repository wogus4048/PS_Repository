-- 코드를 입력하세요
SELECT o.animal_id, o.name
from animal_outs o
left join animal_ins i
on o.animal_id = i.animal_id
where i.intake_condition is null
order by o.animal_id