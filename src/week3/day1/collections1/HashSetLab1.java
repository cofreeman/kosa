package week3.day1.collections1;

import java.util.HashSet;
import java.util.Random;

public class HashSetLab1 {
    public static void main(String[] args) {
        Random random = new Random();
        HashSet<Integer> hashSet = new HashSet<>();
        while (true) {
            if (hashSet.size() == 10) break;
            hashSet.add(random.nextInt(20) + 10);
        }
        System.out.print("오늘의 로또번호 : ");
        System.out.println(hashSet);

    }
}
