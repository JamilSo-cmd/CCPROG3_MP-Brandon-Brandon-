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

public class MainView {

    private JFrame startFrame;
    private JFrame menuFrame;
    private JFrame inventoryFrame;
    private JLabel greetingsLbl;
    private JLabel alignmentLbl;
    private JPanel starterPanel;

    public MainView() {

        this.startFrame = new JFrame("Choose your starter!");
        this.startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      
        this.startFrame.setLayout(new FlowLayout());
        this.startFrame.setSize(200, 200);

        starterPick();
        
        this.startFrame.setVisible(true);

        this.menuFrame = new JFrame("Menu Options");
        this.menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      
        this.menuFrame.setLayout(new FlowLayout());
        this.menuFrame.setSize(450, 200);

        initializeMenu();

        this.menuFrame.setVisible(false);

        this.inventoryFrame = new JFrame("Inventory");
        this.inventoryFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      
        this.inventoryFrame.setLayout(new FlowLayout());
        this.inventoryFrame.setSize(450, 200);

        initializeInventory();

        this.inventoryFrame.setVisible(false);
        
    }

    private void starterPick (){
        JLabel greetingsPromptLbl = new JLabel();
        greetingsPromptLbl.setText("Pick a Starter");

        greetingsPromptLbl.setHorizontalAlignment(JLabel.CENTER);


        this.greetingsLbl = new JLabel(" ");

        this.startFrame.add(greetingsPromptLbl);
        this.startFrame.add(greetingsLbl);

        this.starterPanel = new JPanel(new GridLayout(1,3));
        
        // JButton btn1 = new JButton("Strawander");
        // btn1.addActionListener(new ActionListener() {
        //     @Override
        //     public void actionPerformed(ActionEvent e) {
        //         // user.addToInventory(new Creature("Strawander", "Fire", "A", 1));
        //         // user.setActiveCreature(0);  
        //         System.out.println("check");
        //         startFrame.dispose();
        //         menuFrame.setVisible(true);      
        //     }
        // });
        // JButton btn2 = new JButton("Squirpie");
        // btn2.addActionListener(new ActionListener() {
        //     @Override
        //     public void actionPerformed(ActionEvent e) {
        //         // user.addToInventory(new Creature("Brownisaur", "Grass", "D", 1));
        //         // user.setActiveCreature(0);
        //         startFrame.dispose();  
        //         menuFrame.setVisible(true);          
        //     }
        // });
        // JButton btn3 = new JButton("Brownisaur");
        // btn3.addActionListener(new ActionListener() {
        //     @Override
        //     public void actionPerformed(ActionEvent e) {
        //         // user.addToInventory(new Creature("Squirpie", "Water", "G", 1));
        //         // user.setActiveCreature(0);
        //         startFrame.dispose();     
        //         menuFrame.setVisible(true);            
        //     }
        // });

        // this.alignmentLbl = new JLabel(" ");

        // panel.add(btn1, BorderLayout.WEST);
        // panel.add(btn2, BorderLayout.CENTER);
        // panel.add(btn3, BorderLayout.EAST);

        this.startFrame.add(this.starterPanel);
    }

    private void initializeMenu () {
        JLabel menu = new JLabel();
        JPanel panel = new JPanel(new BorderLayout());

        menu.setText("<html><h1>MENU SCREEN</h1></html>");

        JButton btn1 = new JButton("View Inventory");
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuFrame.setVisible(false);
                //set window for inventory to visible
                inventoryFrame.setVisible(true); 
            }
        });
        JButton btn2 = new JButton("Explore an Area");
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuFrame.setVisible(false);  
                //set window for area to visible
            }
        });
        JButton btn3 = new JButton("Evolve a Creature");
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuFrame.setVisible(false);
                //set window for evolution to visible
            }
        });

        JButton btn4 = new JButton("Exit Program");
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuFrame.dispose();
            }
        });

        this.alignmentLbl = new JLabel(" ");

        panel.add(btn1, BorderLayout.EAST);
        panel.add(btn2, BorderLayout.CENTER);
        panel.add(btn3, BorderLayout.WEST);
        panel.add(btn4, BorderLayout.SOUTH);

        this.menuFrame.add(menu);
        this.menuFrame.add(panel);
    }

    public void initializeInventory (){
        JLabel text = new JLabel();
        JPanel panel = new JPanel(new BorderLayout());

        JButton btn4 = new JButton("Exit Program");
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuFrame.dispose();
            }
        });

        panel.add(btn4, BorderLayout.SOUTH);

        this.alignmentLbl = new JLabel(" ");

        

        this.inventoryFrame.add(text);
        this.inventoryFrame.add(panel);
    }

    public void createButton (String desc, ActionListener action){
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
    }
}
    