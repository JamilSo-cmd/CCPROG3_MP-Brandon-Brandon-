
/**
 * <B>Area of the program<B>
 * @author Brandon Jaramillo Anthony  
 * @author Brandon Jamil So
 * @version 1.0
 * 
 */
import java.util.ArrayList;
import java.util.Random;

public class Area {
    // attributes

    /**
     * Contains the number of rows
     */
    private int rows;
    /**
     * Contains the number of columns
     */
    private int columns;
    /**
     * Contains the number of tiles present
     */
    private int[][] tiles;
    /**
     * Contains the list of creatures
     */
    private ArrayList<Creature> creaturesList;

    // methods
    /**
     * sets the number of rows, columns and list of creatures based on the area
     * 
     * @param rows
     *                     represents amount of rows in area
     * @param column
     *                     represents amount of columns in area
     * @param creatureList
     *                     represents the creatures that will be encountered in this
     *                     area
     */
    public Area(int level, ArrayList<Creature> creaturelist) {
        if (level == 1) {
            this.rows = 5;
            this.columns = 1;
            this.creaturesList = creaturelist;
            area1();
        }
        // Area 2 and 3
        /*
         * else if (level == 2) {
         * this.rows = 3;
         * this.columns = 3;
         * area2();
         * 
         * } else if (level == 3) {
         * this.rows = 4;
         * this.columns = 4;
         * area3();
         * }
         */
    }

    /**
     * gets a randomly chosen wild creature from the creatureList
     * 
     * @param creaturesList
     *                      represents all the creatures that can be encountered in
     *                      this area
     * 
     * @return
     *         a wild creature
     */
    public Creature getWildCreature() {
        Random wild = new Random();
        int randomIndex = wild.nextInt(creaturesList.size());
        return creaturesList.get(randomIndex);
    }

    /**
     * sets the number of rows and column tiles for area 1
     * 
     * @param tiles
     *                represents the size of the area
     * @param rows
     *                reepresents the number of rows
     * @param columns
     *                represents the number of columns
     */
    private void area1() {
        this.tiles = new int[rows][columns];
        this.tiles = new int[][] {
                { 0 },
                { 0 },
                { 0 },
                { 0 },
                { 0 }
        };
    }

    /*
     * private void area2() {
     * this.tiles = new int[][]{
     * {0, 0, 0},
     * {0, 0, 0},
     * {0, 0, 0}
     * };
     * }
     * 
     * private void area3() {
     * this.tiles = new int[][]{
     * {0, 0, 0, 0},
     * {0, 0, 0, 0},
     * {0, 0, 0, 0},
     * {0, 0, 0, 0}
     * };
     * }
     */

    /**
     * gets the number of rows for the area
     * 
     * @return
     *         number of rows
     */
    public int getRows() {
        return this.rows;
    }

    /**
     * gets the number of columns for the area
     * 
     * @return
     *         number of columns
     */
    public int getColumns() {
        return this.columns;
    }

    /**
     * gets the tiles of the area
     * 
     * @return
     *         amount of tiles
     */
    public int[][] getTiles() {
        return tiles;
    }
}
