package week3.day5.practice;

enum BookKindNo {
    b01("프로그래밍언어"),b02("웹 프로그래밍"),b03("빅 데이터"),b04("데이터베이스"),b05("인프라");
    private final String name;
    BookKindNo(String name){
        this.name = name;
    }
    String returnName(){
        return name;
    }
}

