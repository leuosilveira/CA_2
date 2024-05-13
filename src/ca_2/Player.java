/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca_2;

import java.util.List;

/**
 *
 * @author Leonardo
 */
public class Player {
    
    private String name;
    private String team;
    private String position;
    private static String[] positions = {"Full-back", "Wing", "Centre", "Fly-half", "Scrum-half", "Number Eight", "Flanker", "Lock/Second Row", "Hooker", "Loosehead and Tighthead Prop"}; 



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

    public void setName(String name) {
        this.name = name;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public void setPosition(String position) {
        this.position = position;
    }
    
    public static String[] getPositions() {
        return positions;
    }
    
    public static String getOnePosition(int index){
        return positions[index];
    }

    public static void setPositions(String[] positions) {
        Player.positions = positions;
    }
    
    public static void printPlayerPositions(){
        for(int i = 0; i < positions.length;i++){
            System.out.println(i + "." + positions[i]);
        }
    }
    
}
