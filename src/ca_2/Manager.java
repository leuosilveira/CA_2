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

        teams.add(new Team("Ireland"));
        teams.add(new Team("France"));
        teams.add(new Team("Wales"));
        teams.add(new Team("South Africa"));
        teams.add(new Team("Australia"));
        teams.add(new Team("Scotland"));
        teams.add(new Team("New Zealand"));
        teams.add(new Team("England"));
        teams.add(new Team("Argentina"));
        teams.add(new Team("Brazil"));
    }
    
    public List<Team> getTeams(){
        return this.teams;
    }
    
    public void setTeams(List<Team> teams){
        this.teams = teams;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Coach> getCoaches() {
        return coaches;
    }

    public void setCoaches(List<Coach> coaches) {
        this.coaches = coaches;
    }
    
    public void addPlayer(Player player){
        this.players.add(player);
    }
    
    public void addCoach(Coach coach){
        this.coaches.add(coach);
    }
    
    public void listAllTeams(){

     System.out.println("Teams are: ");
     
        for(Team team:teams){

            System.out.println(team+"."+team.getName());

        }
    }
    
    public void listAllPlayers(){

     System.out.println("Players are: ");
     
        for(Player player:players){

            System.out.println(player.getName());

        }
    }
    
    public void listAllCoaches(){

     System.out.println("Coaches are: ");
     
        for(Coach coach:coaches){

            System.out.println(coach.getName());

        }
    }
}
