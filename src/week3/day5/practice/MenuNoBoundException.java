package week3.day5.practice;

public class MenuNoBoundException extends Exception{
    public MenuNoBoundException() {
        super("메뉴 숫자 잘선택하세요");
    }
}
