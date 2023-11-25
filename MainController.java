import java.util.ArrayList;
import java.awt.event.*;
import javax.swing.*;

public class MainController {

    private Player user;
    private MainView mainView;

    public MainController(){

        this.user = new Player(new Inventory());

        this.mainView = new MainView();

          

        this.mainView.createButton("Strawander", pickStarterEvent("Strawander", "Fire", "A", 1));
        this.mainView.createButton("Brownisaur", pickStarterEvent("Brownisaur", "Grass", "D", 1));
        this.mainView.createButton("Squirpie", pickStarterEvent("Squirpie", "Water", "G", 1));

    }

    private ActionListener pickStarterEvent(String name, String type, String family,int evolutionLv){
        Player user1 = this.user;

        ActionListener action = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                user1.addToInventory(new Creature(name,type,family,evolutionLv));
                user1.setActiveCreature(0); 
                user1.viewInventory();
            }
        };

        return action;
    }

}
