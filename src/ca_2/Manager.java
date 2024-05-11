/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Leonardo
 */
public class Manager {
       
    private List<Team> teams;
    private List<Player> players;
    private List<Coach> coaches; 
    
    public Manager(){
        this.teams = new ArrayList<>();
        this.players = new ArrayList<>();
        this.coaches = new ArrayList<>();

    }
    
    public List<Team> getTeams(){
        return this.teams;
    }
    
    public void setTeams(List<Team> teams){
        this.teams = teams;
    }
    
    public void addTeam(Team team){
        this.teams.add(team);
    }
     
    public void Manager(){
        List<String> teamNames = new ArrayList<>(Arrays.asList("Ireland", "Brazil", "France"));
        
        
        for(String teamName : teamNames){
            Team newTeam = new Team(teamName);
            teams.add(newTeam);
            
        }

        System.out.println(teams);
        
    }
    
    
}
