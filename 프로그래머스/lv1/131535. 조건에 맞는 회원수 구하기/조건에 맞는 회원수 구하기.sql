-- 코드를 입력하세요
SELECT count(*)
from user_info
where age >= 20 and age <= 29
and date_format(joined,'%Y') = '2021'

