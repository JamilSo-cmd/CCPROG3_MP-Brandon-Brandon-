
/**
 * <B>Creature Object<B>
 * @author Brandon Jaramillo Anthony  
 * @author Brandon Jamil So
 * @version 2.0
 * 
 */
import java.util.Random;

public class Creature {
    // attributes
    /**
     * Represents the creature's name
     */
    private String name;
    /**
     * Represents the creature's type
     */
    private String type;
    /**
     * Represents the creature's family
     */
    private char family;
    /**
     * Represents the creature's evolution Lv
     */
    private int evolutionLv;
    /**
     * Represents the creature's health points
     */
    private int healthPoints = 50;
    /**
     * Represents the file path to the image of the creature
     */
    private String imagePath;
    // methods

    /**
     * Creates the creature with given information obtained
     * 
     * @param name
     *               represents the creature's name
     * @param type
     *               represents the creature's type
     * @param family
     *               represents the creature's evolution level
     * @param EL
     */
    public Creature(String name, String type, char family, int EL, String imagePath) {

        this.name = name;
        this.type = type;
        this.family = family;
        this.evolutionLv = EL;
        this.imagePath = imagePath;
    }

    /**
     * Returns a new Creature instance that is randomly chosen out of the possible
     * creatures that exist
     * 
     * @return Creature
     * 
     * 
     */
    public static Creature randomCreature1() {
        Random rng = new Random();

        String[] names = { "Strawander", "Chocowool", "Parfwit", "Brownisaur",
                "Frubat", "Malts", "Squirpie", "Chocolite", "Oshacone" };

        char[] families = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I' };

        String creatureType = "";
        char creatureFamily = '1';

        String randomName = names[rng.nextInt(names.length)];

        String creatureImagePath = "./resources/";
        creatureImagePath += randomName;

        if ("Strawander".equals(randomName) || "Chocowool".equals(randomName) || "Parfwit".equals(randomName)) {
            creatureType = "Fire";

            boolean familyChecker = true;
            while (familyChecker) {
                int i = 0;

                if (randomName.equals(names[i])) {
                    creatureFamily = families[i];

                    if (families[i] == ('A') || families[i] == ('C')) {
                        creatureImagePath += ".jpg";
                    } else {
                        creatureImagePath += ".png";
                    }
                    familyChecker = false;
                }
                i++;
            }

        } else if ("Brownisaur".equals(randomName) || "Frubat".equals(randomName) || "Malts".equals(randomName)) {
            creatureType = "Grass";

            boolean familyChecker = true;
            while (familyChecker) {
                int i = 3;

                if (randomName.equals(names[i])) {
                    creatureFamily = families[i];
                    creatureImagePath += ".png";

                    familyChecker = false;
                }
                i++;
            }

        } else if ("Squirpie".equals(randomName) || "Chocolite".equals(randomName) || "Oshacone".equals(randomName)) {
            creatureType = "Water";

            boolean familyChecker = true;
            while (familyChecker) {
                int i = 6;

                if (randomName.equals(names[i])) {
                    creatureFamily = families[i];

                    if (families[i] == ('G')) {
                        creatureImagePath += ".jpg";
                    } else {
                        creatureImagePath += ".png";
                    }
                    familyChecker = false;
                }
                i++;
            }
        }

        return new Creature(randomName, creatureType, creatureFamily, 1, creatureImagePath);
    }

    /**
     * lowers the healthpoints of a Creature object by the damage value
     * 
     * @param healthPoints
     * 
     * @param damage
     */

    public void takeDamage(int damage) {
        this.healthPoints -= damage;
    }

    /**
     * gets the creature's name
     * 
     * @return
     *         the creature's name
     */
    public String getName() {
        return name;
    }

    /**
     * gets the creature's type
     * 
     * @return
     *         the creature's type
     */
    public String getType() {
        return type;
    }

    /**
     * gets the creature's family
     * 
     * @return
     *         the creature's family
     */
    public char getFamily() {
        return family;
    }

    /**
     * gets the creature's Evolution lv
     * 
     * @return
     *         the creature's EL
     */
    public int getEvolutionLv() {
        return evolutionLv;
    }

    /**
     * gets the creature's Health Points
     * 
     * @return
     *         the creature's HP
     */
    public int getHealthPoints() {
        return healthPoints;
    }

    /**
     * calculates the damage that will be inflicted to the enemy
     * 
     * @return
     *         the amount of damage done by the creature
     */
    public int attack() {
        Random rand = new Random();
        int max = 10, min = 1;

        int dmgValue = rand.nextInt(max - min + 1) + min;

        return dmgValue;
    }

    /**
     * Checks if ally creature has a type advantage over enemy creature
     * 
     * @param ally
     *              represents the creature the player is controlling
     * 
     * @param enemy
     *              represents the creature the player is fighting
     * 
     * @return
     *         boolean flag of whether there is a type advantage or not
     */
    public boolean typeAdvantage(String ally, String enemy) {
        boolean hasAdvantage = false;

        if (((ally == "Fire" || ally == "fire") && enemy == "grass") ||
                ((ally == "Grass" || ally == "grass") && enemy == "water") ||
                ((ally == "Water" || ally == "water") && enemy == "fire")) {
            hasAdvantage = true;
        }

        return hasAdvantage;
    }

    /**
     * returns the file path for the creature image
     * 
     * @return
     *         file path of the creature image
     */
    public String getImagePath() {
        return imagePath;
    }
}
