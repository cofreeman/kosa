package week1.day4.practice;

public class LottoMachine1 {
    public static void main(String[] args) {
        int[] arr = new int[6];
        loop: while(true){
            // 빠져 나간다.
            if (arr[5] !=0) break;
            // 랜덤 수 만들기
            int randNum = (int)(Math.random() * 45) + 1;
            // for 문을 돌려서 해당 숫자가 배열에 있는지 확인한다.
            for (int i = 0; i < arr.length; i++) {
                // 만약 조회한 인덱스의 숫자가 랜덤 넘버와 같으면 다시 while문 돌린다.
                if (randNum == arr[i]){
                    continue loop;
                }
                // 만약 조회한 인덱스의 숫자가
                if (arr[i] == 0) {
                    arr[i] = randNum;
                    break;
                }
            }

        }
        System.out.print("오늘의 로또 번호 - ");
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) System.out.println(arr[i]);
            else System.out.print(arr[i] + ",");
        }
    }
}
