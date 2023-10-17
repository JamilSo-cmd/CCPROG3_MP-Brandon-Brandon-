
/**
 * <B>>Driver for program<B>
 * 
 * @author Brandon Jaramillo Anthony  
 * @author Brandon Jamil So
 * @version 1.0
 * 
 */
//import java.sql.Array;
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

        System.out.println("What is your name?");

        String userName = scan.nextLine();

        System.out.println("Greetings "
                + userName + ", Pick your starter! \n\n[1] Strawander\n\n[2] Brownisaur\n\n[3] Squirpie\n\nInput: ");

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
                    boolean encounter = false;

                    user.resetPlayerPos();

                    while (exploring) {
                        // Print the area chosen with tiles represented as "0" and include the player's
                        // position to be represented as "P"
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

                        String exploreAction = "";

                        if (playerPos[0][1] == 0) {
                        } else {
                            System.out.println("[U]Move UP");
                        }

                        if (playerPos[0][1] == rows - 1) {
                        } else {
                            System.out.println("[D]Move DOWN");
                        }

                        if (playerPos[0][0] == 0) {
                        } else {
                            System.out.println("[L]Move LEFT");
                        }

                        if (playerPos[0][0] == columns - 1) {
                        } else {
                            System.out.println("[R]Move RIGHT");
                        }

                        System.out.println("[E]EXIT area");

                        exploreAction = scan.nextLine();

                        if (exploreAction.equals("U")) {

                            encounter = user.moveUp();

                        } else if (exploreAction.equals("D")) {

                            encounter = user.moveDown();

                        } else if (exploreAction.equals("L")) {

                            encounter = user.moveLeft();

                        } else if (exploreAction.equals("R")) {

                            encounter = user.moveRight();

                        } else if (exploreAction.equals("E")) {

                            exploring = false;

                        }

                        exploreAction = "";

                        if (encounter) {
                            Creature activeCreature = user.getActiveCreature();
                            Creature wildCreature = area.getWildCreature(); // Select a random creature
                            boolean caught = false;
                            String encounterAction = "";

                            System.out.println("A wild " + wildCreature.getName() + " appeared!");
                            System.out.println("This is an evolution level " + wildCreature.getEvolutionLv() + " "
                                    + wildCreature.getType() + " type of the " + wildCreature.getFamily()
                                    + " family.\n");

                            System.out.println("Your active creature is " + activeCreature.getName() + ".");
                            System.out.println("It is an evolution level " + activeCreature.getEvolutionLv() + " "
                                    + activeCreature.getType() + " type of the " + activeCreature.getFamily()
                                    + " family.\n");

                            for (int actions = 3; actions > 0; actions--) {

                                if (wildCreature.getHealthPoints() != 50) {
                                    System.out.println("The wild " + wildCreature.getName() + " has "
                                            + wildCreature.getHealthPoints() + " HP left.\n");
                                } else {
                                    System.out.println("The wild " + wildCreature.getName() + " has "
                                            + wildCreature.getHealthPoints() + "HP.\n");
                                }

                                System.out.println("[A]ATTACK enemy  [S]SWAP Creatures  [C]CATCH enemy  [R]RUN away");

                                encounterAction = scan.nextLine();

                                if (encounterAction.equals("A")) {

                                    int dmg = activeCreature.attack();

                                    if (activeCreature.typeAdvantage(activeCreature.getType(),
                                            wildCreature.getType())) {
                                        dmg *= 1.5;
                                        System.out.println("Its super effective!");
                                    }

                                    wildCreature.takeDamage(dmg);

                                } else if (encounterAction.equals("S")) {

                                    int creatureChoice = 0;

                                    System.out.print("Input creature number: ");

                                    creatureChoice = scan.nextInt();
                                    user.setActiveCreature(creatureChoice);

                                } else if (encounterAction.equals("C")) {

                                    int catchRate = (40 + 50) - wildCreature.getHealthPoints();

                                    if (user.catchCreature() >= catchRate) {

                                        caught = true;

                                    } else {

                                        System.out.println("The " + wildCreature.getName() + " was NOT caught.");

                                    }
                                }

                                if (caught) {

                                    System.out.println("You caught the " + wildCreature.getName() + "!");
                                    user.addToInventory(wildCreature);
                                    System.out.println(wildCreature.getName() + " was added to your inventory.");
                                    actions = 0;

                                } else if (encounterAction.equals("R")) {

                                    System.out.println("You ran away.");
                                    actions = 0;

                                } else if (wildCreature.getHealthPoints() == 0) {

                                    System.out.println("The wild " + wildCreature.getName() + "fainted.");

                                } else if (actions == 0) {

                                    System.out.println("The wild " + wildCreature.getName() + "ran away.");

                                }

                                encounter = false;
                            }
                        }
                        input = 0;
                    }
                }
                    break;
                /*
                 * case 3:
                 * ;
                 * break;
                 * 
                 * case 4:
                 * ;
                 */
                default:
                    ;
            }
        }

        scan.close();

    }
}
