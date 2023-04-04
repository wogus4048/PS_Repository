-- 코드를 입력하세요

SELECT c.car_id,c.car_type, truncate((daily_fee * 30) * ((100-discount_rate)/100 ),0) as FEE
from CAR_RENTAL_COMPANY_CAR c

join CAR_RENTAL_COMPANY_DISCOUNT_PLAN p
on c.car_type = p.car_type

where 
(c.car_type = 'SUV' or c.car_type = '세단')
and p.duration_type = '30일 이상'
and c.car_id not in 

(select DISTINCT car_id
from CAR_RENTAL_COMPANY_RENTAL_HISTORY 
where start_date <= '2022-11-30' and end_date >= '2022-11-01'
)

and truncate((daily_fee * 30) * ((100-discount_rate)/100 ),0) between 500000 and 2000000

order by FEE desc,car_type,car_id desc

