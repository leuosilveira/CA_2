/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca_2;

/**
 *
 * @author Leonardo
 */
public class Player {
    
    private String name;
    private String team;
    private String position;

    public Player(String name, String team, String position) {
        this.name = name;
        this.team = team;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public String getTeam() {
        return team;
    }

    public String getPosition() {
        return position;
    }

}
