package week2.day1.practice;

import week1.day5.practice.MethodLab5;

class SalaryExpr {
    int bonus;

    public SalaryExpr() {
        this.bonus = 0;
    }

    public SalaryExpr(int bonus) {
        this.bonus = bonus;
    }

    int getSalary(int grade) {
        if (grade == 1) {
            return bonus + 100;
        } else if (grade == 2) {
            return bonus + 90;
        } else if (grade == 3) {
            return bonus + 80;
        } else if (grade == 4) {
            return bonus + 70;
        }
        return bonus;
    }
}
public class SalaryExam {
    public static void main(String[] args) {
        int month = MethodLab5.getRandom(12);
        int grade = MethodLab5.getRandom(4);

        if (month% 2 == 0){
            SalaryExpr salaryExpr = new SalaryExpr(100);
            System.out.printf("%d 월 %d 등급의 월급은 %d 입니다.\n",month,grade,salaryExpr.getSalary(grade));
        }else{
            SalaryExpr salaryExpr = new SalaryExpr();
            System.out.printf("%d 월 %d 등급의 월급은 %d 입니다.\n",month,grade,salaryExpr.getSalary(grade));
        }

    }
}
