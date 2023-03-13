package week2.day1.practice2;

import java.util.Scanner;

class GradeExpr{
    private int[] jumsu;

    public GradeExpr(int[] jumsu) {
        this.jumsu = jumsu;
    }
    double getAverage(){
        return (float)getTotal() / jumsu.length;
    }

    int getTotal(){
        int result = 0;
        for (int i: jumsu) {
            result += i;
        }
        return  result;
    }
    int getGoodScore(){
        int max = jumsu[0];
        for (int i : jumsu) {
            if ( i > max) max = i;
        }
        return max;
    }
    int getBadScore(){
        int min = jumsu[0];
        for (int i : jumsu) {
            if ( i < min) min = i;
        }
        return min;
    }

}
public class GradeTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("점수들의 갯수는? : ");
        int[] scoreArr = new int[scanner.nextInt()];
        System.out.println("점수들을 입력하시오 : ");
        for (int i = 0; i < scoreArr.length; i++) {
            scoreArr[i] = scanner.nextInt();
        }
        GradeExpr gradeExpr = new GradeExpr(scoreArr);
        System.out.print("점수들 : ");
        for (int i = 0; i < scoreArr.length; i++) {
            System.out.printf("%d" + (i != scoreArr.length - 1?",":""),scoreArr[i]);
        }
        System.out.println();
        System.out.printf("총점: %d\n",gradeExpr.getTotal());
        System.out.printf("평균: %f\n",gradeExpr.getAverage());
        System.out.printf("최고 점수: %d\n",gradeExpr.getGoodScore());
        System.out.printf("최저 점수: %d\n",gradeExpr.getBadScore());
    }
}
