package personal;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int solution1 = solution.solution(new int[]{1, 2, 3, 3, 3, 4});
        System.out.println(solution1);
    }
}

class Solution {

    public int solution(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.stream(array).forEach(i -> map.put(i, map.getOrDefault(i, 0) + 1));
        List<Map.Entry<Integer, Integer>> collect = map.entrySet().stream().sorted().collect(Collectors.toList());
        if (collect.size() <= 1 || Objects.equals(collect.get(0).getValue(), collect.get(1).getValue())) return -1;
        return collect.get(0).getKey();
    }
}
