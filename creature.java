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


}
