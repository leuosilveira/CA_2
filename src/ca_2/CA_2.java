/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ca_2;

import java.util.ArrayList;
import java.util.List;

/**
 * Main class for managing rugby teams and their staff.
 */
public class CA_2 {           

    /**
     * Main method.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Create a Manager object
        Manager mng = new Manager();
        
        // Print welcome message and ask for a file name
        System.out.println("Hello! \nWelcome to the clubs manager. Here you can manage all the rugby teams staff.");   
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println("Please, provide a file to start.");
        String myFile = Utilities.stringInput("Please insert the name of the file:");
        System.out.println("----------------------------------------------------------------------------------------");
        
        // Create a list to store the names that we get from the club_form file
        List<String> names = new ArrayList<>();
        
        // Read names from the file
        Utilities.ReadAndGetNames(myFile, names);
        
        // Initialize variable for menu option
        MainMenu.MenuOption selectOption = null;
        
        // Main menu loop
        do{
            // Display main menu options
            System.out.println("Please select an option: \n1. Sort \n2. Search \n3. Add \n4. Exit");
           
            // Get user's choice
            int option = Utilities.numberInput("Please select an option", 1, 4);
            
            // Convert user's choice to MenuOption enum
            selectOption = MainMenu.MenuOption.values()[option - 1];
            
            // Switch based on user's choice
            switch(selectOption){
                
                case SORT:
                    // Sort menu with 4 choices and a exit
                    option = Utilities.numberInput("Please select an option to be displayed: \n1.Teams \n2.Coaches \n3.Players \n4.Names Dataset \n5.Exit", 1, 5);
                    int selectedOption = option;
                    switch(selectedOption){
                        case 1:
                             // Sort and print teams
                             Utilities.printSortedList(mng.listAllTeamsNames());
                             System.out.println("----------------------------------------------------------------------------------------");
                        break;
                        
                        case 2:
                            // Sort and print coaches
                            Utilities.printSortedList(mng.listAllCoachesNames());
                            System.out.println("----------------------------------------------------------------------------------------");
                        break;
                        
                        case 3:
                            // Sort and print players
                            Utilities.printSortedList(mng.listAllPlayersNames());
                            System.out.println("----------------------------------------------------------------------------------------");
                        break;
                        
                        case 4:
                            // Sort and print names from the dataset club_form
                            Utilities.Sorting(names);
                            Utilities.printFirstFifty(names);
                            System.out.println("----------------------------------------------------------------------------------------");
                        break;
                        
                        case 5:
                            // Exit sort menu
                            System.out.println("Ok!");
                            System.out.println("----------------------------------------------------------------------------------------");
                        break;
                            
                        default:
                            // Invalid option
                            System.out.println("Invalid option! Please try again.");
                            System.out.println("----------------------------------------------------------------------------------------");
                        break;
                    }
                    break;
                    
                case SEARCH:
                    // Search menu
                    String name = Utilities.stringInput("Which name are you looking for? ");                    
                    Utilities.Searching(names, name);
                    // Even if the program find the name or not you can add this name as a player or coach
                    System.out.println("----------------------------------------------------------------------------------------");
                    System.out.println("Would you like to add this person as a club staff? ");
                    option = Utilities.numberInput("Please select an option: \n1.Yes, as a Player \n2.Yes, as a Coach \n3.No, thanks", 0, 3);
                    selectedOption = option;
                    switch (selectedOption){
                        case 1:
                            // Adding as player with 2 attributes (position and team)
                            Player.printPlayerPositions();
                            int position = Utilities.numberInput("Please select the position of this player:", 0, 9);
                            String playerPosition = Player.getOnePosition(position);
                            mng.listAllTeams();
                            int teamIndex = Utilities.numberInput("Please select the team of this player:", 0, 9);
                            String playerTeam = mng.getOneTeam(teamIndex);
                            Player newPlayer = new Player(name,playerTeam,playerPosition);
                            System.out.println(newPlayer.getName() + " was added as a " + newPlayer.getPosition() + " in the " + newPlayer.getTeam() + " club, succesfully!");
                            mng.addPlayer(newPlayer);
                            System.out.println("----------------------------------------------------------------------------------------");
                        break;
                        
                        case 2:
                            // Adding as coach with two attributes (type and team)
                            Coach.printCoachesTypes();
                            int type = Utilities.numberInput("Please select the type of this coach:", 0, 8);
                            String coachType = Coach.getOneType(type);
                            mng.listAllTeams();
                            teamIndex = Utilities.numberInput("Please select the team of this player:", 0, 9);
                            String coachTeam = mng.getOneTeam(teamIndex);
                            Coach newCoach = new Coach(name,coachTeam,coachType);
                            System.out.println(newCoach.getName() + " was added as a " + newCoach.getType() + " in the " + newCoach.getTeam() + " club, succesfully!");
                            mng.addCoach(newCoach);
                            System.out.println("----------------------------------------------------------------------------------------");
                        break;
                        
                        case 3:
                            // Exit option
                            System.out.println("Ok!");
                            System.out.println("----------------------------------------------------------------------------------------");
                        break;
                        
                        default:
                            // Invalid option
                            System.out.println("Invalid option! Please try again.");
                            System.out.println("----------------------------------------------------------------------------------------");
                        break;
                    }     
                    break;
                    
                case ADD:
                    // Add menu
                    System.out.println("Would you like to customize or generate random information? \n1. Customize \n2. Generate Random \n3. Exit" );
                    option = Utilities.numberInput("Please select an option", 1, 3);
                    System.out.println("----------------------------------------------------------------------------------------");
                    selectedOption = option;
                    switch (selectedOption){
                        case 1:
                            // Customize option
                            System.out.println("Customize:");
                            String customName = Utilities.stringInput("Enter the full name: ");                            
                            // option to add an player or coach
                            option = Utilities.numberInput("Please select an option: \n1.Player \n2.Coach ", 1, 2);
                            selectedOption = option;
                            switch (selectedOption){
                                case 1:
                                    // Customize player with 2 attributes (position and team)
                                    Player.printPlayerPositions();
                                    int position = Utilities.numberInput("Please select the position of this player:", 0, 9);
                                    String playerPosition = Player.getOnePosition(position);
                                    System.out.println(playerPosition);
                                    mng.listAllTeams();
                                    int teamIndex = Utilities.numberInput("Please select the team of this player:",0 , 9);
                                    String playerTeam = mng.getOneTeam(teamIndex);
                                    Player newPlayer = new Player(customName,playerTeam,playerPosition);
                                    System.out.println(newPlayer.getName() + " was added as a " + newPlayer.getPosition() + " in the " + newPlayer.getTeam() + " club, succesfully!");
                                    mng.addPlayer(newPlayer);
                                    System.out.println("----------------------------------------------------------------------------------------");
                                break;
                                
                                case 2:
                                    // Customize coach with 2 attibute (type and team)
                                    Coach.printCoachesTypes();
                                    int type = Utilities.numberInput("Please select the type of this coach:", 0, 7);
                                    String coachType = Coach.getOneType(type);
                                    mng.listAllTeams();
                                    teamIndex = Utilities.numberInput("Please select the team of this player:", 0, 9);
                                    String coachTeam = mng.getOneTeam(teamIndex);
                                    Coach newCoach = new Coach(customName,coachTeam,coachType);
                                    System.out.println(newCoach.getName() + " was added as a " + newCoach.getType() + " in the " + newCoach.getTeam() + " club, succesfully!");
                                    mng.addCoach(newCoach);
                                    System.out.println("----------------------------------------------------------------------------------------");
                                break;
                                case 3:
                                    // Exit customize menu
                                    System.out.println("Ok!");
                                    System.out.println("----------------------------------------------------------------------------------------");
                                break;
                            default:
                                // Invalid option
                                System.out.println("Invalid option! Please try again.");
                                System.out.println("----------------------------------------------------------------------------------------");
                                break;
                            }
                            break;

                        
                        case 2:
                            // Generate random option
                            System.out.println("Random");
                            option = Utilities.numberInput("Please select an option: \n1.Player \n2.Coach ", 1, 3);
                            selectedOption = option;
                            switch(selectedOption){
                                case 1:
                                    // Generate random player
                                    Utilities.generateRandomPlayer(names,mng.getTeams(),Player.getPositions());
                                    System.out.println("----------------------------------------------------------------------------------------");
                                break;
                                case 2 :
                                    // Generate random coach
                                    Utilities.generateRandomCoach(names, mng.getTeams(),Coach.getTypes());
                                    System.out.println("----------------------------------------------------------------------------------------");
                                break;
                                case 3: 
                                    // Exit generate random menu
                                    System.out.println("Ok!");
                                break;
                                default:
                                    // Invalid option
                                    System.out.println("Invalid option! Please try again.");
                                    System.out.println("----------------------------------------------------------------------------------------");
                                break;
                            }
                            break;
                        case 3:
                            // Exit add menu
                            System.out.println("Ok!");
                            System.out.println("----------------------------------------------------------------------------------------");
                            break;
                        default:
                            // Invalid option
                            System.out.println("Invalid option! Please try again.");
                            System.out.println("----------------------------------------------------------------------------------------");
                            break;
                    }
                    break;
                case EXIT:
                    // Exit the application
                    System.out.println("Exiting the application. \nSee you next time.");
                    break;
                    
                default:
                    // Invalid option
                    System.out.println("Invalid option! Please try again.");
                    break;
            }

        }   
        
        // Continue loop until the user chooses to exit
        while(selectOption != MainMenu.MenuOption.EXIT);
        
    }
        
}
