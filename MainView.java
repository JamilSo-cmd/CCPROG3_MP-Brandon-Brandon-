
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
import java.awt.GridLayout;
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
    private JFrame evolutionFrame;
    private JPanel creatureListPanel;
    private JPanel starterPanel;
    private JButton inventoryBtn;
    private JButton evolveBtn;
    private ActionListener switchAction;
    private JPanel evolutionPanel1;
    private JPanel evolutionPanel2;
        

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
        
        this.evolutionFrame = new JFrame("Evolution");
        this.evolutionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      
        this.evolutionFrame.setLayout(new FlowLayout());
        this.evolutionFrame.setSize(1500, 800);
        this.evolutionFrame.setLocationRelativeTo(null);

        initializeEvolutionMenu();
        this.evolutionFrame.setVisible(false);
    }

    private void starterPick (){
        JLabel greetingsPromptLbl = new JLabel();
        JPanel mainPanel = new JPanel(new GridLayout(2,1));

        greetingsPromptLbl.setText("<html><h2>Pick a Starter</h2></html>");

        greetingsPromptLbl.setHorizontalAlignment(JLabel.CENTER);

        this.starterPanel = new JPanel(new GridLayout(1,3));

        mainPanel.add(greetingsPromptLbl);
        mainPanel.add(starterPanel);

        this.startFrame.add(mainPanel);
    }

    private void initializeMenu () {
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
        JButton exploreBtn = new JButton("Explore an Area");
        exploreBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuFrame.setVisible(false);  
                //set window for area to visible
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
                menuFrame.dispose();
            }
        });

        panel.add(this.inventoryBtn, BorderLayout.EAST);
        panel.add(exploreBtn, BorderLayout.CENTER);
        panel.add(evolveBtn, BorderLayout.WEST);
        panel.add(exitBtn, BorderLayout.SOUTH);

        this.menuFrame.add(menu);
        this.menuFrame.add(panel);
    }

    public void setSwitchActionEvent (ActionListener switchAction){

        this.switchAction = switchAction;
        
    }

    public void initializeInventory (){
        JLabel text = new JLabel();
        JPanel mainPanel = new JPanel(new GridLayout(2,1));
        creatureListPanel = new JPanel(new GridLayout(0,1));
        JPanel options = new JPanel(new GridLayout(1,1));

        //add options
        JButton returnBtn = new JButton("Exit Inventory");
        returnBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inventoryFrame.setVisible(false);
                menuFrame.setVisible(true);
            }
        });

        options.add(returnBtn);
        mainPanel.add(options);
        mainPanel.add(creatureListPanel);
        

        this.inventoryFrame.add(text);
        this.inventoryFrame.add(mainPanel);
    }

    public void initializeEvolutionMenu(){
        
        JPanel selectionPanel = new JPanel(new GridLayout(1,3));
        evolutionPanel1 = new JPanel(new GridLayout(0,1));
        evolutionPanel2 = new JPanel(new GridLayout(0,1));
        JPanel buttonPanel = new JPanel(new GridLayout(3,1));
        
        JButton returnBtn = new JButton("Return to Menu");
        returnBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evolutionFrame.setVisible(false);
                menuFrame.setVisible(true);
            }
            
        });

        JButton evolveBtn = new JButton("Proceed to Evolution");

        buttonPanel.add(new JLabel("Result goes here"));
        buttonPanel.add(evolveBtn);
        buttonPanel.add(returnBtn);

        selectionPanel.add(evolutionPanel1);
        selectionPanel.add(buttonPanel);
        selectionPanel.add(evolutionPanel2);
        this.evolutionFrame.add(selectionPanel);
    }

    public void createStarterButton (String desc, ActionListener action){
        JButton btn = new JButton(desc);
        btn.addActionListener(action);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startFrame.dispose();
                menuFrame.setVisible(true);      
            }
        });
        
        this.starterPanel.add(btn);
        this.startFrame.revalidate();
    }

    public void reloadInventory (ArrayList<Creature> creatureList){

        this.creatureListPanel.removeAll();
        this.generateCreatureList(creatureList);
        this.inventoryFrame.revalidate();

    } 

    public void generateCreatureEvolutionList1 (ArrayList<Creature> creatureList){

        for (int i = 0; i < creatureList.size();i++){
            JButton switchBtn = new JButton("Select");
            switchBtn.putClientProperty("index", i);
            switchBtn.addActionListener(this.switchAction);
            JPanel creaturePanel = new JPanel(new GridLayout(1,3));
            JLabel creatureLbl = new JLabel();
            Creature curCreature = creatureList.get(i);            
            JLabel creatureImgLbl = new JLabel();

            creatureImgLbl.setIcon(this.createImageIcon(curCreature.getImagePath(),"test"));
            creatureLbl.setText("<html><body>Name: " + curCreature.getName() 
                                + "<br>Type: " + curCreature.getType()
                                + "<br>Family: " + curCreature.getFamily()
                                + "<br>Evolution Lv: " + curCreature.getEvolutionLv()
                                + "<hr></html></body>");
            
            creaturePanel.add(switchBtn);
            creaturePanel.add(creatureLbl);
            creaturePanel.add(creatureImgLbl);
            this.evolutionPanel1.add(creaturePanel);
        }

    }

    public void generateCreatureEvolutionList2 (ArrayList<Creature> creatureList){

        for (int i = 0; i < creatureList.size();i++){
            JButton switchBtn = new JButton("Select");
            switchBtn.putClientProperty("index", i);
            switchBtn.addActionListener(this.switchAction);
            JPanel creaturePanel = new JPanel(new GridLayout(1,3));
            JLabel creatureLbl = new JLabel();
            Creature curCreature = creatureList.get(i);            
            JLabel creatureImgLbl = new JLabel();

            creatureImgLbl.setIcon(this.createImageIcon(curCreature.getImagePath(),"test"));
            creatureLbl.setText("<html><body>Name: " + curCreature.getName() 
                                + "<br>Type: " + curCreature.getType()
                                + "<br>Family: " + curCreature.getFamily()
                                + "<br>Evolution Lv: " + curCreature.getEvolutionLv()
                                + "<hr></html></body>");
            
            creaturePanel.add(switchBtn);
            creaturePanel.add(creatureLbl);
            creaturePanel.add(creatureImgLbl);
            this.evolutionPanel2.add(creaturePanel);
        }

    }

    public void generateCreatureList (ArrayList<Creature> creatureList) {
        
        JLabel curActiveLbl = new JLabel("<html><h3>Currently Active</h3></html>");
        JPanel activeCreaturePanel = new JPanel(new GridLayout(1,3));
        JLabel activeCreatureLbl = new JLabel();
        Creature activeCurCreature = creatureList.get(0);            
        JLabel activeCreatureImgLbl = new JLabel();

        activeCreatureImgLbl.setIcon(this.createImageIcon(activeCurCreature.getImagePath(),"test"));
        activeCreatureLbl.setText("<html><body>Name: " + activeCurCreature.getName() 
                            + "<br>Type: " + activeCurCreature.getType()
                            + "<br>Family: " + activeCurCreature.getFamily()
                            + "<br>Evolution Lv: " + activeCurCreature.getEvolutionLv()
                            + "<hr></html></body>");
                            
        activeCreaturePanel.add(curActiveLbl);
        activeCreaturePanel.add(activeCreatureLbl);
        activeCreaturePanel.add(activeCreatureImgLbl);
        this.creatureListPanel.add(activeCreaturePanel);

        
        for (int i = 1; i < creatureList.size();i++){
            JButton switchBtn = new JButton("Set Active Creature");
            switchBtn.putClientProperty("index", i);
            switchBtn.addActionListener(this.switchAction);
            JPanel creaturePanel = new JPanel(new GridLayout(1,3));
            JLabel creatureLbl = new JLabel();
            Creature curCreature = creatureList.get(i);            
            JLabel creatureImgLbl = new JLabel();

            creatureImgLbl.setIcon(this.createImageIcon(curCreature.getImagePath(),"test"));
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

    
    public void assignOpenInvEvent (ActionListener action){
        
        this.inventoryBtn.addActionListener(action);
        
    }

    /** 
     * Returns an ImageIcon, or null if the path was invalid. */
    protected ImageIcon createImageIcon(String path,
        String description) {
        URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            ImageIcon imageIcon = new ImageIcon(path); // load the image to a imageIcon
            Image image = imageIcon.getImage(); // transform it 
            Image newimg = image.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
            imageIcon = new ImageIcon(newimg);  // transform it back
            return imageIcon;
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    public void assignOpenEvoEvent(ActionListener action) {

        this.evolveBtn.addActionListener(action);

    }
    
    public void reloadEvolution(ArrayList<Creature> creatureList){
        
        this.evolutionPanel1.removeAll();
        this.generateCreatureEvolutionList1(creatureList);
        this.evolutionPanel2.removeAll();
        this.generateCreatureEvolutionList2(creatureList);
        this.evolutionFrame.revalidate();

    }

}
    