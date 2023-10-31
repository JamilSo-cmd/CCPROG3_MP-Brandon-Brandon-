import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.FlowLayout;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainView {

    private JFrame startFrame;
    private JFrame menuFrame;
    private JLabel greetingsLbl;
    private JLabel alignmentLbl;
    private Player user;

    public MainView(Player user) {
        this.user = user;
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
    }

    private void starterPick (){
        JLabel greetingsPromptLbl = new JLabel();
        greetingsPromptLbl.setText("Pick a Starter");

        greetingsPromptLbl.setHorizontalAlignment(JLabel.CENTER);


        this.greetingsLbl = new JLabel(" ");

        this.startFrame.add(greetingsPromptLbl);
        this.startFrame.add(greetingsLbl);

        JPanel panel = new JPanel(new BorderLayout());
        
        JButton btn1 = new JButton("Fire");
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                user.addToInventory(new Creature("Strawander", "Fire", "A", 1));
                user.setActiveCreature(0);  
                startFrame.dispose();
                menuFrame.setVisible(true);      
            }
        });
        JButton btn2 = new JButton("Water");
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                user.addToInventory(new Creature("Brownisaur", "Grass", "D", 1));
                user.setActiveCreature(0);
                startFrame.dispose();  
                menuFrame.setVisible(true);          
            }
        });
        JButton btn3 = new JButton("Grass");
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                user.addToInventory(new Creature("Squirpie", "Water", "G", 1));
                user.setActiveCreature(0);
                startFrame.dispose();     
                menuFrame.setVisible(true);            
            }
        });

        this.alignmentLbl = new JLabel(" ");

        panel.add(btn1, BorderLayout.WEST);
        panel.add(btn2, BorderLayout.CENTER);
        panel.add(btn3, BorderLayout.EAST);

        this.startFrame.add(panel);
    }

    private void initializeMenu () {
        JLabel text = new JLabel();
        JPanel panel = new JPanel(new BorderLayout());

        text.setText("<html><h1>MENU SCREEN</h1></html>");

        JButton btn1 = new JButton("View Inventory");
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        JButton btn2 = new JButton("Explore an Area");
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        JButton btn3 = new JButton("Evolve a Creature");
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

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

        this.menuFrame.add(text);
        this.menuFrame.add(panel);
    }
}