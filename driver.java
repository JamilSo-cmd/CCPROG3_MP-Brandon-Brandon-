
/**
 * <B>>Driver for program<B>
 * 
 * @author Brandon Jaramillo Anthony  
 * @author Brandon Jamil So
 * @version 1.0
 * 
 */
import java.sql.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class driver {

    public static void main(String args[]) {

        int input = 0;
        Scanner scan = new Scanner(System.in);
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

        System.out.println("Greetings "
                + /* player name */ ", Pick your starter! \n\n[1] Strawander\n\n[2] Brownisaur\n\n[3] Squirpie\n\nInput: ");

        // player picks a starter
        while (input < 1 || input > 3) {
            input = scan.nextInt();

            switch (input) {
                case 1:
                    user.addToInventory(new Creature("Strawander", "Fire", "A", 1));
                    user.setActiveCreature(0);
                    break;

                case 2:
                    user.addToInventory(new Creature("Brownisaur", "Grass", "D", 1));
                    user.setActiveCreature(0);
                    break;

                case 3:
                    user.addToInventory(new Creature("Squirpie", "Water", "G", 1));
                    user.setActiveCreature(0);

                default:
                    System.out.println("unknown input, try again: ");

            }
        }
        // Menu start
        input = 0;

        while (input < 1 || input > 4) {
            System.out
                    .println("Menu: \n\n[1] View Inventory\n\n[2] Explore an Area\n\n[3] Evolve Creature\n\n[4] Exit");
            input = scan.nextInt();
            switch (input) {
                case 1: {
                    // program calls user to view inventory
                    user.viewInventory();
                    // program asks if user wants to change active creature
                    input = 0;
                    System.out.println("Do you wish to change active creature?\n\n[1]Yes\n[2]No\n\nInput: ");

                    while (input < 1 || input > 2) {

                        input = scan.nextInt();

                        if (input < 1 || input > 2) {
                            System.out.println("unknown input, try again: ");
                        }

                    }
                    // user asks for index of creature if user wants to change active creature
                    if (input == 1) {

                        System.out.print("Input creature number: ");
                        input = scan.nextInt();
                        user.setActiveCreature(input);

                    }

                    input = 0;
                }
                    break;
                case 2: {
                    // program asks user to choose an area to explore which is referred to as level
                    System.out.println("Enter the level (1, 2, or 3): ");
                    int level = scan.nextInt();

                    Area area = new Area(level, creatureList1);

                    boolean exploring = true;

                    while (exploring) {
                        // Print the map with the player's position
                        int rows = area.getRows();
                        int columns = area.getColumns();
                        int[][] tiles = area.getTiles();
                        int[][] playerPos = user.getPlayerPos(); // Get the player's position

                        for (int y = 0; y < rows; y++) {
                            for (int x = 0; x < columns; x++) {
                                int tile = tiles[y][x];

                                // Check if the current tile is the player's position
                                if (x == playerPos[0][0] && y == playerPos[0][1]) {
                                    System.out.print("P ");
                                } else {
                                    System.out.print(tile + " ");
                                }
                            }
                            System.out.println();
                        }

                        System.out.println("What will you do?\n");

                        // Still have to implement print statements that show only the valid movement
                        // directions which would be in if statements

                        // if(playerPos[0][0] )

                        System.out.println("[5]Exit area");

                        input = scan.nextInt();

                        if (input == 5) {
                            exploring = false;
                        }
                        input = 0;
                    }
                }
                    break;

                case 3:
                    ;
                    break;

                case 4:
                    ;

                default:
                    ;
            }
        }

        scan.close();

    }
}
