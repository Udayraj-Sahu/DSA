package Hashing;

import java.util.*;

public class linkedHashSets {
    public static void main(String[] args) {
        HashSet<String> cities = new HashSet();
        cities.add("Delhi");
        cities.add("Mumbai");
        cities.add("Indore");
        cities.add("Jabalpur");
        System.out.println(cities);

        LinkedHashSet<String> lhs = new LinkedHashSet();
        lhs.add("Delhi");
        lhs.add("Mumbai");
        lhs.add("Indore");
        lhs.add("Jabalpur");

        System.out.println(lhs);

        TreeSet<String> ts = new TreeSet();
        ts.add("Delhi");
        ts.add("Mumbai");
        ts.add("Indore");
        ts.add("Jabalpur");
        System.out.println(ts);
    }
}
