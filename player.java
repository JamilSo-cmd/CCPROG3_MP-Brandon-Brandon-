import java.util.ArrayList;

public class Player {
    //attributes
    private Inventory playerInv;
    private Creature activeCreature;    
    private int[][] playerPos;
    //methods
    public Player(Inventory playerInv){

        this.playerInv = playerInv;

    }

    public void setActiveCreature (){



    }
    
    public void addToInventory(Creature newCreature){

            this.playerInv.addToInventory(newCreature);

    }

}
    