-- 들어올떄는 intact였지만 나갈때는 아닌애들
SELECT a.animal_id,a.animal_type,a.name
from animal_ins a
join animal_outs b
on a.animal_id = b.animal_id
where a.sex_upon_intake like 'Intact%'
and b.sex_upon_outcome not like 'Intact%'
order by a.animal_id