import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.*;

public class MainView {

    private JFrame startFrame;
    private JFrame menuFrame;
    private JFrame inventoryFrame;
    private JLabel greetingsLbl;
    private JLabel alignmentLbl;
    private JPanel creaturePanel;
    private JPanel starterPanel;
    private JButton inventoryBtn;

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
        this.inventoryFrame.setSize(450, 200);
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

    public void initializeInventory (){
        JLabel text = new JLabel();
        JPanel mainPanel = new JPanel(new GridLayout(2,1));
        creaturePanel = new JPanel(new GridLayout(0,1));
        JPanel options = new JPanel(new GridLayout(1,2));

        // TODO: switch panel functionality
        
        


        //add options
        JButton returnBtn = new JButton("Exit Inventory");
        returnBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inventoryFrame.dispose();
                menuFrame.setVisible(true);
            }
        });

        JButton switchBtn = new JButton("Switch Active Creature");
        switchBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inventoryFrame.dispose();
            }
        });

        options.add(returnBtn);
        options.add(switchBtn);
        mainPanel.add(options);
        mainPanel.add(creaturePanel);

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
        
        System.out.println("Before");
        this.starterPanel.add(btn);
        System.out.println("After");
    }

    public void generateCreatureList (ArrayList<Creature> creatureList){
        
        for (int i = 0; i < creatureList.size();i++){
            JLabel creatureLbl = new JLabel(); 
            Creature curCreature = creatureList.get(i);

            creatureLbl.setText("<html><body>Name: " + curCreature.getName() 
                                + "<br>Type: " + curCreature.getType()
                                + "<br>Family: " + curCreature.getFamily()
                                + "<br>Evolution Lv: " + curCreature.getEvolutionLv()
                                + "<hr></html></body>");

            this.creaturePanel.add(creatureLbl);
        }

    }

    public void assignOpenInvEvent (ActionListener action){
        
        this.inventoryBtn.addActionListener(action);
        
        
    }
    
}
    