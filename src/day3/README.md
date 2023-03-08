### while문
break 만나면 구문을 벗어난다.
### 중첩 반복문에서의 break
break 구문이 실행되면 가장 가까운 반복 구문 하나를 벗어난다.
### break 에 라벨 붙히기
라벨을 붙힌 곳의 for 문 실행을 종료한다.
```
public static void main(String[] args) {
    int result;
    unico: for(int dan = 1; dan <= 9; dan++) {
        for(int num=1; num <= 9; num++) {
            result = dan*num;
            if (result >= 30)
                break unico;
            System.out.print(dan + "x" + num + "=" + result + "\t");
        }
        System.out.println();
    }		
}
```
