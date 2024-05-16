/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca_2;

/**
 * Represents a rugby coach.
 */
public class Coach {
    
    // Coach attributes
    private String name;
    private String team;
    private String type;
    
    // Array of possible coach types
    private static final String[] types = {"Head Coach", "Passing Coach", "Forwards Coach", "Defensive Coordinator", "Lineout Coach", "Scrum Coach", "Referee", "Coach"};

    // Constructor to initialize a coach with a name, team, and type
    public Coach(String name, String team, String type) {
        this.name = name;
        this.team = team;
        this.type = type;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public String getTeam() {
        return team;
    }

    public String getType() {
        return type;
    }

    // Setter methods
    public void setName(String name) {
        this.name = name;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    // Getter for the array of possible coach types
    public static String[] getTypes() {
        return types;
    } 
    
    // Getter for a specific coach type by index
    public static String getOneType(int index){
        return types[index];
    }
    
    // Method to print all coach types
    public static void printCoachesTypes(){
        for(int i = 0; i < types.length;i++){
            System.out.println(i + "." + types[i]);
        }
    }    
}
