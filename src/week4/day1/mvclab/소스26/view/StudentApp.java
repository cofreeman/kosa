package week4.day1.mvclab.view;

import week4.day1.mvclab.controller.StudentController;

import java.sql.SQLException;
import java.util.Scanner;

public class StudentApp {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        StudentController studentController = new StudentController();
        String name;
        int score;

        while (true) {
            printMenus();
            int menuNo = getMenu(scanner);
            if (menuNo == 1) {
                studentController.printAll();
            } else if (menuNo == 2) {
                System.out.print("학생 이름 : ");
                name = scanner.nextLine();
                System.out.print("점수 : ");
                score = Integer.parseInt(scanner.nextLine());
                studentController.insert(name, score);
            } else if (menuNo == 3) {
                System.out.print("학생 이름 : ");
                name = scanner.nextLine();
                studentController.delete(name);
            } else if (menuNo == 4) {
                System.out.print("학생 이름 : ");
                name = scanner.nextLine();
                System.out.print("점수 : ");
                score = Integer.parseInt(scanner.nextLine());
                studentController.update(name, score);
            } else if (menuNo == 5) {
                System.out.print("학생 이름 : ");
                name = scanner.nextLine();
                studentController.printScore(name);
            } else if (menuNo == 6) {
                break;
            } else {
                throw new NumberFormatException("1~7 사이의 숫자를 입력하세요");
            }
        }
    }

    private static int getMenu(Scanner scanner) {
        try {
            String s = scanner.nextLine();
            return Integer.parseInt(s);
        }catch (NumberFormatException e) {
            System.out.println("메뉴판에는 숫자만 입력해주세요.");
        }
        return 1;
    }

    private static void printMenus() {
        System.out.println("\n처리하려는 기능을 선택하세요.");
        System.out.println("1. 학생 정보 출력");
        System.out.println("2. 학생 정보 입력");
        System.out.println("3. 학생 정보 삭제");
        System.out.println("4. 학생 정보 수정");
        System.out.println("5. 학생 정보 확인");
        System.out.println("6. 종료");
        System.out.print("입력 : ");
    }
}
