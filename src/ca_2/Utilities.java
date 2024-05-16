/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca_2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Collections;
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
    public static void Searching(List<String> list, String key) {
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
                System.out.println(key + " is found at index position " + middle);
                return;
            }
            middle = (leftPointer + rightPointer) / 2;
        }        
        System.out.println(key + " is not found in the Data Base.");
    } 
    
    // Method to print a sorted list
    public static void printSortedList(List<String> namesList){
        Utilities.Sorting(namesList);
        for(int i = 0; i < namesList.size(); i++){
            System.out.println(namesList.get(i));
        }
    }
}
