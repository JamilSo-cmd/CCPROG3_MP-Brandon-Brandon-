
/**
 * <B>Main Controller of the Program<B>
 * 
 * @author Brandon Jaramillo Anthony  
 * @author Brandon Jamil So
 * @version 2.0
 * 
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

public class MainController {

    private Player user;
    private MainView mainView;
    private Creature creatureSelect1;
    private Creature creatureSelect2;
    private Creature enemyCreature;
    private int index1;
    private int index2;

    private String evolutionResult = "select two creatures";
    private int atkValue;
    private boolean catchFlag;
    protected boolean swapFlag;
    protected int timer;
    private boolean encounterFlag = false;

    public MainController() {

        this.user = new Player(new Inventory());

        this.mainView = new MainView();

        this.mainView.createStarterButton("Strawander",
                pickStarterEvent("Strawander", "Fire", 'A', 1, "./resources/Strawander.jpg"));
        this.mainView.createStarterButton("Brownisaur",
                pickStarterEvent("Brownisaur", "Grass", 'D', 1, "./resources/Brownisaur.png"));
        this.mainView.createStarterButton("Squirpie",
                pickStarterEvent("Squirpie", "Water", 'G', 1, "./resources/Squirpie.jpg"));

        this.mainView.assignOpenInvEvent(openInvEvent());

        this.mainView.setSwitchActionEvent(switchCreatureEvent());

        this.mainView.assignOpenEvoEvent(openEvoEvent());

        this.mainView.setSelectActionEvent1(selectCreatureEvent1());

        this.mainView.setSelectActionEvent2(selectCreatureEvent2());

        this.mainView.setLeftActionEvent(moveLeftEvent());

        this.mainView.setRightActionEvent(moveRightEvent());

        this.mainView.setUpActionEvent(moveUpEvent());

        this.mainView.setDownActionEvent(moveDownEvent());

        this.mainView.setEvolutionActionEvent(evolutionEvent());

        this.mainView.setAttackActionEvent(attackEvent());

        this.mainView.setCatchActionEvent(captureEvent());

        this.mainView.assignSwapEvent(swapEvent());

        this.mainView.setSwappingActionEvent(swapCreatureEvent());

        this.mainView.assignOpenAreaEvent(assignOpenAreaEvent());

        this.mainView.assignChooseAreaEvent();
    }

    private ActionListener assignOpenAreaEvent() {
        MainView curMainView = this.mainView;
        Player user1 = this.user;

        ActionListener action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // actions to be performed when Encounter starts
                int level = (Integer) ((JButton) e.getSource()).getClientProperty("level");
                curMainView.reloadArea(encounterFlag,user1.getPlayerPos(),level);
            }
        };
        return action;
    }

    public void checkEncounterEvent(){

        Random rng = new Random();

        if (rng.nextInt(100) >= 40 ){
            this.encounterFlag = true;
            if(this.mainView.getLevel() == 1){
                this.enemyCreature = randomCreatureEL1();
            }
            else if(this.mainView.getLevel() == 2){
                int value = rng.nextInt(2);

                if (value == 0){
                    this.enemyCreature = randomCreatureEL1();
                }
                else if (value == 1){
                    this.enemyCreature = randomCreatureEL2();
                }
            }
            else if(this.mainView.getLevel() == 3){
                int value = rng.nextInt(3);

                if (value == 0){
                    this.enemyCreature = randomCreatureEL1();
                }
                else if (value == 1){
                    this.enemyCreature = randomCreatureEL2();
                }
                else if (value == 2){
                    this.enemyCreature = randomCreatureEL3();
                }
            System.out.println(enemyCreature.getName() + " checking");
            startEncounterEvent();

            }
        }

    }

    private ActionListener moveLeftEvent() {
        MainView curMainView = this.mainView;
        Player user1 = this.user;

        ActionListener action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                user1.moveLeft();
                checkEncounterEvent();
                curMainView.reloadArea(encounterFlag, user1.getPlayerPos());
            }
        };
        return action;
    }

    private ActionListener moveRightEvent() {
        MainView curMainView = this.mainView;
        Player user1 = this.user;

        ActionListener action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                user1.moveRight();
                checkEncounterEvent();
                curMainView.reloadArea(encounterFlag,user1.getPlayerPos());
            }
        };
        return action;
    }

    private ActionListener moveUpEvent() {
        MainView curMainView = this.mainView;
        Player user1 = this.user;

        ActionListener action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                user1.moveUp();
                checkEncounterEvent();
                curMainView.reloadArea(encounterFlag,user1.getPlayerPos());

            }
        };
        return action;
    }

    private ActionListener moveDownEvent() {
        MainView curMainView = this.mainView;
        Player user1 = this.user;

        ActionListener action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                user1.moveDown();
                checkEncounterEvent();
                curMainView.reloadArea(encounterFlag,user1.getPlayerPos());
            }
        };
        return action;
    }

    private ActionListener swapCreatureEvent() {
        MainView curMainView = this.mainView;
        Player user1 = this.user;

        ActionListener action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // actions to be performed when Encounter starts
                user1.setActiveCreature((Integer) ((JButton) e.getSource()).getClientProperty("index"));
                swapFlag = true;
                timer--;
                curMainView.reloadSwap(user1.getPlayerInv().getRoster(), swapFlag);
                curMainView.reloadEncounter(user1.getActiveCreature(), enemyCreature, catchFlag, timer);
            }
        };
        return action;
    }

    private ActionListener swapEvent() {
        MainView curMainView = this.mainView;
        Player user1 = this.user;

        ActionListener action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // actions to be performed when Encounter starts
                swapFlag = false;
                curMainView.reloadSwap(user1.getPlayerInv().getRoster(), swapFlag);
            }
        };
        return action;
    }

    private ActionListener captureEvent() {
        MainView curMainView = this.mainView;
        Player user1 = this.user;

        ActionListener action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // actions to be performed when Encounter starts

                catchCreature();
                timer--;
                curMainView.reloadEncounter(user1.getActiveCreature(), enemyCreature, catchFlag, timer);
            }
        };
        return action;
    }

    private void catchCreature() {
        Player user1 = this.user;

        int catchRate = (40 + 50) - enemyCreature.getHealthPoints();

        if (user1.catchCreature() >= catchRate) {

            user1.addToInventory(enemyCreature);
            this.catchFlag = true;

        }

    }

    private ActionListener attackEvent() {
        MainView curMainView = this.mainView;
        Player user1 = this.user;

        ActionListener action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // actions to be performed when Encounter starts
                computeAtk();
                enemyCreature.takeDamage(atkValue);
                timer--;
                curMainView.reloadEncounter(user1.getActiveCreature(), enemyCreature, catchFlag, timer);
            }
        };
        return action;
    }

    private void computeAtk() {
        Player user1 = this.user;

        Creature ActiveCreature = user1.getActiveCreature();
        boolean typeAdvantage = user1.getActiveCreature().typeAdvantage(ActiveCreature.getType(),
                enemyCreature.getType());

        this.atkValue = user1.getActiveCreature().attack(typeAdvantage);

    }

    private void startEncounterEvent() {
        MainView curMainView = this.mainView;
        Player user1 = this.user;

        this.timer = 3;
        this.catchFlag = false;
        curMainView.reloadEncounter(user1.getActiveCreature(), enemyCreature, catchFlag, timer);
            
    }

    private ActionListener openEvoEvent() {
        MainView curMainView = this.mainView;
        Player user1 = this.user;

        ActionListener action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                curMainView.reloadEvolution(user1.getPlayerInv().getRoster(), creatureSelect1, creatureSelect2,
                        evolutionResult);
            }
        };
        return action;
    }

    private ActionListener pickStarterEvent(String name, String type, char family, int evolutionLv, String imagePath) {
        Player user1 = this.user;

        ActionListener action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                user1.addToInventory(new EL1(name, type, family, evolutionLv, imagePath));
                user1.setActiveCreature(0);
            }
        };

        return action;
    }

    private ActionListener openInvEvent() {
        MainView curMainView = this.mainView;
        Player user1 = this.user;

        ActionListener action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                curMainView.reloadInventory(user1.getPlayerInv().getRoster());
            }
        };

        return action;
    }

    private ActionListener switchCreatureEvent() {
        Player user1 = this.user;
        MainView curMainView = this.mainView;

        ActionListener action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                user1.setActiveCreature((Integer) ((JButton) e.getSource()).getClientProperty("index"));
                curMainView.reloadInventory(user1.getPlayerInv().getRoster());
            }
        };
        return action;
    }

    private ActionListener selectCreatureEvent1() {
        Player user1 = this.user;
        MainView curMainView = this.mainView;

        ActionListener action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                index1 = (Integer) ((JButton) e.getSource()).getClientProperty("index");
                setCreatureSelect1(user1.getPlayerInv().getRoster()
                        .get((Integer) ((JButton) e.getSource()).getClientProperty("index")));
                curMainView.reloadEvolution(user1.getPlayerInv().getRoster(), creatureSelect1, creatureSelect2,
                        evolutionResult);
                System.out.println(creatureSelect1.getName());
            }
        };
        return action;
    }

    private ActionListener selectCreatureEvent2() {
        Player user1 = this.user;
        MainView curMainView = this.mainView;

        ActionListener action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                index2 = (Integer) ((JButton) e.getSource()).getClientProperty("index");
                setCreatureSelect2(user1.getPlayerInv().getRoster()
                        .get((Integer) ((JButton) e.getSource()).getClientProperty("index")));
                curMainView.reloadEvolution(user1.getPlayerInv().getRoster(), creatureSelect1, creatureSelect2,
                        evolutionResult);
                System.out.println(creatureSelect2.getName());

            }
        };
        return action;
    }

    private ActionListener evolutionEvent() {
        Player user1 = this.user;
        MainView curMainView = this.mainView;

        ActionListener action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                evolveCreature();

                curMainView.reloadEvolution(user1.getPlayerInv().getRoster(), creatureSelect1, creatureSelect2,
                        evolutionResult);
            }
        };
        return action;
    }

    public void setCreatureSelect1(Creature creatureSelect1) {
        this.creatureSelect1 = creatureSelect1;
    }

    public void setCreatureSelect2(Creature creatureSelect2) {
        this.creatureSelect2 = creatureSelect2;
    }

    public void evolveCreature() {
        Player user1 = this.user;

        if (index1 == index2) {
            evolutionResult = "Cannot use same Creature";
        } else {

            if (creatureSelect1.getFamily() != creatureSelect2.getFamily()) {
                evolutionResult = "Not the same Family";
            } else {

                if (creatureSelect1.getEvolutionLv() >= 3 || creatureSelect2.getEvolutionLv() >= 3
                        || creatureSelect1.getEvolutionLv() != creatureSelect2.getEvolutionLv()) {
                    evolutionResult = "Failure";
                } else {
                    switch (creatureSelect1.getFamily()) {

                        case 'A': {

                            if (creatureSelect1.getEvolutionLv() == 1) {
                                user1.getPlayerInv().getRoster()
                                        .add(new EL2("Strawleon", "Fire", 'A', 2, "./resources/Strawleon.png"));

                            }

                            else if (creatureSelect1.getEvolutionLv() == 2) {

                                user1.getPlayerInv().getRoster()
                                        .add(new EL3("Stawizard", "Fire", 'A', 3, "./resources/Stawizard.png"));

                            }

                        }
                            ;
                            break;
                        case 'D': {

                            if (creatureSelect1.getEvolutionLv() == 1) {

                                user1.getPlayerInv().getRoster()
                                        .add(new EL2("Chocosaur", "Grass", 'D', 2, "./resources/Chocosaur.png"));

                            }

                            else if (creatureSelect1.getEvolutionLv() == 2) {

                                user1.getPlayerInv().getRoster()
                                        .add(new EL3("Fudgasaur", "Grass", 'D', 3, "./resources/Fudgasaur.png"));

                            }

                        }
                            ;
                            break;
                        case 'G': {

                            if (creatureSelect1.getEvolutionLv() == 1) {

                                user1.getPlayerInv().getRoster()
                                        .add(new EL2("Tartortle", "Water", 'G', 2, "./resources/Tartortle.png"));

                            }

                            else if (creatureSelect1.getEvolutionLv() == 2) {

                                user1.getPlayerInv().getRoster()
                                        .add(new EL3("Piestoise", "Water", 'G', 3, "./resources/Piestoise.png"));

                            }

                        }
                            ;
                            break;
                        case 'H': {

                            if (creatureSelect1.getEvolutionLv() == 1) {

                                user1.getPlayerInv().getRoster()
                                        .add(new EL2("Chocolish", "Water", 'H', 2, "./resources/Chocolish.png"));

                            }

                            else if (creatureSelect1.getEvolutionLv() == 2) {

                                user1.getPlayerInv().getRoster()
                                        .add(new EL3("Icesundae", "Water", 'H', 3, "./resources/Icesundae.png"));

                            }

                        }
                            ;
                        case 'I': {

                            if (creatureSelect1.getEvolutionLv() == 1) {

                                user1.getPlayerInv().getRoster()
                                        .add(new EL2("Dewice", "Water", 'I', 2, "./resources/Dewice.png"));

                            }

                            else if (creatureSelect1.getEvolutionLv() == 2) {

                                user1.getPlayerInv().getRoster()
                                        .add(new EL3("Samurcone", "Water", 'I', 3, "./resources/Samurcone.png"));

                            }

                        }
                            ;
                            break;

                        case 'F': {

                            if (creatureSelect1.getEvolutionLv() == 1) {

                                user1.getPlayerInv().getRoster()
                                        .add(new EL2("Kirlicake", "Grass", 'F', 2, "./resources/Kirlicake.png"));

                            }

                            else if (creatureSelect1.getEvolutionLv() == 2) {

                                user1.getPlayerInv().getRoster()
                                        .add(new EL3("Velvevoir", "Grass", 'F', 3, "./resources/Velvevoir.png"));

                            }

                        }
                            ;
                            break;

                        case 'E': {

                            if (creatureSelect1.getEvolutionLv() == 1) {

                                user1.getPlayerInv().getRoster()
                                        .add(new EL2("Golberry", "Grass", 'E', 2, "./resources/Golberry.png"));

                            }

                            else if (creatureSelect1.getEvolutionLv() == 2) {

                                user1.getPlayerInv().getRoster()
                                        .add(new EL3("Croberry", "Grass", 'E', 3, "./resources/Croberry.png"));

                            }

                        }
                            ;
                            break;

                        case 'B': {

                            if (creatureSelect1.getEvolutionLv() == 1) {

                                user1.getPlayerInv().getRoster()
                                        .add(new EL2("Chocofluff", "Fire", 'B', 2, "./resources/Chocofluff.png"));

                            }

                            else if (creatureSelect1.getEvolutionLv() == 2) {

                                user1.getPlayerInv().getRoster()
                                        .add(new EL3("Candaros", "Fire", 'B', 3, "./resources/Candaros.png"));

                            }

                        }
                            ;
                            break;

                        case 'C': {

                            if (creatureSelect1.getEvolutionLv() == 1) {

                                user1.getPlayerInv().getRoster()
                                        .add(new EL2("Parfure", "Fire", 'C', 2, "./resources/Parfure.jpg"));

                            }

                            else if (creatureSelect1.getEvolutionLv() == 2) {

                                user1.getPlayerInv().getRoster()
                                        .add(new EL3("Parfelure", "Fire", 'C', 3, "./resources/Parfelure.jpg"));

                            }

                        }
                            ;
                            break;
                    }

                    user1.getPlayerInv().getRoster().remove(index1);
                    user1.getPlayerInv().getRoster().remove(index2);

                    if (index1 == 0 || index2 == 0) {
                        user1.setActiveCreature(0);
                    }

                    index1 = 0;
                    index2 = 0;
                    creatureSelect1 = null;
                    creatureSelect2 = null;
                    evolutionResult = "Evolution Success";
                }
            }
        }

    }

    /**
     * Returns a new Creature instance that is randomly chosen out of the possible
     * creatures that exist
     * 
     * @return Creature
     * 
     * 
     */
    public static Creature randomCreatureEL1() {
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

            int i = 0;
            while (i < names.length) {

                if (randomName.equals(names[i])) {
                    creatureFamily = families[i];

                    if (families[i] == ('A') || families[i] == ('C')) {
                        creatureImagePath += ".jpg";
                    } else {
                        creatureImagePath += ".png";
                    }
                }
                i++;
            }

        } else if ("Brownisaur".equals(randomName) || "Frubat".equals(randomName) || "Malts".equals(randomName)) {
            creatureType = "Grass";

            int i = 3;
            while (i < names.length) {

                if (randomName.equals(names[i])) {
                    creatureFamily = families[i];
                    creatureImagePath += ".png";

                }
                i++;
            }

        } else if ("Squirpie".equals(randomName) || "Chocolite".equals(randomName) || "Oshacone".equals(randomName)) {
            creatureType = "Water";

            int i = 0;
            while (i < names.length) {

                if (randomName.equals(names[i])) {
                    creatureFamily = families[i];

                    if (families[i] == ('G')) {
                        creatureImagePath += ".jpg";
                    } else {
                        creatureImagePath += ".png";
                    }
                }
                i++;
            }
        }

        return new EL1(randomName, creatureType, creatureFamily, 1, creatureImagePath);
    }

    public static Creature randomCreatureEL2() {
        Random rng = new Random();

        String[] names = { "Strawleon", "Chocofluff", "Parfure", "Chocosaur",
                "Golberry", "Kirlicake", "Tartortle", "Chocolish", "Dewice" };

        char[] families = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I' };

        String creatureType = "";
        char creatureFamily = '1';

        String randomName = names[rng.nextInt(names.length)];

        String creatureImagePath = "./resources/";
        creatureImagePath += randomName;

        if ("Strawleon".equals(randomName) || "Chocofluff".equals(randomName) || "Parfure".equals(randomName)) {
            creatureType = "Fire";

            int i = 0;
            while (i < names.length) {

                if (randomName.equals(names[i])) {
                    creatureFamily = families[i];

                    if (families[i] == ('C')) {
                        creatureImagePath += ".jpg";
                    } else {
                        creatureImagePath += ".png";
                    }
                }
                i++;
            }

        } else if ("Chocosaur".equals(randomName) || "Golberry".equals(randomName) || "Kirlicake".equals(randomName)) {
            creatureType = "Grass";

            int i = 0;
            while (i < names.length) {

                if (randomName.equals(names[i])) {
                    creatureFamily = families[i];
                    creatureImagePath += ".png";

                }
                i++;
            }

        } else if ("Tartortle".equals(randomName) || "Chocolish".equals(randomName) || "Dewice".equals(randomName)) {
            creatureType = "Water";

            int i = 0;
            while (i < names.length) {

                if (randomName.equals(names[i])) {
                    creatureFamily = families[i];
                    creatureImagePath += ".png";

                }
                i++;
            }
        }

        return new EL2(randomName, creatureType, creatureFamily, 2, creatureImagePath);
    }

    public static Creature randomCreatureEL3() {
        Random rng = new Random();

        String[] names = { "Strawizard", "Candaros", "Parfelure", "Fudgasaur",
                "Croberry", "Velvevoir", "Piestoise", "Icesundae", "Samurcone" };

        char[] families = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I' };

        String creatureType = "";
        char creatureFamily = '1';

        String randomName = names[rng.nextInt(names.length)];

        String creatureImagePath = "./resources/";
        creatureImagePath += randomName;

        if ("Strawizard".equals(randomName) || "Candaros".equals(randomName) || "Parfelure".equals(randomName)) {
            creatureType = "Fire";

            int i = 0;
            while (i < names.length) {

                if (randomName.equals(names[i])) {
                    creatureFamily = families[i];

                    if (families[i] == ('C')) {
                        creatureImagePath += ".jpg";
                    } else {
                        creatureImagePath += ".png";
                    }
                }
                i++;
            }

        } else if ("Fudgasaur".equals(randomName) || "Croberry".equals(randomName) || "Velvevoir".equals(randomName)) {
            creatureType = "Grass";

            int i = 0;
            while (i < names.length) {

                if (randomName.equals(names[i])) {
                    creatureFamily = families[i];
                    creatureImagePath += ".png";

                }
                i++;
            }

        } else if ("Piestoise".equals(randomName) || "Icesundae".equals(randomName) || "Samurcone".equals(randomName)) {
            creatureType = "Water";

            int i = 0;
            while (i < names.length) {

                if (randomName.equals(names[i])) {
                    creatureFamily = families[i];

                    if (families[i] == ('G')) {
                        creatureImagePath += ".jpg";
                    } else {
                        creatureImagePath += ".png";
                    }
                }
                i++;
            }
        }

        return new EL3(randomName, creatureType, creatureFamily, 3, creatureImagePath);
    }
}
