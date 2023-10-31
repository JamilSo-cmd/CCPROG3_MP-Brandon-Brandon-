import java.util.ArrayList;

public class MyController {

    public static void main(String[] args) {
        
        Player user = new Player(new Inventory());
        ArrayList<Creature> creatureList1 = new ArrayList<Creature>();

        // adding creatures to list
        creatureList1.add(new Creature("Strawander", "fire", "A", 1));
        creatureList1.add(new Creature("Chocowool", "fire", "B", 1));
        creatureList1.add(new Creature("Parfwit", "fire", "C", 1));
        creatureList1.add(new Creature("Brownisaur", "grass", "D", 1));
        creatureList1.add(new Creature("Frubat", "grass", "E", 1));
        creatureList1.add(new Creature("Malts", "grass", "F", 1));
        creatureList1.add(new Creature("Squirpie", "water", "G", 1));
        creatureList1.add(new Creature("Chocolite", "water", "H", 1));
        creatureList1.add(new Creature("Oshacone", "water", "I", 1));

        MainView mainView = new MainView(user);
        
        
    }
}