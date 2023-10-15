package Hashing;

import java.util.*;


public class FindJourneyFormTickets {
    public static String getStart(HashMap<String, String> tickets) {
        HashMap<String, String> revMap = new HashMap<>();
        for (String key : tickets.keySet()) {
            revMap.put(tickets.get(key), key);
        }
        for (String key : tickets.keySet()) {
            if (!revMap.containsKey(key))
                return key;
        }
        return null;
    }

    public static void main(String[] args) {
        HashMap<String, String> tickets = new HashMap<>();
        tickets.put("Chennai", "Bengaluru");
        tickets.put("Mumbai", "Delhi");
        tickets.put("Goa", "Chennai");
        tickets.put("Delhi", "Goa");

        String Start = getStart(tickets);
        System.out.print (Start);
        for(String key : tickets.keySet()){
            System.out.print(" -> " + tickets.get(Start));
            Start = tickets.get(Start);
        }
    }
}
