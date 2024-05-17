/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca_2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Utility class containing various helper methods for the rugby club management system.
 */
public class Utilities {

    // Method to read data from a file and extract names
    public static void ReadAndGetNames(String file, List<String> names){         
        try{
            BufferedReader collection = new BufferedReader(new FileReader(file));
            System.out.println("File read successfully!");   
            String line;
            String[] lineParts;
            while((line = collection.readLine()) != null){
                lineParts = line.split(",");  
                names.add(lineParts[1].toUpperCase() + " " + lineParts[2].toUpperCase());
            }
        }
        // Error handling if file not found
        catch (Exception e) {
            System.out.println("File not found\n");   
        } 
    }

    // Method to generate a random player
    public static void generateRandomPlayer(List<String> namesList, List<Team> teams, String[] positions ){
        Manager mng = new Manager();
                
        String rndName = namesList.get((int)(Math.random()*namesList.size()));
        String rndTeam = mng.getOneTeam((int)(Math.random()*teams.size()));
        String rndPosition = Player.getOnePosition((int)(Math.random()*positions.length));
        
        // Check if the randomly generated name is already in use
        if(mng.listAllPlayersNames().contains(rndName)){
            generateRandomPlayer(namesList, teams, positions);
        } else {
            Player newRandomPlayer = new Player(rndName, rndTeam, rndPosition);
        
            System.out.println(newRandomPlayer.getName() + " was added as a " + newRandomPlayer.getPosition() + " in the " + newRandomPlayer.getTeam() + " club, successfully!");
        }
    }
    
    // Method to generate a random coach
    public static void generateRandomCoach(List<String> namesList, List<Team> teams, String[] types ){
        Manager mng = new Manager();
        
        String rndName = namesList.get((int)(Math.random()*namesList.size()));
        String rndTeam = mng.getOneTeam((int)(Math.random()*teams.size()));
        String rndType = Coach.getOneType((int)(Math.random()*types.length));
        
        // Check if the randomly generated name is already in use
        if(mng.listAllCoachesNames().contains(rndName)){
            generateRandomCoach(namesList, teams, types);
        } else {
            Coach newRandomCoach = new Coach(rndName, rndTeam, rndType);
       
            mng.addCoach(newRandomCoach);
        
            System.out.println(newRandomCoach.getName() + " was added as a " + newRandomCoach.getType() + " in the " + newRandomCoach.getTeam() + " club, successfully!");
        }
    }

    // Method to take a string input from the user
    public static String stringInput(String prompt) {
        Scanner myStringInput = new Scanner(System.in);
        String userStringInput;

        do {
            System.out.println(prompt);
            System.out.println("(Type here)");

            userStringInput = myStringInput.nextLine();
            userStringInput = userStringInput != null ? userStringInput.trim().toUpperCase() : "";

            if (userStringInput.isEmpty()) {
                System.out.println("Invalid input! Please enter a non-empty string.");
            }
        } while (userStringInput.isEmpty());

        return userStringInput;
    }

    // Method to take a number input from the user
    public static int numberInput(String prompt, int min, int max) {
        Scanner myNumberInput = new Scanner(System.in);
        int userNumber = 0;
        
        do {
            System.out.println(prompt);
            System.out.printf("(Please enter a number between %d and %d)%n", min, max);
            String userInput = myNumberInput.nextLine().trim();
            
            try {
                userNumber = Integer.parseInt(userInput);
                if (userNumber < min || userNumber > max) {
                    System.out.printf("Invalid input! Please enter a number between %d and %d.%n", min, max);
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid number.");
            }
        } while (userNumber < min || userNumber > max);
        
        return userNumber;
    }

    // Method to sort a list of strings
    public static void Sorting(List<String> list){
        int n = list.size();
        boolean swapped;

        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (list.get(i - 1).compareTo(list.get(i)) > 0) {
                    String temName = list.get(i - 1);
                    list.set(i - 1, list.get(i));
                    list.set(i, temName);
                       
                    swapped = true;
                }
            }       
        } while(swapped);           
    }
    
    // Method to print the first fifty elements of a list that we use to print the elements from the club_form
    public static void printFirstFifty(List<String> list){
        for (int count = 0; count < 50; count++) {
            System.out.println(list.get(count));                
        }
    }
    
    // Method to search for a key in a sorted list
    public static String Searching(List<String> list, String key) {
        Collections.sort(list);

        int middle = list.size() / 2;
        int leftPointer = 0;
        int rightPointer = list.size() - 1;

        while (leftPointer <= rightPointer) {
            int comparison = list.get(middle).compareTo(key);
            if (comparison < 0) {
                leftPointer = middle + 1;
            } else if (comparison > 0) {
                rightPointer = middle - 1;
            } else {
                //System.out.println(key + " is found at index position " + middle);
                return key + "is found at index position " + middle;
            }
            middle = (leftPointer + rightPointer) / 2;
        }        
        //System.out.println(key + " is not found in the Data Base.");
        return key + "is not found in the Data Base.";
    } 
    
    // Method to print a sorted list
    public static void printSortedList(List<String> namesList){
        Utilities.Sorting(namesList);
        for(int i = 0; i < namesList.size(); i++){
            System.out.println(namesList.get(i));
        }
    }


    //UNITS TESTS 
    
    // Unit Test 1: Test addPlayer method
    public void testAddPlayer() {
        Manager mng = new Manager();
        Player player = new Player("John Doe", "Ireland", "Fly-half");
        mng.addPlayer(player);

        // Check if the player is added to the manager's player list
        if (!mng.getPlayers().contains(player)) {
            throw new AssertionError("Player was not added to the list.");
        } else {
            System.out.println("testAddPlayer passed.");
        }
    }
    
    // Unit Test 2: Test generateRandomPlayer method
    public void testGenerateRandomPlayer() {
        Manager mng = new Manager();
        List<String> names = Arrays.asList("John Doe", "Jane Smith", "Alex Johnson");
        List<Team> teams = new ArrayList<>(Arrays.asList(new Team("Ireland"), new Team("France")));
        String[] positions = Player.getPositions();
        Utilities.generateRandomPlayer(names, teams, positions);

        // Check if the player list is not empty after generating a player
        if (mng.getPlayers().isEmpty()) {
            throw new AssertionError("Player list is empty after generating a random player.");
        } else {
            System.out.println("testGenerateRandomPlayer passed.");
        }
    }
    
    // Unit Test 3: Test searching method
    public void testSearchPlayer() {
        List<String> names = Arrays.asList("JOHN DOE", "JANE SMITH");
        String result = Utilities.Searching(names, "JOHN DOE");

        // Check if the search result matches the expected string
        String expected = "JOHN DOE is found at index position 0";
        if (!result.equals(expected)) {
            throw new AssertionError("Search result does not match expected value. Expected: " + expected + ", but got: " + result);
        } else {
            System.out.println("testSearchPlayer passed.");
        }
    }

    // Unit Test 4: Retrieving All Players
    public void testAddPlayers() {
        Manager mng = new Manager();
        Player player1 = new Player("John Doe", "Ireland", "Fly-half");
        Player player2 = new Player("Jane Smith", "France", "Wing");
        mng.addPlayer(player1);
        mng.addPlayer(player2);

        // Check if the list contains both players
        List<Player> players = mng.getPlayers();
        if (!players.contains(player1) || !players.contains(player2)) {
            throw new AssertionError("Not all players were retrieved.");
        } else {
            System.out.println("testAddPlayers passed.");
        }
    }
    
    // Unit Test 5: Retrieving All Coaches
    public void testAddCoaches() {
        Manager mng = new Manager();
        Coach coach1 = new Coach("Alice Brown", "Ireland", "Head Coach");
        Coach coach2 = new Coach("Bob White", "France", "Assistant Coach");
        mng.addCoach(coach1);
        mng.addCoach(coach2);

        // Check if the list contains both coaches
        List<Coach> coaches = mng.getCoaches();
        if (!coaches.contains(coach1) || !coaches.contains(coach2)) {
            throw new AssertionError("Not all coaches were retrieved.");
        } else {
            System.out.println("testAddCoaches passed.");
        }
    }
    
    
}
