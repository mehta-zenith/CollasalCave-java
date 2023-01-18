// kabhi bhi koi bhi function me object as an argument jata hai to check karna kya null object gaya to kya hoga 
// While processing the input of directions always validate the input
// we will store in Ignorance list (negative) that which we can make sentence negative.

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Location {
    private final int id;
    private final String description;
    private final Map<String, Integer> exits;

    public Location(int id, String description, Map<String, Integer> exits) {
        this.id = id;
        this.description = description;
        if(exits != null) {
            this.exits = exits;
        } else {
            this.exits = new HashMap<>();
        }

        this.exits.put("Q", 0);
    }

    // public void addExit(String direction, int locationID) {
    //     this.exits.put(direction, locationID);
    // }

    // public void addExit(String direction, Location location) {
    //     this.exits.put(direction, location.id);
    // }

    public int getID() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Integer> getExits() {
        return new HashMap<>(exits);
    }

    public Set<String> getExitPoints() {
        return exits.keySet();
    }

    public boolean hasExit(String direction) {
        return exits.containsKey(direction);
    }
}