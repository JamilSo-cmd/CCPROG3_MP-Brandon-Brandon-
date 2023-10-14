
/**
 * 
 * @author Brandon Jaramillo Anthony  
 * @author Brandon Jamil So
 * @version 1.0
 * 
 */

import java.util.Scanner;
public class driver {

    public static void main (String args []){

        int input = 0;
        Scanner scan = new Scanner(System.in);
        Player user = new Player(new Inventory());

        System.out.println( "Greetings " + /*player name*/  ", Pick your starter! \n\n[1] Strawander\n\n[2] Brownisaur\n\n[3] Squirpie\n\nInput: ");

        //player picks a starter
        while (input < 1 || input > 3){
            input = scan.nextInt();

            switch (input){
                case 1: user.addToInventory(new Creature("Strawander","Fire","A",1));
                    user.setActiveCreature(0);
                break;

                case 2: user.addToInventory(new Creature("Brownisaur","Grass","D",1));
                    user.setActiveCreature(0);
                break;

                case 3: user.addToInventory(new Creature("Squirpie","Water","G",1));
                    user.setActiveCreature(0);

                default: System.out.println( "unknown input, try again: ");

            }
        }
        // Menu start
        input = 0;
        

        while (input < 1 || input > 4){
            System.out.println( "Menu: \n\n[1] View Inventory\n\n[2] Explore an Area\n\n[3] Evolve Creature\n\n[4] Exit");
            input = scan.nextInt();
            switch (input){
                case 1: {
                    //program calls user to view inventory
                    user.viewInventory();
                    //program asks if user wants to change active creature
                    input = 0;
                    System.out.println( "Do you wish to change active creature?\n\n[1]Yes\n[2]No\n\nInput: ");
                    
                    while (input < 1 || input > 2){
                        
                        input = scan.nextInt();

                        if(input < 1 || input > 2){
                            System.out.println( "unknown input, try again: ");
                        }

                    }
                    //user asks for index of creature if user wants to change active creature
                    if(input == 1){

                        System.out.print( "Input creature number: "); 
                        input = scan.nextInt();
                        user.setActiveCreature(input);

                    }

                    input = 0;
                }
                break;
                case 2: ;
                break;
                case 3: ;
                break;
                case 4: ;
                default:;
            }
        }

        scan.close();

    }

}