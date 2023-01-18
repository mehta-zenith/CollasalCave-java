import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CollasalCaveMain {
    public static void main(String args[]) {
        Map<Integer, Location> gameMap = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        gameMap.put(0, new Location(0, "You are watching hashmap in Action!", null));

        Map<String, Integer> tempExits = new HashMap<>();

        tempExits.put("W", 2);
        tempExits.put("E", 3);
        tempExits.put("S", 4);
        gameMap.put(1, new Location(1, "Cooking at home...", tempExits));

        tempExits = new HashMap<>();
        tempExits.put("N", 5);
        tempExits.put("S", 6);
        gameMap.put(2, new Location(2, "Building Gate with 2 exits one left and other takes me to a circle", tempExits));

        tempExits = new HashMap<>();
        tempExits.put("W", 1);
        // tempExits.put("Q", 0);
        gameMap.put(3, new Location(3, "My dad's work place where I can demand whatever is needed, but he always takes me to one place, find it where....", tempExits));

        tempExits = new HashMap<>();
        tempExits.put("E", 3);
        // tempExits.put("Q", 0);
        gameMap.put(4, new Location(4, "Made a cool store to TC at Thane Station", tempExits));

        tempExits = new HashMap<>();
        tempExits.put("E", 7);
        // tempExits.put("Q", 0);
        gameMap.put(5, new Location(5, "Take me to learn something....", tempExits));

        tempExits = new HashMap<>();
        tempExits.put("N", 2);
        tempExits.put("E", 4);
        // tempExits.put("Q", 0);
        gameMap.put(6, new Location(6, "Circle with 2 exits one takes me back....", tempExits));

        tempExits = new HashMap<>();
        tempExits.put("E", 3);
        // tempExits.put("Q", 0);
        gameMap.put(7, new Location(7, "Place Where you find treasure....", tempExits));

        Map<String, String> vocab = new HashMap<>();
        vocab.put("QUIT", "Q");
        vocab.put("BORED", "Q");
        vocab.put("BORING", "Q");
        vocab.put("NORTH", "N");
        vocab.put("SOUTH", "S");
        vocab.put("EAST", "E");
        vocab.put("WEST", "W");
        vocab.put("LEFT", "W");
        vocab.put("RIGHT", "E");
        vocab.put("SUN RISE", "E");
        vocab.put("SUNSET", "W");        

        int loc = 1;

        while(true) {
            Location currentLocation = gameMap.get(loc);
            System.out.println(currentLocation.getDescription());
            if(loc == 0) {
                break;
            }

            Map<String, Integer> exits = currentLocation.getExits();

            System.out.println("Available Exits: ");
            for(String exit : currentLocation.getExitPoints()) {
                System.out.print(exit + ", ");
            }

            System.out.println();

            System.out.println("Enter the direction in which you want to move: ");
            String direction = scanner.nextLine().toUpperCase();

            System.out.println();

            if(direction.length() > 1) {
                String[] words = direction.split(" ");
                for(String word : words) {
                    if(vocab.containsKey(word)) {
                        direction = vocab.get(word);
                        break;
                    }
                }
            } else if(direction.length() == 0) {
                System.out.println("Need input! Please provide something.");
                continue;
            }

            // direction = S/N/E/any other illegal data
            if(currentLocation.hasExit(direction)) {
                loc = exits.get(direction);
            } else {
                System.out.println("I don't have such direction! Sorry!");
            }
        }
        System.out.println("Available Exits: ");
        for(String exit : gameMap.get(1).getExits().keySet()) {
            System.out.print(exit + ", ");
        }
    }
}

// has a => association => inner class
// is a relationship = > inheritance 