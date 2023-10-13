
/**
 * 
 * @author Brandon Jaramillo Anthony  
 * @author Brandon Jamil So
 * @version 1.0
 * 
 */

import java.util.Scanner;
import java.util.ArrayList;

public class driver {

    public static void main (String args []){

        int input = 0;
        Scanner scan = new Scanner(System.in);
        Player user = new Player(new Inventory());

        System.out.println( "Greetings " + /*player name*/  ", Pick your starter! \n\n[1] Strawander\n\n[2] Brownisaur\n\n[3] Squirpie");

        //player picks a starter
        while (input < 1 || input > 3){
            input = scan.nextInt();
            switch (input){
                case 1: user.addToInventory(new Creature("Strawander","Fire","A",1,15));
                    user.setActiveCreature(0);
                break;
                case 2: user.addToInventory(new Creature("Brownisaur","Grass","D",1,15));
                    user.setActiveCreature(0);
                break;
                case 3: user.addToInventory(new Creature("Squirpie","Water","G",1,15));
                    user.setActiveCreature(0);
                default:;
            }
        }
        
        input = 0;
        System.out.println( "Menu: \n\n[1] View Inventory\n\n[2] Explore an Area\n\n[3] Evolve Creature\n\n[4] Exit");

        while (input < 1 || input > 4){
            input = scan.nextInt();
            switch (input){
                case 1: ;
                break;
                case 2: ;
                break;
                case 3: ;
                break;
                case 4: ;
                default:;
            }
        }

    }

}