package week4.day1.mvclab.model;

public class StudentDTO {
    private String name;
    private int score;

    public StudentDTO(String name) {
        this.name= name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public StudentDTO(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return name + "학생의 점수는 " + score + " 입니다.";
    }
}
