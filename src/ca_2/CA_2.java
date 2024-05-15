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
        System.out.println("Hello! \nWelcome to the clubs manager. Here you can manage all the rugby teams staff.");   
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println("Please, provide a file to start.");

        String myFile = Utilities.stringInput("Please insert the name of the file:");
        List<String> names = new ArrayList<>();
        Utilities.ReadAndGetNames(myFile,names);
        
        MainMenu.MenuOption selectOption = null;
        
        do{
            System.out.println("----------------------------------------------------------------------------------------");
            System.out.println("Please select an option: \n1. Sort \n2. Search \n3. Add \n4. Exit");
           
            int option = Utilities.numberInput("Please select an option");
            
            selectOption = MainMenu.MenuOption.values()[option - 1];
            
            switch(selectOption){
                
                case SORT:
                    option = Utilities.numberInput("Please select an option to be displayed: \n1.Teams \n2.Coaches \n3.Players \n4.Names Dataset \n5.Exit");
                    int selectedOption = option;
                    switch(selectedOption){
                        case 1:
                             Utilities.printSortedList(mng.listAllTeamsNames());
                             System.out.println("----------------------------------------------------------------------------------------");
                        break;
                        
                        case 2:
                            Utilities.printSortedList(mng.listAllCoachesNames());
                            System.out.println("----------------------------------------------------------------------------------------");
                        break;
                        
                        case 3:
                            Utilities.printSortedList(mng.listAllPlayersNames());
                            System.out.println("----------------------------------------------------------------------------------------");
                        break;
                        
                        case 4:
                            Utilities.Sorting(names);
                            Utilities.printFirstFifty(names);
                            System.out.println("----------------------------------------------------------------------------------------");
                        break;
                        
                        case 5:
                            System.out.println("Ok!");
                            System.out.println("----------------------------------------------------------------------------------------");
                        break;
                            
                        default:
                            System.out.println("Invalid option! Please try again.");
                            System.out.println("----------------------------------------------------------------------------------------");
                        break;
                    }
                    break;
                    
                case SEARCH:
                    String name = Utilities.stringInput("Which name are you looking for? ");                    
                    Utilities.Sorting(names);
                    Utilities.Searching(names, name);
                    System.out.println("Would you like to add this person as a club staff? ");
                    option = Utilities.numberInput("Please select an option: \n1.Yes, as a Player \n2.Yes, as a Coach \n3.No, thanks");
                    selectedOption = option;
                    switch (selectedOption){
                        case 1:
                            Player.printPlayerPositions();
                            int position = Utilities.numberInput("Please select the position of this player:");
                            String playerPosition = Player.getOnePosition(position);
                            mng.listAllTeams();
                            int teamIndex = Utilities.numberInput("Please select the team of this player:");
                            String playerTeam = mng.getOneTeam(teamIndex);
                            Player newPlayer = new Player(name,playerTeam,playerPosition);
                            System.out.println(newPlayer.getName() + " was added as a " + newPlayer.getPosition() + " in the " + newPlayer.getTeam() + " club, succesfully!");
                            mng.addPlayer(newPlayer);
                        break;
                        
                        case 2:
                            Coach.printCoachesTypes();
                            int type = Utilities.numberInput("Please select the type of this coach:");
                            String coachType = Coach.getOneType(type);
                            mng.listAllTeams();
                            teamIndex = Utilities.numberInput("Please select the team of this player:");
                            String coachTeam = mng.getOneTeam(teamIndex);
                            Coach newCoach = new Coach(name,coachTeam,coachType);
                            System.out.println(newCoach.getName() + " was added as a " + newCoach.getType() + " in the " + newCoach.getTeam() + " club, succesfully!");
                            mng.addCoach(newCoach);
                        break;
                        
                        case 3:
                            System.out.println("Ok!");
                        break;
                        
                        default:
                            System.out.println("Invalid option! Please try again.");
                        break;
                    }     
                    break;
                    
                case ADD:
                    System.out.println("Would you like to customize or generate random information? \n1. Customize \n2. Generate Random");
                    option = Utilities.numberInput("Please select an option");
                    selectedOption = option;
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
                                    String playerPosition = Player.getOnePosition(position);
                                    System.out.println(playerPosition);
                                    mng.listAllTeams();
                                    int teamIndex = Utilities.numberInput("Please select the team of this player:");
                                    String playerTeam = mng.getOneTeam(teamIndex);
                                    Player newPlayer = new Player(customName,playerTeam,playerPosition);
                                    System.out.println(newPlayer.getName() + " was added as a " + newPlayer.getPosition() + " in the " + newPlayer.getTeam() + " club, succesfully!");
                                    mng.addPlayer(newPlayer);
                                    break;
                                case 2:
                                    Coach.printCoachesTypes();
                                    int type = Utilities.numberInput("Please select the type of this coach:");
                                    String coachType = Coach.getOneType(type);
                                    mng.listAllTeams();
                                    teamIndex = Utilities.numberInput("Please select the team of this player:");
                                    String coachTeam = mng.getOneTeam(teamIndex);
                                    Coach newCoach = new Coach(customName,coachTeam,coachType);
                                    System.out.println(newCoach.getName() + " was added as a " + newCoach.getType() + " in the " + newCoach.getTeam() + " club, succesfully!");
                                    mng.addCoach(newCoach);
                                    break;
                                case 3:
                                    System.out.println("Ok!");
                                break;
                            default:
                                System.out.println("Invalid option! Please try again.");
                                break;
                            }
                            break;

                        
                        case 2:
                            System.out.println("Random");
                            option = Utilities.numberInput("Please select an option: \n1.Player \n2.Coach ");
                            selectedOption = option;
                            if(option == 1){
                                Utilities.generateRandomPlayer(names,mng.getTeams(),Player.getPositions());
                            }else if(option == 2){
                                Utilities.generateRandomCoach(names, mng.getTeams(),Coach.getTypes());
                            }

                            break;
                        case 3:
                            System.out.println("Ok!");
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
        


