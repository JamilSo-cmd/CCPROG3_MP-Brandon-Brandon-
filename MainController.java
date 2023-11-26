import java.util.ArrayList;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

public class MainController {

    private Player user;
    private MainView mainView;


    public MainController(){

        this.user = new Player(new Inventory());

        this.mainView = new MainView();

        this.mainView.createStarterButton("Strawander", pickStarterEvent("Strawander", "Fire", "A", 1,"./resources/Strawander.jpg"));
        this.mainView.createStarterButton("Brownisaur", pickStarterEvent("Brownisaur", "Grass", "D",1,"./resources/Brownisaur.png"));
        this.mainView.createStarterButton("Squirpie", pickStarterEvent("Squirpie", "Water", "G", 1,"./resources/Squirpie.jpg"));

        user.addToInventory(new Creature("Squirpie", "Water", "G", 1,"./resources/Squirpie.jpg"));
        user.addToInventory(new Creature("Strawander", "Fire", "A", 1,"./resources/Strawander.jpg"));

        this.mainView.assignOpenInvEvent(openInvEvent());
    }

    private ActionListener pickStarterEvent(String name, String type, String family,int evolutionLv,String imagePath){
        Player user1 = this.user;

        ActionListener action = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                user1.addToInventory(new Creature(name,type,family,evolutionLv,imagePath));
                user1.setActiveCreature(0); 
                user1.viewInventory();
            }
        };

        return action;
    }

    private ActionListener openInvEvent () {
        MainView curMainView = this.mainView;
        Player user1 = this.user;

        ActionListener action = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                curMainView.generateCreatureList(user1.getPlayerInv().getRoster());
            }
        };

        return action;
    }

}
