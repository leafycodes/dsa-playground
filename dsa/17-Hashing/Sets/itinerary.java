import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class itinerary {
    public static List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, String> ticketsMap = new HashMap<>();
        for (List<String> list : tickets) {
            ticketsMap.put(list.get(0), list.get(1));
        }

        List<String> res = new ArrayList<>();
        String start = getStart(ticketsMap);
        res.add(start);
        for (String key : ticketsMap.keySet()) {
            res.add(ticketsMap.get(start));
            start = ticketsMap.get(start);
        }

        return res;
    }

    private static String getStart(HashMap<String, String> tickets) {
        HashMap<String, String> revTickets = new HashMap<>();
        for (String key : tickets.keySet()) {
            revTickets.put(tickets.get(key), key);
        }

        for (String key : tickets.keySet()) {
            if (!revTickets.containsKey(key)) {
                return key;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        List<List<String>> tickets = new ArrayList<>();
        tickets.add(Arrays.asList("Chennai", "Bengaluru"));
        tickets.add(Arrays.asList("Mumbai", "Delhi"));
        tickets.add(Arrays.asList("Goa", "Chennai"));
        tickets.add(Arrays.asList("Delhi", "Goa"));

        List<String> itineraryList = findItinerary(tickets);
        Iterator<String> it = itineraryList.iterator();
        System.out.print(it.next());
        while (it.hasNext()) {
            System.out.print(" -> " + it.next());
        }

        // for (String city : itineraryList) {
        // System.out.print(city + " -> ");
        // }
        // System.out.println("end");
    }
}