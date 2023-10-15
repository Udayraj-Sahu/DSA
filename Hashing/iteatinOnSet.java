package Hashing;
import java.util.*;
public class iteatinOnSet {
    public static void main(String[] args) {
        HashSet<String> cities = new HashSet();
        cities.add("Delhi");
        cities.add("Mumbai");
        cities.add("Indore");
        cities.add("Jabalpur");


        // Iterator it = cities.iterator();
        // while(it.hasNext()){
        //     System.out.println(it.next());
        // }
        for (String s : cities) {
            System.out.println(s);
        }
    }
}
