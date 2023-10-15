package Hashing;

import java.util.*;

public class ItrerationOnHashMaps {
    public static void main(String[] args) {
        HashMap<String,Integer> hm = new HashMap<>();
        hm.put("India", 1000);
        hm.put("US", 150);
        hm.put("China", 50);
        hm.put("Nepal", 5);

        //Iterate
        Set<String> keys = hm.keySet();
        System.out.println(keys);

        for (String k : keys) {
            System.out.println("Key="+k+",value="+hm.get(k));
        }
    }
}
