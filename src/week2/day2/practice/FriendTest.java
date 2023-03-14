package week2.day2.practice;

class Person{
    private String name;

    Person(String name) {
        this.name = name;
    }

    public String getInfo(){
        return name;
    }
}
class Friend extends Person{
    private String phoneNumber;
    private String email;

    public Friend(String name, String phoneNumber , String email) {
        super(name);
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    @Override
    public String getInfo() {
        return super.getInfo() + " " + phoneNumber + " " + email;
    }
}

public class FriendTest{
    public static void main(String[] args) {
        Friend[] friends = new Friend[5];
        Friend friend1 = new Friend("최정우1","01053178395","jwoo1016@naver.com");
        Friend friend2 = new Friend("최정우2","01053178395","jwoo1016@naver.com");
        Friend friend3 = new Friend("최정우3","01053178395","jwoo1016@naver.com");
        Friend friend4 = new Friend("최정우4","01053178395","jwoo1016@naver.com");
        Friend friend5 = new Friend("최정우5","01053178395","jwoo1016@naver.com");
        friends[0] = friend1;
        friends[1] = friend2;
        friends[2] = friend3;
        friends[3] = friend4;
        friends[4] = friend5;
        System.out.println("이름   전화번호       메일주소");
        for (int i = 0; i < friends.length; i++) {
            System.out.println(friends[i].getInfo());
        }
    }
}
