package Hashing;
import java.util.*;
public class hashMap {
    public static void main(String[] args) {
        HashMap<String,Integer> hm  = new HashMap<>();
        //put
       hm.put("India", 100);
       hm.put("China", 150);
       hm.put("US", 50);

       System.out.println(hm);


      int pop = hm.get("India");
      System.out.println(pop);

      //get
      System.out.println(hm.get("Indore"));
   
      //containesKey
      System.out.println(hm.containsKey("India"));
      System.out.println(hm.containsKey("Indore"));

      //Remove
      System.out.println(hm.remove("US"));

      System.out.println(hm);
    }
}
