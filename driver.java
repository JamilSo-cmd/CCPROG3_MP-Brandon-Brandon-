
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
        switch (input){
            case 1: user.addToInventory(new Creature("Strawander","Fire","A",1,15));
                    user.setActiveCreature(0);
            case 2: ;
            case 3: ;
            default:;
        }

    }

}