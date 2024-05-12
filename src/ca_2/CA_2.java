/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ca_2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Leonardo
 */
public class CA_2 {           
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Manager mng = new Manager();
                
        System.out.println("Please, provide a file to start.");

        String myFile = Utilities.stringInput("Please insert the name of the file:");
        List<String> names = new ArrayList<>();
        Utilities.ReadAndGetNames(myFile,names);
        
        MainMenu.MenuOption selectOption = null;
        
        do{
            System.out.println("Please select an option: ");
            System.out.println("1. Sort");
            System.out.println("2. Search");
            System.out.println("3. Add");
            System.out.println("4. Exit");
           
            int option = Utilities.numberInput("Please select an option");
            
            selectOption = MainMenu.MenuOption.values()[option - 1];
            
            switch(selectOption){
                
                case SORT:
                    Utilities.Sorting(names);
                    Utilities.printFirstFifty(names);
                    break;
                    
                case SEARCH:
                    String name = Utilities.stringInput("Which name are you looking for? ");                    
                    Utilities.Searching(names, name);
                    break;
                    
                case ADD:
                    System.out.println("Would you like to customize or generate random information? ");
                    System.out.println("1. Customize");
                    System.out.println("2. Generate Random");
                    option = Utilities.numberInput("Please select an option");
                    int selectedOption = option;
                    switch (selectedOption){
                        case 1:
                            System.out.println("Customize:");
                            String customName = Utilities.stringInput("Enter the full name: ");                            
                            
                            option = Utilities.numberInput("Please select an option: \n1.Player \n2.Coach ");
                            selectedOption = option;
                            switch (selectedOption){
                                case 1:
                                    Player.printPlayerPositions();
                                    int position = Utilities.numberInput("Please select the position of this player:");
                                    mng.listAllTeams();
                                    int team = Utilities.numberInput("Please select the team of this player:");
                                    
                                    
                                    break;
                                    
                            }
                            
                            
                            break;
                        
                        
                        case 2:
                            System.out.println("Random");
                            break;
                        
                        default:
                            System.out.println("Invalid option! Please try again.");
                            break;
                    }
                    break;
                case EXIT:
                    System.out.println("Exiting the application. \nSee you next time.");
                    break;
                    
                default:
                    System.out.println("Invalid option! Please try again.");
                    break;
            }

        }   
        
        while(selectOption != MainMenu.MenuOption.EXIT);
        
    }
        
}
        


