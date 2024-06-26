/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca_2;

import java.util.List;

/**
 * Represents a rugby player.
 */
public class Player {
    
    // Player attributes
    private String name;
    private String team;
    private String position;
    
    // Array of possible player positions, this is a final attribute because it will never change.
    private static final String[] positions = {"Full-back", "Wing", "Centre", "Fly-half", "Scrum-half", "Number Eight", "Flanker", "Lock/Second Row", "Hooker", "Loosehead and Tighthead Prop"}; 

    // Constructor to initialize a player with a name, team, and position
    public Player(String name, String team, String position) {
        this.name = name;
        this.team = team;
        this.position = position;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public String getTeam() {
        return team;
    }

    public String getPosition() {
        return position;
    }

    // Setter methods
    public void setName(String name) {
        this.name = name;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public void setPosition(String position) {
        this.position = position;
    }
    
    // Getter for the array of possible positions
    public static String[] getPositions() {
        return positions;
    }
    
    // Getter for a specific position by index
    public static String getOnePosition(int index){
        return positions[index];
    }
    
    // Method to print all player positions
    public static void printPlayerPositions(){
        for(int i = 0; i < positions.length;i++){
            System.out.println(i + "." + positions[i]);
        }
    }
    
}
