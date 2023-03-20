package week3.day1.collections1;

import java.util.LinkedList;

class Person{
    private String name;

    Person(String name) {
        this.name = name;
    }

    public String getInfo(){
        return name;
    }
}
class Friend extends Person {
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

public class LinkedListLab1{
    public static void main(String[] args) {
        Friend friend1 = new Friend("최정우1","01053178395","jwoo1016@naver.com");
        Friend friend2 = new Friend("최정우2","01053178395","jwoo1016@naver.com");
        Friend friend3 = new Friend("최정우3","01053178395","jwoo1016@naver.com");
        Friend friend4 = new Friend("최정우4","01053178395","jwoo1016@naver.com");
        Friend friend5 = new Friend("최정우5","01053178395","jwoo1016@naver.com");
        LinkedList<Friend> friends = new LinkedList<>();
        friends.add(friend1);
        friends.add(friend2);
        friends.add(friend3);
        friends.add(friend4);
        friends.add(friend5);
        System.out.println("이름   전화번호       메일주소");
        for (Friend friend : friends) {
            System.out.println(friend.getInfo());
        }
    }
}
