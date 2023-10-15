/**
 * 
 * @author Brandon Jaramillo Anthony  
 * @author Brandon Jamil So
 * @version 1.0
 * 
 */

import java.util.Random;

public class Creature {
    //attributes
    private String name;
    private String type;
    private String family;
    private int evolutionLv;
    private int healthPoints = 50;
    //methods
    public Creature (String name, String type, String family, int EL){

        this.name = name;
        this.type = type;
        this.family = family;
        this.evolutionLv = EL;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
    
    public String getFamily() {
        return family;
    }
    
    public int getEvolutionLv() {
        return evolutionLv;
    }

    
    public int attack (){
        Random rand = new Random();
        int max = 10, min = 1;

        int dmgValue = rand.nextInt(max - min + 1) + min;

        return dmgValue;
    }
}
