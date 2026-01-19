-- 코드를 입력하세요
SELECT PT_NAME, PT_NO, GEND_CD, AGE, ifnull(p.TLNO , 'NONE') as TLNO
from patient p
where p.gend_cd = 'W'
and p.age <= 12
order by p.age desc, p.pt_name asc