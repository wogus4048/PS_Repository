-- 코드를 입력하세요
SELECT ANIMAL_TYPE	, if(NAME is null,'No name',NAME) as NAME	,SEX_UPON_INTAKE
from animal_ins
