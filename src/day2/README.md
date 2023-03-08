### ==
int num1 = 1;<br>
double num2 = 1.0;<br>
boolean result = (num1 == num2);<br>
result 는 true 다.

float num1 = 0.1f;<br>
double num2 = 0.1d;<br>
boolean result1 = (num1 == num2);<br>
boolean result2 = (num1 == (float)num2);<br>
result1 은 false 고 result2 는 true 다.

result 가 true 인 이유

int 타입의 값 1과 double 타입의 값 1.0은 값이 같지만 타입이 다릅니다. 
그러나, 자바에서는 두 값의 타입이 다르더라도 자동으로 타입을 변환하여 비교를 수행합니다.

result1 이 false 인 이유 

float 타입 변수 a가 double 타입으로 자동 형 변환되어 비교 연산이 수행됩니다. 이때, float 타입의 값 1.0f와 double 타입의 값 1.0d는 일치하지 않기 때문에 결과적으로 boolean 타입 변수 result에는 false가 할당됩니다.
###조건제어문
if,switch

###반복제어문
for, while,do~ while
for: 반복횟수를 이미 알고 있을 때.배열이나 컬렉션과 같으 데이터들의 뭈음으로 반복
while:어떠한 조건이 만족되는 동안 반복,무한루프

###분기제어문
break, continue

### 논리 연산자,비트 연산자
논리연산자: &&, ||

비트연산자: &, |

AND 연산자 (&): 두 비트가 모두 1일 경우에만 1을 반환합니다.

OR 연산자 (|): 두 비트 중에 하나 이상이 1일 경우 1을 반환합니다.

XOR 연산자 (^): 두 비트가 서로 다를 경우 1을 반환합니다.

NOT 연산자 (~): 단항 연산자로서, 비트를 반전시킵니다.

왼쪽 시프트 연산자 (<<): 비트를 왼쪽으로 이동시킵니다.

오른쪽 시프트 연산자 (>>): 비트를 오른쪽으로 이동시킵니다. 부호 비트는 유지됩니다.

부호 없는 오른쪽 시프트 연산자 (>>>): 비트를 오른쪽으로 이동시킵니다. 부호 비트는 0으로 채워집니다.

### for문 변수 선언

