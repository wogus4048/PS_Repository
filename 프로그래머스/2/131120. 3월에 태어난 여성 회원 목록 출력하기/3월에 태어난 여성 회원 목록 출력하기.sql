-- 코드를 입력하세요
SELECT member_id ,member_name, gender,Date_format(date_of_birth,'%Y-%m-%d')  from MEMBER_PROFILE
where MONTH(date_of_birth) = 3 and tlno is not null and gender='W'
order by member_id