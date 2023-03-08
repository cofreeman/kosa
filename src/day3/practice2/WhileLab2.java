package day3.practice2;

import java.util.Objects;

public class WhileLab2 {
    public static void main(String[] args) {
        while(true){
            int pairNum1 = (int) (Math.random() * 6) + 1;
            int pairNum2 = (int) (Math.random() * 6) + 1;
            if (Objects.equals(pairNum1,pairNum2)){
                System.out.println("게임 끝");
                break;
            }else{
                System.out.println("pairNum1이 pairNum2 보다 " + (pairNum1>pairNum2?"크다":"작다"));
            }
        }
    }
}
