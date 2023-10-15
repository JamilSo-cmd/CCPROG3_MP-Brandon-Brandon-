
public class Area {
    private int rows;
    private int columns;
    private int[][] tiles;

    public Area(int level) {
        if (level == 1) {
            this.rows = 5;
            this.columns = 1;
            area1();
        } /*
           * else if (level == 2) {
           * this.rows = 3;
           * this.columns = 3;
           * area2();
           * } else if (level == 3) {
           * this.rows = 4;
           * this.columns = 4;
           * area3();
           * }
           */
    }

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

    public int getRows() {
        return this.rows;
    }

    public int getColumns() {
        return this.columns;
    }
    
    public int[][] getTiles() {
        return tiles;
    }
}