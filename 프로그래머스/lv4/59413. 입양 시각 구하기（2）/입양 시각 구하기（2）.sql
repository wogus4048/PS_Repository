-- 코드를 입력하세요

with recursive time as
(
    select 0 as hour # 초기값
    union all
    select hour +1 # 반복문
    from time
    where hour < 23
    
)
select t.hour as hour , if(count is null , 0,count) as count
 from
 (
    select hour(datetime) as hour , count(animal_id) as count
    from animal_outs a
    group by hour
 )as a

right join time t
on  a.hour = t.hour

order by t.hour






# with를 이용하여 가상 테이블을 만들수 있음 ,recursive를 이용하여 반복문을 통해 가상테이블생성 가능
# 함수를 사용하면 별칭을 등록해주자. hour(datetime)를 having에서 쓰려고하니까 안되고, 별칭써주니까 됨..