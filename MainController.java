
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
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

public class MainController {

    private Player user;
    private MainView mainView;
<<<<<<< Updated upstream
=======
    private Creature creatureSelect1;
    private Creature creatureSelect2;
    private int index1;
    private int index2;
    private String evolutionResult = "select two creatures";
>>>>>>> Stashed changes


    public MainController(){

        this.user = new Player(new Inventory());

        this.mainView = new MainView();

<<<<<<< Updated upstream
        this.mainView.createStarterButton("Strawander", pickStarterEvent("Strawander", "Fire", "A", 1,"./resources/Strawander.jpg"));
        this.mainView.createStarterButton("Brownisaur", pickStarterEvent("Brownisaur", "Grass", "D",1,"./resources/Brownisaur.png"));
        this.mainView.createStarterButton("Squirpie", pickStarterEvent("Squirpie", "Water", "G", 1,"./resources/Squirpie.jpg"));
        
        this.mainView.assignOpenInvEvent(openInvEvent());
        
        this.mainView.setSwitchActionEvent(switchCreatureEvent());

        this.mainView.assignOpenEvoEvent(openEvoEvent());
=======
<<<<<<< Updated upstream
          

        this.mainView.createButton("Strawander", pickStarterEvent("Strawander", "Fire", "A", 1));
        this.mainView.createButton("Brownisaur", pickStarterEvent("Brownisaur", "Grass", "D", 1));
        this.mainView.createButton("Squirpie", pickStarterEvent("Squirpie", "Water", "G", 1));

=======
        this.mainView.createStarterButton("Strawander", pickStarterEvent("Strawander", "Fire", 'A', 1,"./resources/Strawander.jpg"));
        this.mainView.createStarterButton("Brownisaur", pickStarterEvent("Brownisaur", "Grass", 'D',1,"./resources/Brownisaur.png"));
        this.mainView.createStarterButton("Squirpie", pickStarterEvent("Squirpie", "Water", 'G', 1,"./resources/Squirpie.jpg"));
        
        this.mainView.assignOpenInvEvent(openInvEvent());
        
        this.mainView.setSwitchActionEvent(switchCreatureEvent());

        this.mainView.assignOpenEvoEvent(openEvoEvent());
        
        this.mainView.setSelectActionEvent1(selectCreatureEvent1());

        this.mainView.setSelectActionEvent2(selectCreatureEvent2());

        this.mainView.setEvolutionActionEvent(evolutionEvent());
>>>>>>> Stashed changes
>>>>>>> Stashed changes
    }

    private ActionListener openEvoEvent() {
        MainView curMainView = this.mainView;
        Player user1 = this.user;

        ActionListener action = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
<<<<<<< Updated upstream
                curMainView.reloadEvolution(user1.getPlayerInv().getRoster());
            }};
        return action;
    }

    private ActionListener pickStarterEvent(String name, String type, String family,int evolutionLv,String imagePath){
        Player user1 = this.user;

        ActionListener action = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                user1.addToInventory(new EL1(name,type,family,evolutionLv,imagePath));
                user1.setActiveCreature(0); 

                //TODO: Remove after testing
                user1.addToInventory(new EL1("Squirpie", "Water", "G", 1,"./resources/Squirpie.jpg"));
                user1.addToInventory(new EL1("Strawander", "Fire", "A", 1,"./resources/Strawander.jpg"));
=======
<<<<<<< Updated upstream
                user1.addToInventory(new Creature(name,type,family,evolutionLv));
                user1.setActiveCreature(0); 
                user1.viewInventory();
=======
                curMainView.reloadEvolution(user1.getPlayerInv().getRoster(),creatureSelect1,creatureSelect2,evolutionResult);
            }};
        return action;
    }

    private ActionListener pickStarterEvent(String name, String type, char family,int evolutionLv,String imagePath){
        Player user1 = this.user;

        ActionListener action = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                user1.addToInventory(new EL1(name,type,family,evolutionLv,imagePath));
                user1.setActiveCreature(0); 

                //TODO: Remove after testing
                user1.addToInventory(new EL1("Squirpie", "Water", 'G', 1,"./resources/Squirpie.jpg"));
                user1.addToInventory(new EL1("Strawander", "Fire", 'A', 1,"./resources/Strawander.jpg"));
>>>>>>> Stashed changes
>>>>>>> Stashed changes
            }
        };

        return action;
    }

<<<<<<< Updated upstream
=======
<<<<<<< Updated upstream
=======
>>>>>>> Stashed changes
    private ActionListener openInvEvent () {
        MainView curMainView = this.mainView;
        Player user1 = this.user;

        ActionListener action = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                curMainView.reloadInventory(user1.getPlayerInv().getRoster());
            }
        };

        return action;
    }

    private ActionListener switchCreatureEvent (){
        Player user1 = this.user;
        MainView curMainView = this.mainView;

        ActionListener action = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                user1.setActiveCreature((Integer)((JButton)e.getSource()).getClientProperty( "index" ));
                curMainView.reloadInventory(user1.getPlayerInv().getRoster());
            }
        };
        return action;
    }
<<<<<<< Updated upstream


=======
    
    private ActionListener selectCreatureEvent1(){
        Player user1 = this.user;
        MainView curMainView = this.mainView;

        ActionListener action = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                index1 = (Integer)((JButton)e.getSource()).getClientProperty( "index" );
                setCreatureSelect1(user1.getPlayerInv().getRoster().get((Integer)((JButton)e.getSource()).getClientProperty( "index" )));
                curMainView.reloadEvolution(user1.getPlayerInv().getRoster(),creatureSelect1,creatureSelect2,evolutionResult);
                System.out.println(creatureSelect1.getName());
            }
        };
        return action;
    }

     private ActionListener selectCreatureEvent2(){
        Player user1 = this.user;
        MainView curMainView = this.mainView;

        ActionListener action = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                index2 = (Integer)((JButton)e.getSource()).getClientProperty( "index" );
                setCreatureSelect2(user1.getPlayerInv().getRoster().get((Integer)((JButton)e.getSource()).getClientProperty( "index" )));
                curMainView.reloadEvolution(user1.getPlayerInv().getRoster(),creatureSelect1,creatureSelect2,evolutionResult);
                System.out.println(creatureSelect2.getName());
                
            }
        };
        return action;
    }

    private ActionListener evolutionEvent(){
        Player user1 = this.user;
        MainView curMainView = this.mainView;
        
        ActionListener action = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                // evolveCreature();
                System.out.println("CHECK");

                curMainView.reloadEvolution(user1.getPlayerInv().getRoster(),creatureSelect1,creatureSelect2, evolutionResult);
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

    // public void evolveCreature (){
    //      Player user1 = this.user;

    //     if (index1 == index2){
    //             evolutionResult = "You cannot Evolve a creature with itself";
    //     }
    //     else{

    //         if (creatureSelect1.getFamily() != creatureSelect1.getFamily()){
    //             // evolutionResult = "Evolution Failure";
    //         }
    //         else {

    //             if(creatureSelect1.getEvolutionLv() >= 3 || creatureSelect2.getEvolutionLv() >= 3 || creatureSelect1.getEvolutionLv() != creatureSelect2.getEvolutionLv()){
    //                 // evolutionResult = "Evolution Failure";
    //             }
    //             else{
    //                 switch (creatureSelect1.getFamily()){

    //                     case 'A':{
                        
    //                         if (creatureSelect1.getEvolutionLv() == 1){

    //                             user1.getPlayerInv().getRoster().add(new Creature("Strawleon","Fire" ,'A' ,2 ,".resources/Straweleon.png" ));

    //                         }
                            
    //                         else if (creatureSelect1.getEvolutionLv() == 2){

    //                             user1.getPlayerInv().getRoster().add(new Creature("Stawizard","Fire" ,'A' ,3 ,".resources/Stawizard.png" ));

    //                         }
                            
    //                     };
    //                     break;
    //                     case 'D':{
                        
    //                         if (creatureSelect1.getEvolutionLv() == 1){

    //                             user1.getPlayerInv().getRoster().add(new Creature("Chocosaur","Grass" ,'D' ,2 ,".resources/Chocosaur.png" ));

    //                         }
                            
    //                         else if (creatureSelect1.getEvolutionLv() == 2){

    //                             user1.getPlayerInv().getRoster().add(new Creature("Fudgasaur","Grass" ,'D' ,3 ,".resources/Fudgasaur.png" ));

    //                         }
                            
    //                     };
    //                     break;
    //                     case 'G':{
                        
    //                         if (creatureSelect1.getEvolutionLv() == 1){

    //                             user1.getPlayerInv().getRoster().add(new Creature("Tartortle","Water" ,'G' ,2 ,".resources/Tartortle.png" ));

    //                         }
                            
    //                         else if (creatureSelect1.getEvolutionLv() == 2){

    //                             user1.getPlayerInv().getRoster().add(new Creature("Piestoise","Water" ,'G' ,3 ,".resources/Piestoise.png" ));

    //                         }
                            
    //                     };
    //                     break;
    //                     case 'H':{
                        
    //                         if (creatureSelect1.getEvolutionLv() == 1){

    //                             user1.getPlayerInv().getRoster().add(new Creature("Chocolish","Water" ,'H' ,2 ,".resources/Chocolish.png" ));

    //                         }
                            
    //                         else if (creatureSelect1.getEvolutionLv() == 2){

    //                             user1.getPlayerInv().getRoster().add(new Creature("Icesundae","Water" ,'H' ,3 ,".resources/Icesundae.png" ));

    //                         }
                            
    //                     };
    //                     case 'I':{
                        
    //                         if (creatureSelect1.getEvolutionLv() == 1){

    //                             user1.getPlayerInv().getRoster().add(new Creature("Dewice","Water" ,'I' ,2 ,".resources/Dewice.png" ));

    //                         }
                            
    //                         else if (creatureSelect1.getEvolutionLv() == 2){

    //                             user1.getPlayerInv().getRoster().add(new Creature("Samurcone","Water" ,'I' ,3 ,".resources/Samurcone.png" ));

    //                         }
                            
    //                     };
    //                     break;

    //                     case 'F':{
                        
    //                         if (creatureSelect1.getEvolutionLv() == 1){

    //                             user1.getPlayerInv().getRoster().add(new Creature("Kirlicake","Grass" ,'F' ,2 ,".resources/Kirlicake.png" ));

    //                         }
                            
    //                         else if (creatureSelect1.getEvolutionLv() == 2){

    //                             user1.getPlayerInv().getRoster().add(new Creature("Velvevoir","Grass" ,'F' ,3 ,".resources/Velvevoir.png" ));

    //                         }
                            
    //                     };
    //                     break;

    //                     case 'E':{
                        
    //                         if (creatureSelect1.getEvolutionLv() == 1){

    //                             user1.getPlayerInv().getRoster().add(new Creature("Golberry","Grass" ,'E' ,2 ,".resources/Golberry.png" ));

    //                         }
                            
    //                         else if (creatureSelect1.getEvolutionLv() == 2){

    //                             user1.getPlayerInv().getRoster().add(new Creature("Croberry","Grass" ,'E' ,3 ,".resources/Croberry.png" ));

    //                         }
                            
    //                     };
    //                     break;

    //                     case 'B':{
                        
    //                         if (creatureSelect1.getEvolutionLv() == 1){

    //                             user1.getPlayerInv().getRoster().add(new Creature("Chocofluff","Fire" ,'B' ,2 ,".resources/Chocofluff.png" ));

    //                         }
                            
    //                         else if (creatureSelect1.getEvolutionLv() == 2){

    //                             user1.getPlayerInv().getRoster().add(new Creature("Candaros","Fire" ,'B' ,3 ,".resources/Candaros.png" ));

    //                         }
                            
    //                     };
    //                     break;

    //                     case 'C':{
                        
    //                         if (creatureSelect1.getEvolutionLv() == 1){

    //                             user1.getPlayerInv().getRoster().add(new Creature("Parfure","Fire" ,'C' ,2 ,".resources/Parfure.jpg" ));

    //                         }
                            
    //                         else if (creatureSelect1.getEvolutionLv() == 2){

    //                             user1.getPlayerInv().getRoster().add(new Creature("Parfelure","Fire" ,'C' ,3 ,".resources/Parfelure.jpg" ));

    //                         }
                            
    //                     };
    //                     break;
    //                 }

    //                 user1.getPlayerInv().getRoster().remove(index1);
    //                 user1.getPlayerInv().getRoster().remove(index2);
    //                 evolutionResult = "Evolution Success";
    //             }
    //         }
    //     }

    // }
>>>>>>> Stashed changes
>>>>>>> Stashed changes
}
