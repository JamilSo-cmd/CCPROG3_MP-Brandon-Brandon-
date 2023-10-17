
/**
 * <B>Player object of the program<B>
 * 
 * @author Brandon Jaramillo Anthony  
 * @author Brandon Jamil So
 * @version 1.0
 * 
 */
import java.util.Random;

public class Player {
    // attributes

    /**
     * represents the player's inventory
     */
    private Inventory playerInv;
    /**
     * represents the player's active creature
     */
    private Creature activeCreature;
    /**
     * represents the player's current position on the area
     */
    private int[][] playerPos;
    // methods

    /**
     * creates the player with obtained inventory
     * 
     * @param playerInv
     *                  represents the player's inventory
     */
    public Player(Inventory playerInv) {

        this.playerInv = playerInv;
        this.playerPos = new int[][] { { 0, 0 } };
    }

    /**
     * sets a new active creature for the player
     * 
     * @param activeCreature
     *                       represent the player's current creature
     * @param playerInv
     *                       represents the player's inventory
     */
    public void setActiveCreature(int index) {

        this.activeCreature = playerInv.getCreature(index);

    }

    public boolean moveUp() {
        boolean encounter = false;
        int currentY = playerPos[0][1];
        playerPos[0][1] = currentY - 1; // Decrease the Y-coordinate to move up

        // Roll a random number between 1 and 100
        int randomNum = new Random().nextInt(100) + 1;

        // Check if the roll is less than or equal to 40 (40% chance)
        if (randomNum <= 40) {
            encounter = true;
        }
        return encounter;
    }

    public boolean moveDown() {
        boolean encounter = false;
        int currentY = playerPos[0][1];
        playerPos[0][1] = currentY + 1; // Increase the Y-coordinate to move down

        // Roll a random number between 1 and 100
        int randomNum = new Random().nextInt(100) + 1;

        if (randomNum <= 40) {
            encounter = true;
        }
        return encounter;
    }

    public boolean moveLeft() {
        boolean encounter = false;
        int currentX = playerPos[0][0];
        playerPos[0][0] = currentX - 1; // Decrease the X-coordinate to move left

        // Roll a random number between 1 and 100
        int randomNum = new Random().nextInt(100) + 1;

        if (randomNum <= 40) {
            encounter = true;
        }
        return encounter;
    }

    public boolean moveRight() {
        boolean encounter = false;
        int currentX = playerPos[0][0];
        playerPos[0][0] = currentX + 1; // Increase the X-coordinate to move right

        // Roll a random number between 1 and 100
        int randomNum = new Random().nextInt(100) + 1;

        if (randomNum <= 40) {
            encounter = true;
        }
        return encounter;
    }

    /**
     * calculates the probility of the player catching a creature
     * 
     * @return
     *         the catch value
     */
    public int catchCreature() {

        Random rand = new Random();
        int max = 100, min = 1;

        int catchValue = rand.nextInt(max - min + 1) + min;

        return catchValue;
    }

    /**
     * adds a new creature into the player's inventory
     * 
     * @param playerInv
     *                  represents the player's inventory
     */
    public void addToInventory(Creature newCreature) {

        this.playerInv.addToInventory(newCreature);

    }

    /**
     * shows the information of each creature in the player's inventory, including
     * the current active creature
     * 
     * @param activeCreature
     *                       represent the player's current creature
     * @param playerInv
     *                       represents the player's inventory
     */
    public void viewInventory() {

        playerInv.viewInventory();

        System.out.println("Current Active Creature: " + activeCreature.getName());

    }

    public int[][] getPlayerPos() {
        return playerPos;
    }

    public Creature getActiveCreature() {
        return this.activeCreature;
    }
}
