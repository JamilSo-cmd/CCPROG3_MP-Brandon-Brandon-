
/**
 * <B>View of the Program<B>
 * 
 * @author Brandon Jaramillo Anthony  
 * @author Brandon Jamil So
 * @version 2.0
 * 
 */
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.imageio.ImageIO;

import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.GridBagConstraints;
import java.awt.Image;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.*;
import java.net.*;

public class MainView {

    private JFrame startFrame;
    private JFrame menuFrame;
    private JFrame inventoryFrame;
    private JFrame chooseAreaFrame;
    private JFrame area1Frame;
    private JFrame area2Frame;
    private JFrame area3Frame;
    private JFrame evolutionFrame;
    private JFrame encounterFrame;
    private JPanel creatureListPanel;
    private JPanel starterPanel;
    private JPanel chooseExplorePanel;
    private JPanel statusPanel;
    private JButton inventoryBtn;
    private JButton chooseExploreBtn;
    private JButton area1Btn;
    private JButton area2Btn;
    private JButton area3Btn;
    private JButton leftBtn;
    private JButton rightBtn;
    private JButton upBtn;
    private JButton downBtn;
    private JButton exploreBtn;
    private JButton evolveBtn;
    private JButton evolutionBtn;
    private ActionListener switchAction;
    private ActionListener selectAction1;
    private ActionListener selectAction2;
    private ActionListener leftAction;
    private ActionListener rightAction;
    private ActionListener upAction;
    private ActionListener downAction;
    private ActionListener evolveAction;
    private JPanel evolutionPanel1;
    private JPanel evolutionPanel2;
    private JPanel resultPanel;
    private JLabel resultLbl;
    private JLabel selectImgLbl;
    private ActionListener attackAction;
    private JButton attackBtn;
    private ActionListener catchAction;
    private JButton catchBtn;
    private JFrame swapFrame;
    private ActionListener swapAction;
    private JButton swapBtn;
    private JPanel creatureSwapList;
    private ActionListener swappingAction;
    private JPanel mainPanel;
    private int[][]  tiles;
    private int rows;
    private int columns;
    private ActionListener areaEvent;
    private JFrame selectAreaFrame;
    private int level;
    private JButton runBtn;
    private ActionListener runAction;

    public MainView() {

        this.startFrame = new JFrame("Choose your starter!");
        this.startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.startFrame.setLayout(new FlowLayout());
        this.startFrame.setSize(600, 400);
        this.startFrame.setLocationRelativeTo(null);
        starterPick();

        this.startFrame.setVisible(true);

        this.menuFrame = new JFrame("Menu Options");
        this.menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.menuFrame.setLayout(new FlowLayout());
        this.menuFrame.setSize(450, 200);
        this.menuFrame.setLocationRelativeTo(null);
        initializeMenu();

        this.menuFrame.setVisible(false);

        this.inventoryFrame = new JFrame("Inventory");
        this.inventoryFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.inventoryFrame.setLayout(new FlowLayout());
        this.inventoryFrame.setSize(450, 800);
        this.inventoryFrame.setLocationRelativeTo(null);
        initializeInventory();

        this.inventoryFrame.setVisible(false);

        this.chooseAreaFrame = new JFrame("Explore");
        this.chooseAreaFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.chooseAreaFrame.setLayout(new FlowLayout());
        this.chooseAreaFrame.setSize(800, 300);
        this.chooseAreaFrame.setLocationRelativeTo(null);
        initializeChooseAreaMenu();

        this.chooseAreaFrame.setVisible(false);

        this.area1Frame = new JFrame("Area 1");
        this.area1Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.area1Frame.setLayout(new FlowLayout());
        this.area1Frame.setSize(600, 600);
        this.area1Frame.setLocationRelativeTo(null);
        initializeArea(1);

        this.area1Frame.setVisible(false);

        this.area2Frame = new JFrame("Area 2");
        this.area2Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.area2Frame.setLayout(new FlowLayout());
        this.area2Frame.setSize(600, 600);
        this.area2Frame.setLocationRelativeTo(null);
        initializeArea(2);

        this.area2Frame.setVisible(false);

        this.area3Frame = new JFrame("Area 3");
        this.area3Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.area3Frame.setLayout(new FlowLayout());
        this.area3Frame.setSize(600, 600);
        this.area3Frame.setLocationRelativeTo(null);
        initializeArea(3);

        this.area3Frame.setVisible(false);

        this.evolutionFrame = new JFrame("Evolution");
        this.evolutionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.evolutionFrame.setLayout(new FlowLayout());
        this.evolutionFrame.setSize(1500, 800);
        this.evolutionFrame.setLocationRelativeTo(null);

        initializeEvolutionMenu();
        this.evolutionFrame.setVisible(false);

        this.encounterFrame = new JFrame("An Encounter Has Appeared!");
        this.encounterFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.encounterFrame.setLayout(new FlowLayout());
        this.encounterFrame.setSize(600, 400);
        this.encounterFrame.setLocationRelativeTo(null);

        initializeEncounterScreen();
        this.encounterFrame.setVisible(false);

        this.swapFrame = new JFrame("Swap Creature");
        this.swapFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.swapFrame.setLayout(new FlowLayout());
        this.swapFrame.setSize(600, 400);
        this.swapFrame.setLocationRelativeTo(null);

        initializeSwapScreen();
        this.swapFrame.setVisible(false);

    }

    private void starterPick() {
        JLabel greetingsPromptLbl = new JLabel();
        JPanel mainPanel = new JPanel(new GridLayout(2, 1));

        greetingsPromptLbl.setText("<html><h2>Pick a Starter</h2></html>");

        greetingsPromptLbl.setHorizontalAlignment(JLabel.CENTER);

        this.starterPanel = new JPanel(new GridLayout(1, 3));

        mainPanel.add(greetingsPromptLbl);
        mainPanel.add(starterPanel);

        this.startFrame.add(mainPanel);
    }

    private void initializeMenu() {
        JLabel menu = new JLabel();
        JPanel panel = new JPanel(new BorderLayout());

        menu.setText("<html><h1>MENU SCREEN</h1></html>");

        this.inventoryBtn = new JButton("View Inventory");
        this.inventoryBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuFrame.setVisible(false);
                inventoryFrame.setVisible(true);
            }
        });
        this.chooseExploreBtn = new JButton("Explore the Map");
        this.chooseExploreBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuFrame.setVisible(false);
                chooseAreaFrame.setVisible(true);
            }
        });
        this.evolveBtn = new JButton("Evolve a Creature");
        this.evolveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuFrame.setVisible(false);
                evolutionFrame.setVisible(true);

            }
        });

        JButton exitBtn = new JButton("Exit Program");
        exitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        panel.add(this.inventoryBtn, BorderLayout.EAST);
        panel.add(chooseExploreBtn, BorderLayout.CENTER);
        panel.add(evolveBtn, BorderLayout.WEST);
        panel.add(exitBtn, BorderLayout.SOUTH);

        this.menuFrame.add(menu);
        this.menuFrame.add(panel);
    }

    public void initializeInventory() {

        JPanel mainPanel = new JPanel(new GridLayout(1, 1));

        creatureListPanel = new JPanel(new GridLayout(0, 1));
        // add options
        JButton returnBtn = new JButton("Exit Inventory");
        returnBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inventoryFrame.setVisible(false);
                menuFrame.setVisible(true);
            }
        });

        mainPanel.add(creatureListPanel);

        this.inventoryFrame.add(returnBtn);
        this.inventoryFrame.add(mainPanel);
    }

    public void initializeChooseAreaMenu() {
        JLabel chooseAreaLbl = new JLabel();
        JPanel mainPanel = new JPanel(new FlowLayout(1, 9, 20));

        chooseAreaLbl.setText("<html><h2>Which Area will you go to?</h2></html>");
        chooseAreaLbl.setHorizontalAlignment(JLabel.CENTER);

        this.chooseExplorePanel = new JPanel(new GridLayout(3, 3));

        JButton returnBtn = new JButton("Go Back to Main Menu");
        returnBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chooseAreaFrame.setVisible(false);
                menuFrame.setVisible(true);
            }
        });

        this.area1Btn = new JButton("Area 1");
        this.area1Btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chooseAreaFrame.setVisible(false);
            }
        });

        this.area2Btn = new JButton("Area 2");
        this.area2Btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chooseAreaFrame.setVisible(false);
            }
        });

        this.area3Btn = new JButton("Area 3");
        this.area3Btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chooseAreaFrame.setVisible(false);
            }
        });

        mainPanel.add(chooseAreaLbl);
        mainPanel.add(chooseExplorePanel);
        mainPanel.add(area1Btn);
        mainPanel.add(area2Btn);
        mainPanel.add(area3Btn);
        mainPanel.add(returnBtn);
        this.chooseAreaFrame.add(mainPanel);
    }

    private void initializeArea(int level) {


        JFrame initialFrame;
        
        switch (level){
            
            case 1: initialFrame = this.area1Frame; 
                    this.level = 1;
            break;
            case 2: initialFrame = this.area2Frame; 
                    this.level = 2; 
            break;
            case 3: initialFrame = this.area3Frame; 
                    this.level = 3; 
            break;
            default: initialFrame = this.area1Frame; 
                    this.level = 1;

        }

        Area curArea = new Area(level);
        
        this.tiles = curArea.getTiles();
        this.rows = curArea.getRows();
        this.columns = curArea.getColumns();

        JPanel actionsPanel = new JPanel(new BorderLayout());
        this.mainPanel = new JPanel(new GridLayout( this.rows,  this.columns));
        JPanel returnPanel = new JPanel(new FlowLayout());

        this.leftBtn = new JButton("Move Left");
        actionsPanel.add(leftBtn, BorderLayout.WEST);

        this.rightBtn = new JButton("Move Right");
        actionsPanel.add(rightBtn, BorderLayout.EAST);

        this.upBtn = new JButton("Move Up");
        actionsPanel.add(upBtn, BorderLayout.NORTH);

        this.downBtn = new JButton("Move Down");
        actionsPanel.add(downBtn, BorderLayout.SOUTH);

        JButton returnBtn = new JButton("Go Back to Map");
        returnBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initialFrame.setVisible(false);
                chooseAreaFrame.setVisible(true);
            }
        });

        initialFrame.setLayout(new GridLayout(3, 1));

        returnPanel.add(returnBtn);
        initialFrame.add(this.mainPanel);
        initialFrame.add(actionsPanel);
        initialFrame.add(returnPanel);
    }

    public void getArea (){
        
    }

    public void reloadArea(boolean encounterFlag, int[][] playerPos,int level) {


        System.out.println(level + "check");

        switch (level){
            
            case 1: this.selectAreaFrame = this.area1Frame; 
                    this.level = 1;
            break;
            case 2: this.selectAreaFrame = this.area2Frame; 
                    this.level = 2; 
            break;
            case 3: this.selectAreaFrame = this.area3Frame; 
                    this.level = 3; 
            break;
            default: this.selectAreaFrame = this.area1Frame; 
                    this.level = 1;

        }
        this.selectAreaFrame.setVisible(true);

        reloadArea(encounterFlag, playerPos);
    }
    

    public void reloadArea(boolean encounterFlag, int[][] playerPos) {
        
        if (encounterFlag == true){

            this.selectAreaFrame.setVisible(false);
            this.encounterFrame.setVisible(true);

        }

        int[][] coordinate;

        this.mainPanel.removeAll();

        for (int y = 0; y < this.tiles.length; y++) {
            for (int x = 0; x < this.tiles[y].length; x++) {
                JLabel tile = new JLabel();

                if (playerPos[0][0] == x && playerPos[0][1]  == y) {
                    tile.setIcon(this.createImageIcon("./resources/Player.png", "test"));
                } else {
                    tile.setIcon(this.createImageIcon("./resources/Grass.png", "test"));
                }

                this.mainPanel.add(tile);
            }
        }

        this.rightBtn.removeActionListener(rightAction);
        this.rightBtn.addActionListener(rightAction);

        this.leftBtn.removeActionListener(leftAction);
        this.leftBtn.addActionListener(leftAction);

        this.upBtn.removeActionListener(upAction);
        this.upBtn.addActionListener(upAction);
        
        this.downBtn.removeActionListener(downAction);
        this.downBtn.addActionListener(downAction);

        this.selectAreaFrame.revalidate();

    }
    
    public int getLevel() {
        return level;
    }

    public void assignOpenAreaEvent(ActionListener openArea){

        this.areaEvent = openArea;

    }

    public void initializeEncounterScreen() {

        JPanel mainEncounterPanel = new JPanel(new GridLayout(2, 1));
        JPanel encounterBtnPanel = new JPanel(new GridLayout(1, 4));
        this.statusPanel = new JPanel(new GridLayout(1, 3));

        this.runBtn = new JButton("Run Away");
        this.runBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                encounterFrame.setVisible(false);
                selectAreaFrame.setVisible(true);
            }

        });

        this.attackBtn = new JButton("Attack");
        this.swapBtn = new JButton("Swap");
        this.swapBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                encounterFrame.setVisible(false);
                swapFrame.setVisible(true);
            }
        });

        this.catchBtn = new JButton("Catch");

        encounterBtnPanel.add(attackBtn);
        encounterBtnPanel.add(this.swapBtn);
        encounterBtnPanel.add(catchBtn);
        encounterBtnPanel.add(this.runBtn);

        mainEncounterPanel.add(statusPanel);
        mainEncounterPanel.add(encounterBtnPanel);

        this.encounterFrame.add(mainEncounterPanel);

    }

    private void initializeSwapScreen() {
        JPanel mainPanel = new JPanel(new GridLayout(1, 1));

        this.creatureSwapList = new JPanel(new GridLayout(0, 1));

        mainPanel.add(this.creatureSwapList);
        this.swapFrame.add(mainPanel);
    }

    public void initializeEvolutionMenu() {

        JPanel selectionPanel = new JPanel(new GridLayout(1, 3));
        evolutionPanel1 = new JPanel(new GridLayout(0, 1));
        evolutionPanel2 = new JPanel(new GridLayout(0, 1));

        resultPanel = new JPanel(new GridLayout(1, 3));
        JPanel buttonPanel = new JPanel(new GridLayout(3, 1));

        JButton returnBtn = new JButton("Return to Menu");
        returnBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evolutionFrame.setVisible(false);
                menuFrame.setVisible(true);
            }

        });

        this.evolutionBtn = new JButton("Proceed to Evolution");

        buttonPanel.add(resultPanel);
        buttonPanel.add(this.evolutionBtn);
        buttonPanel.add(returnBtn);

        selectionPanel.add(evolutionPanel1);
        selectionPanel.add(buttonPanel);
        selectionPanel.add(evolutionPanel2);
        this.evolutionFrame.add(selectionPanel);
    }

    public void createStarterButton(String desc, ActionListener action) {

        JButton btn = new JButton(desc);
        btn.addActionListener(action);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startFrame.dispose();
                menuFrame.setVisible(true);
                // replace frame with the exploration frame
            }
        });

        this.starterPanel.add(btn);
        this.startFrame.revalidate();
    }

    public void setEvolutionActionEvent(ActionListener evolve) {

        this.evolveAction = evolve;

    }

    public void reloadInventory(ArrayList<Creature> creatureList) {

        this.creatureListPanel.removeAll();
        this.generateCreatureList(creatureList);
        this.inventoryFrame.revalidate();

    }

    public void generateCreatureEvolutionList1(ArrayList<Creature> creatureList) {

        for (int i = 0; i < creatureList.size(); i++) {
            JButton selectBtn = new JButton("Select");
            selectBtn.putClientProperty("index", i);
            selectBtn.addActionListener(this.selectAction1);
            JPanel creaturePanel = new JPanel(new GridLayout(1, 3));
            JLabel creatureLbl = new JLabel();
            Creature curCreature = creatureList.get(i);
            JLabel creatureImgLbl = new JLabel();

            creatureImgLbl.setIcon(this.createImageIcon(curCreature.getImagePath(), "test"));
            creatureLbl.setText("<html><body>Name: " + curCreature.getName()
                    + "<br>Type: " + curCreature.getType()
                    + "<br>Family: " + curCreature.getFamily()
                    + "<br>Evolution Lv: " + curCreature.getEvolutionLv()
                    + "<hr></html></body>");

            creaturePanel.add(selectBtn);
            creaturePanel.add(creatureLbl);
            creaturePanel.add(creatureImgLbl);
            this.evolutionPanel1.add(creaturePanel);
        }

    }

    public void generateCreatureEvolutionList2(ArrayList<Creature> creatureList) {

        for (int i = 0; i < creatureList.size(); i++) {
            JButton selectBtn = new JButton("Select");
            selectBtn.putClientProperty("index", i);
            selectBtn.addActionListener(this.selectAction2);
            JPanel creaturePanel = new JPanel(new GridLayout(1, 3));
            JLabel creatureLbl = new JLabel();
            Creature curCreature = creatureList.get(i);
            JLabel creatureImgLbl = new JLabel();

            creatureImgLbl.setIcon(this.createImageIcon(curCreature.getImagePath(), "test"));
            creatureLbl.setText("<html><body>Name: " + curCreature.getName()
                    + "<br>Type: " + curCreature.getType()
                    + "<br>Family: " + curCreature.getFamily()
                    + "<br>Evolution Lv: " + curCreature.getEvolutionLv()
                    + "<hr></html></body>");

            creaturePanel.add(selectBtn);
            creaturePanel.add(creatureLbl);
            creaturePanel.add(creatureImgLbl);
            this.evolutionPanel2.add(creaturePanel);
        }

    }

    public void generateCreatureList(ArrayList<Creature> creatureList) {

        JLabel curActiveLbl = new JLabel("<html><h3>Currently Active</h3></html>");
        JPanel activeCreaturePanel = new JPanel(new GridLayout(1, 3));
        JLabel activeCreatureLbl = new JLabel();
        Creature activeCurCreature = creatureList.get(0);
        JLabel activeCreatureImgLbl = new JLabel();

        activeCreatureImgLbl.setIcon(this.createImageIcon(activeCurCreature.getImagePath(), "test"));
        activeCreatureLbl.setText("<html><body>Name: " + activeCurCreature.getName()
                + "<br>Type: " + activeCurCreature.getType()
                + "<br>Family: " + activeCurCreature.getFamily()
                + "<br>Evolution Lv: " + activeCurCreature.getEvolutionLv()
                + "<hr></html></body>");

        activeCreaturePanel.add(curActiveLbl);
        activeCreaturePanel.add(activeCreatureLbl);
        activeCreaturePanel.add(activeCreatureImgLbl);
        this.creatureListPanel.add(activeCreaturePanel);

        for (int i = 1; i < creatureList.size(); i++) {
            JButton switchBtn = new JButton("Set Active Creature");
            switchBtn.putClientProperty("index", i);
            switchBtn.addActionListener(this.switchAction);
            JPanel creaturePanel = new JPanel(new GridLayout(1, 3));
            JLabel creatureLbl = new JLabel();
            Creature curCreature = creatureList.get(i);
            JLabel creatureImgLbl = new JLabel();

            creatureImgLbl.setIcon(this.createImageIcon(curCreature.getImagePath(), "test"));
            creatureLbl.setText("<html><body>Name: " + curCreature.getName()
                    + "<br>Type: " + curCreature.getType()
                    + "<br>Family: " + curCreature.getFamily()
                    + "<br>Evolution Lv: " + curCreature.getEvolutionLv()
                    + "<hr></html></body>");

            creaturePanel.add(switchBtn);
            creaturePanel.add(creatureLbl);
            creaturePanel.add(creatureImgLbl);
            this.creatureListPanel.add(creaturePanel);
        }

    }

    public void assignOpenInvEvent(ActionListener action) {

        this.inventoryBtn.addActionListener(action);

    }

    /**
     * Returns an ImageIcon, or null if the path was invalid.
     */
    protected ImageIcon createImageIcon(String path,
            String description) {
        URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            ImageIcon imageIcon = new ImageIcon(path); // load the image to a imageIcon
            Image image = imageIcon.getImage(); // transform it
            Image newimg = image.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
            imageIcon = new ImageIcon(newimg); // transform it back
            return imageIcon;
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    public void assignOpenEvoEvent(ActionListener action) {

        this.evolveBtn.addActionListener(action);

    }

    public void reloadEvolution(ArrayList<Creature> creatureList, Creature selection1, Creature selection2,
            String evoResult) {

        this.resultPanel.removeAll();

        try {
            this.selectImgLbl = new JLabel();
            this.selectImgLbl.setIcon(this.createImageIcon(selection1.getImagePath(), "Selection 1"));
            this.selectImgLbl.setHorizontalAlignment(JLabel.CENTER);
            this.resultPanel.add(selectImgLbl);
        } catch (Exception e) {
            this.resultPanel.add(new JLabel("Selection 1"));
        }
        this.resultLbl = new JLabel(evoResult);
        this.resultLbl.setHorizontalAlignment(JLabel.CENTER);
        this.resultPanel.add(resultLbl);

        try {
            this.selectImgLbl = new JLabel();
            this.selectImgLbl.setIcon(this.createImageIcon(selection2.getImagePath(), "Selection 2"));
            this.selectImgLbl.setHorizontalAlignment(JLabel.CENTER);
            this.resultPanel.add(selectImgLbl);
        } catch (Exception e) {
            this.resultPanel.add(new JLabel("   Selection 2"));
        }

        this.evolutionPanel1.removeAll();
        this.generateCreatureEvolutionList1(creatureList);
        this.evolutionPanel2.removeAll();
        this.generateCreatureEvolutionList2(creatureList);

        this.evolutionBtn.removeActionListener(this.evolveAction);
        this.evolutionBtn.addActionListener(this.evolveAction);

        this.evolutionFrame.revalidate();

    }

    public void reloadEncounter(Creature activeCreature, Creature enemy, boolean catchFlag, int timer) {

        this.statusPanel.removeAll();
        JLabel selectImgLbl = new JLabel();
        selectImgLbl.setIcon(this.createImageIcon(activeCreature.getImagePath(), "Active Creature"));
        selectImgLbl.setHorizontalAlignment(JLabel.CENTER);
        statusPanel.add(selectImgLbl);

        JLabel enemyStat = new JLabel();

        enemyStat.setText("<html><body>Name: " + enemy.getName()
                + "<br>Family: " + enemy.getFamily()
                + "<br>Evolution Lv: " + enemy.getEvolutionLv()
                + "<br>Current HP: " + enemy.getHealthPoints()
                + "<hr></html></body>");

        this.statusPanel.add(enemyStat);

        JLabel enemyImg = new JLabel();
        enemyImg.setIcon(this.createImageIcon(enemy.getImagePath(), "Enemy Creature"));
        this.statusPanel.add(enemyImg);

        this.attackBtn.removeActionListener(this.attackAction);
        this.attackBtn.addActionListener(this.attackAction);

        this.catchBtn.removeActionListener(this.catchAction);
        this.catchBtn.addActionListener(this.catchAction);

        this.swapBtn.removeActionListener(this.swapAction);
        this.swapBtn.addActionListener(this.swapAction);
        
        this.runBtn.removeActionListener(this.runAction);
        this.runBtn.addActionListener(this.runAction);

        this.encounterFrame.revalidate();

        if (enemy.getHealthPoints() <= 0 || catchFlag == true || timer <= 0) {

            this.selectAreaFrame.setVisible(true);
            this.encounterFrame.setVisible(false);

        }
    }

    public void setRunActionEvent (ActionListener run){
        this.runAction = run;

    }

    public void generateSwappingList(ArrayList<Creature> creatureList) {

        JLabel curActiveLbl = new JLabel("<html><h3>Currently Active</h3></html>");
        JPanel activeCreaturePanel = new JPanel(new GridLayout(1, 3));
        JLabel activeCreatureLbl = new JLabel();
        Creature activeCurCreature = creatureList.get(0);
        JLabel activeCreatureImgLbl = new JLabel();

        activeCreatureImgLbl.setIcon(this.createImageIcon(activeCurCreature.getImagePath(), "test"));
        activeCreatureLbl.setText("<html><body>Name: " + activeCurCreature.getName()
                + "<br>Type: " + activeCurCreature.getType()
                + "<br>Family: " + activeCurCreature.getFamily()
                + "<br>Evolution Lv: " + activeCurCreature.getEvolutionLv()
                + "<hr></html></body>");

        activeCreaturePanel.add(curActiveLbl);
        activeCreaturePanel.add(activeCreatureLbl);
        activeCreaturePanel.add(activeCreatureImgLbl);
        this.creatureListPanel.add(activeCreaturePanel);

        for (int i = 1; i < creatureList.size(); i++) {
            JButton switchBtn = new JButton("Set Active Creature");
            switchBtn.putClientProperty("index", i);
            switchBtn.addActionListener(this.swappingAction);
            JPanel creaturePanel = new JPanel(new GridLayout(1, 3));
            JLabel creatureLbl = new JLabel();
            Creature curCreature = creatureList.get(i);
            JLabel creatureImgLbl = new JLabel();

            creatureImgLbl.setIcon(this.createImageIcon(curCreature.getImagePath(), "test"));
            creatureLbl.setText("<html><body>Name: " + curCreature.getName()
                    + "<br>Type: " + curCreature.getType()
                    + "<br>Family: " + curCreature.getFamily()
                    + "<br>Evolution Lv: " + curCreature.getEvolutionLv()
                    + "<hr></html></body>");

            creaturePanel.add(switchBtn);
            creaturePanel.add(creatureLbl);
            creaturePanel.add(creatureImgLbl);
            this.creatureSwapList.add(creaturePanel);
        }
    }

    public void reloadSwap(ArrayList<Creature> creatureList, boolean swapFlag) {

        this.creatureSwapList.removeAll();
        this.generateSwappingList(creatureList);
        this.swapFrame.revalidate();

        if (swapFlag == true) {
            this.swapFrame.setVisible(false);
            this.encounterFrame.setVisible(true);
        }

    }

    public void setLeftActionEvent(ActionListener moveLeft) {

        this.leftAction = moveLeft;

    }

    public void setRightActionEvent(ActionListener moveRight) {

        this.rightAction = moveRight;

    }

    public void setUpActionEvent(ActionListener moveUp) {

        this.upAction = moveUp;

    }

    public void setDownActionEvent(ActionListener moveDown) {

        this.downAction = moveDown;

    }

    public void setSelectActionEvent1(ActionListener SelectAction) {

        this.selectAction1 = SelectAction;
    }

    public void setSelectActionEvent2(ActionListener selectAction) {

        this.selectAction2 = selectAction;
    }

    public void setSwitchActionEvent(ActionListener switchAction) {

        this.switchAction = switchAction;

    }

    public void setAttackActionEvent(ActionListener attack) {

        this.attackAction = attack;

    }

    public void setCatchActionEvent(ActionListener capture) {

        this.catchAction = capture;

    }

    public void assignSwapEvent(ActionListener swap) {

        this.swapAction = swap;

    }

    public void setSwappingActionEvent(ActionListener swapping) {

        this.swappingAction = swapping;

    }

    public void assignChooseAreaEvent (){

        this.area1Btn.putClientProperty("level", 1);
        this.area1Btn.addActionListener(areaEvent);
        this.area2Btn.putClientProperty("level", 2);
        this.area2Btn.addActionListener(areaEvent);
        this.area3Btn.putClientProperty("level", 3);
        this.area3Btn.addActionListener(areaEvent);

    }
}
