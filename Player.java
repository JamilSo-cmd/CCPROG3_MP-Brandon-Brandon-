
/**
 * <B>Player object of the program<B>
 * 
 * @author Brandon Jaramillo Anthony  
 * @author Brandon Jamil So
 * @version 1.0
 * 
 */
import java.util.Random;
import java.util.*;

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
     * @param playerPos
     *                  represents the player's position
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
        Collections.swap(this.playerInv.getRoster(),0,index);

    }

    /**
     * Lowers the Y coordinate of the Player Position to move the player up
     * 
     * @param playerPos
     *                  represents the player's position
     * @return
     *         boolean flag of whether an encounter occured or not
     */
    public boolean moveUp() {
        boolean encounter = false;
        int currentY = playerPos[0][1];

        // Decrease the Y-coordinate to move up
        playerPos[0][1] = currentY - 1;

        // Roll a random number between 1 and 100
        int randomNum = new Random().nextInt(100) + 1;

        // Check if the roll is less than or equal to 40 (40% chance)
        if (randomNum <= 40) {
            encounter = true;
        }
        return encounter;
    }

    /**
     * Raises the Y coordinate of the Player Position to move the player down
     * 
     * @param playerPos
     *                  represents the player's position
     * @return
     *         boolean flag of whether an encounter occured or not
     */
    public boolean moveDown() {
        boolean encounter = false;
        int currentY = playerPos[0][1];

        // Increase the Y-coordinate to move down
        playerPos[0][1] = currentY + 1;

        // Roll a random number between 1 and 100
        int randomNum = new Random().nextInt(100) + 1;

        if (randomNum <= 40) {
            encounter = true;
        }
        return encounter;
    }

    /**
     * Lowers the X coordinate of the Player Position to move the player left
     * 
     * @param playerPos
     *                  represents the player's position
     * @return
     *         boolean flag of whether an encounter occured or not
     */
    public boolean moveLeft() {
        boolean encounter = false;
        int currentX = playerPos[0][0];

        // Decrease the X-coordinate to move left
        playerPos[0][0] = currentX - 1;

        // Roll a random number between 1 and 100
        int randomNum = new Random().nextInt(100) + 1;

        if (randomNum <= 40) {
            encounter = true;
        }
        return encounter;
    }

    /**
     * Raises the X coordinate of the Player Position to move the player right
     * 
     * @param playerPos
     *                  represents the player's position
     * @return
     *         boolean flag of whether an encounter occured or not
     */
    public boolean moveRight() {
        boolean encounter = false;
        int currentX = playerPos[0][0];

        // Increase the X-coordinate to move right
        playerPos[0][0] = currentX + 1;

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
     *                    represents the player's inventory
     * @param newCreature
     *                    represents the creature to be added
     */
    public void addToInventory(Creature newCreature) {

        this.playerInv.addToInventory(newCreature);

    }

    /**
     * gets the Player's current position of x and y coordinate
     * 
     * @return
     *         the Player's current position in the area
     */
    public int[][] getPlayerPos() {
        return playerPos;
    }

    /**
     * Resets the Player's position to the default (0,0)
     * 
     * @param playerPos
     *                  represents the player's position
     */
    public void resetPlayerPos() {
        this.playerPos[0][0] = 0;
        this.playerPos[0][1] = 0;
    }

    /**
     * gets the active creature to be used in an encounter
     * 
     * @return
     *         the active creature
     */
    public Creature getActiveCreature() {
        return this.activeCreature;
    }

    public Inventory getPlayerInv() {
        return playerInv;
    }
}
