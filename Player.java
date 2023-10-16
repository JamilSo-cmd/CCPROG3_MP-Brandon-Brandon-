
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

    public void moveUp() {
        int currentY = playerPos[0][1];
        playerPos[0][1] = currentY - 1; // Decrease the Y-coordinate to move up

        // Roll a random number between 1 and 100
        int encounter = new Random().nextInt(100) + 1;

        // Check if the roll is less than or equal to 40 (40% chance)
        if (encounter <= 40) {
            battlePhase();
        }
    }

    public void moveDown() {
        int currentY = playerPos[0][1];
        playerPos[0][1] = currentY + 1; // Increase the Y-coordinate to move down

        // Roll a random number between 1 and 100
        int encounter = new Random().nextInt(100) + 1;

        if (encounter <= 40) {
            battlePhase();
        }
    }

    public void moveLeft() {
        int currentX = playerPos[0][0];
        playerPos[0][0] = currentX - 1; // Decrease the X-coordinate to move left

        // Roll a random number between 1 and 100
        int encounter = new Random().nextInt(100) + 1;

        if (encounter <= 40) {
            battlePhase();
        }
    }

    public void moveRight() {
        int currentX = playerPos[0][0];
        playerPos[0][0] = currentX + 1; // Increase the X-coordinate to move right

        // Roll a random number between 1 and 100
        int encounter = new Random().nextInt(100) + 1;

        if (encounter <= 40) {
            battlePhase();
        }
    }

    public void battlePhase() {
        System.out.println("");
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
        // For enemy catch Rate int catchRate = (40+50) - Enemy.getHP();

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
}
