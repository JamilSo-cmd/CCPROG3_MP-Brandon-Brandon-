import java.util.ArrayList;

public class MyController {

    public static void main(String[] args) {
        
        Player user = new Player(new Inventory());
        ArrayList<Creature> creatureList1 = new ArrayList<Creature>();
        ArrayList<Creature> creatureList2 = new ArrayList<Creature>();
        ArrayList<Creature> creatureList3 = new ArrayList<Creature>();
        // adding creatures to list
        
        //area1 
        creatureList1.add(new Creature("Strawander", "fire", "A", 1));
        creatureList1.add(new Creature("Chocowool", "fire", "B", 1));
        creatureList1.add(new Creature("Parfwit", "fire", "C", 1));
        creatureList1.add(new Creature("Brownisaur", "grass", "D", 1));
        creatureList1.add(new Creature("Frubat", "grass", "E", 1));
        creatureList1.add(new Creature("Malts", "grass", "F", 1));
        creatureList1.add(new Creature("Squirpie", "water", "G", 1));
        creatureList1.add(new Creature("Chocolite", "water", "H", 1));
        creatureList1.add(new Creature("Oshacone", "water", "I", 1));
        //area2
        creatureList2.add(new Creature("Strawleon", "fire", "A", 2));
        creatureList2.add(new Creature("Chocofluff", "fire", "B", 2));
        creatureList2.add(new Creature("Parfure", "fire", "C", 2));
        creatureList2.add(new Creature("Chocosaur", "grass", "D", 2));
        creatureList2.add(new Creature("Golberry", "grass", "E", 2));
        creatureList2.add(new Creature("Kirlicake", "grass", "F", 2));
        creatureList2.add(new Creature("Tartortle", "water", "G", 2));
        creatureList2.add(new Creature("Chocolish", "water", "H", 2));
        creatureList2.add(new Creature("Dewice", "water", "I", 2));
        //area3
        creatureList3.add(new Creature("Strawizard", "fire", "A", 3));
        creatureList3.add(new Creature("Candaros", "fire", "B", 3));
        creatureList3.add(new Creature("Parfelure", "fire", "C", 3));
        creatureList3.add(new Creature("Fudgasaur", "grass", "D", 3));
        creatureList3.add(new Creature("Croberry", "grass", "E", 3));
        creatureList3.add(new Creature("Velvevoir", "grass", "F", 3));
        creatureList3.add(new Creature("Piestoise", "water", "G", 3));
        creatureList3.add(new Creature("Icesundae", "water", "H", 3));
        creatureList3.add(new Creature("Samurcone", "water", "I", 3));

        MainView mainView = new MainView(user);
        
        
    }
}