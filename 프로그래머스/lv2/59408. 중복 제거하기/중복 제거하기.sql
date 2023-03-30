-- 코드를 입력하세요

select count(*) from
(SELECT *
from animal_ins
group by name
having name is not null) as c


