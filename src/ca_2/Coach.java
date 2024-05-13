/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca_2;

/**
 *
 * @author Leonardo
 */
public class Coach {
    private String name;
    private String team;
    private String type;
    private static String[] types = {"Head Coach", "Passing Coach", "Forwards Coach", "Defensive Coordinator", "Lineout Coach", "Scrum Coach", "Referee", "Coach"};


    public Coach(String name, String team, String type) {
        this.name = name;
        this.team = team;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getTeam() {
        return team;
    }

    public String getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    public static String[] getTypes() {
        return types;
    }

    public void setTypes(String[] types) {
        this.types = types;
    }    
    
    public static String getOneType(int index){
        return types[index];
    }
    
    public static void printCoachesTypes(){
        for(int i = 0; i < types.length;i++){
            System.out.println(i + "." + types[i]);
        }
    }    
}
