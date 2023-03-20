package week3.day1.collections1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class HashMapLab1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Integer> countryAndPopulation = new HashMap<>();
        while(true){
            if (countryAndPopulation.size() >= 5) break;
            System.out.println("나라이름을 입력하세요: ");
            String country = scanner.next();
            System.out.println("인구 수를 입력하세요: ");
            Integer population = scanner.nextInt();
            boolean hasKey = countryAndPopulation.containsKey(country);
            if (hasKey) {
                System.out.printf("나라명 %s는 이미 저장되었습니다.\n",country);
                continue;
            }
            countryAndPopulation.put(country,population);
            System.out.println("저장되었습니다.");
        }
        System.out.print("5개가 모두 입력되었습니다.\n");
        System.out.print("입력된 데이터: ");

        Iterator<Map.Entry<String, Integer>> iterator = countryAndPopulation.entrySet().iterator();

        while(iterator.hasNext()){
            Map.Entry<String, Integer> next = iterator.next();
            System.out.printf("%s(%d)",next.getKey(),next.getValue());
            if (iterator.hasNext()) System.out.print(",");
        }

    }
}
