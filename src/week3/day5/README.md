    

## SQL like 문
'A' : A 문자를 찾는다.<br> 
'A%' : A부터 시작되는 문자를 찾는다.<br>
'%A' : A로 끝나는 문자를 찾는다.<br>
'%A%' : A가 포함된 문자를 찾는다.<br>
'A_' : A로 시작되고 뒤에 한 글자가 있는 문자를 찾는다.<br>
'_A' : A로 끝나는 두글자 문자를 찾는다.<br> 
'_A_' : A 가 중간에 있는 세글자 문자를 찾는다.<br>
'__A': A가 마지막 글자인 세글자 문자를 찾는다.<br>

## SQL order by 문
> row 를 sorting 하는 구문이다.

데이터베이스는 자료처리에 아주 좋다.

서버에게 sorting 을 시키는 대신 db 서버에게 sorting 을 시켜라.

## group by 문
같은 데이터 값을 가진 row들 에 대한 정보를 얻기 위해 사용

count(*) : 그룹단위로 집계한다.

## 서브쿼리로 할까.... join 으로 할까.....
최종 select 하는 결과가 두 테이블에 나누어져 존재한다. -> join

두 테이블에 나누어져 있지 않다 -> 서브쿼리

## mysql 데이터 타입

### datetime column
now(), 2011-03-01,2011-3-1 같은 형태로 넣을 수 있다.

### blob( B inary L arge _OB_ ject)
사진이나 동영상 같은 용량이 큰 바이너리 파일을 넣을 수 있는 데이터 타입

## preparedStatement
statement 는 sql이 고정이다.
가변 sql 을 쓰려면 preparedStatement 를 쓰는게 좋다. 