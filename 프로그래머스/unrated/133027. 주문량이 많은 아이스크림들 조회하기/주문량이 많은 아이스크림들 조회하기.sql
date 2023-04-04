-- 코드를 입력하세요
SELECT f.flavor
from first_half f
join (select flavor, sum(total_order) as total
from july
group by flavor) as ff
on f.flavor = ff.flavor
order by (total_order + total) desc
limit 3


