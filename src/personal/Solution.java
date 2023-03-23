package personal;

import java.util.ArrayList;
import java.util.HashSet;

public class Solution {
    public static void main(String[] args) {
        HashSet<String> hashSet = new HashSet<>();
        HashSet<AEIP> aeips = new HashSet<>();
        for (AEIP q: AEIP.values()) {
            for (AEIP w: AEIP.values()) {
                for (AEIP e: AEIP.values()) {
                    for (AEIP r: AEIP.values()) {
                        aeips.add(q);
                        aeips.add(w);
                        aeips.add(e);
                        aeips.add(r);
                        if (aeips.size() == 4){
                            hashSet.add(q.toString() + w + e + r);
                        }
                        aeips.clear();
                    }
                }
            }
        }
        System.out.println(hashSet);
    }
}
