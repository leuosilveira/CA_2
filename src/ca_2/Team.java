/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca_2;


/**
 * Represents a rugby team.
 */
public class Team {

    // Name of the team
    private String name;
    
    // Constructor to initialize the team with a name
    public Team(String name){
        this.name = name;
    }
    
    // Getter method to retrieve the team name
    public String getName(){
        return name;
    }   
    
    // Setter method to set the team name
    public void setName(String name){
        this.name = name;
    }

}
