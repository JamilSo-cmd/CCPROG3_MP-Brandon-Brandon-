import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.imageio.ImageIO;
import javax.swing.SwingConstants;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

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
    private JLabel greetingsLbl;
    private JLabel alignmentLbl;
    private JPanel creatureListPanel;
    private JPanel starterPanel;
    private JButton inventoryBtn;
    private ActionListener switchAction;

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
        JButton evolveBtn = new JButton("Evolve a Creature");
        evolveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuFrame.setVisible(false);
                //set window for evolution to visible
            }
        });

        JButton exitBtn = new JButton("Exit Program");
        exitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuFrame.dispose();
            }
        });

        this.alignmentLbl = new JLabel(" ");

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

        this.alignmentLbl = new JLabel(" ");

        

        this.inventoryFrame.add(text);
        this.inventoryFrame.add(mainPanel);
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

    /** Returns an ImageIcon, or null if the path was invalid. */
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
    

}
    