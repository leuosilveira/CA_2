/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca_2;

import java.util.ArrayList;
import java.util.List;

/**
 * Manager class for managing rugby teams, players, and coaches.
 */
public class Manager {
       
    // Lists to store teams, players, and coaches
    // They are all static because I want that whenever I change the information 
    // in these attibutes, this change applies to all created objets
    private static List<Team> teams;
    private static List<Player> players;
    private static List<Coach> coaches; 
    
    // Constructor initializes lists and adds default teams
    public Manager(){
        this.teams = new ArrayList<>();
        this.players = new ArrayList<>();
        this.coaches = new ArrayList<>();

        // Add default teams
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
    
    // Getter for teams list
    public List<Team> getTeams(){
        return this.teams;
    }
    
    // Getter for retrieving a specific team by index
    public String getOneTeam(int index){
        return teams.get(index).getName();
    }
    
    // Setter for teams list
    public void setTeams(List<Team> teams){
        this.teams = teams;
    }

    // Getters and setters for players and coaches lists
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
    
    // Method to add a player to the players list
    public void addPlayer(Player player){
        this.players.add(player);
    }
    
    // Method to add a coach to the coaches list
    public void addCoach(Coach coach){
        this.coaches.add(coach);
    }
    
    // Method to list all teams
    public void listAllTeams(){
        int count = 0;
        for(Team team:teams){
            System.out.println(count+"."+team.getName());
            count++;
        }
    }
    
    // Method to list all players
    public void listAllPlayers(){
        for(Player player:players){
            System.out.println(player.getName());
        }
    }
    
    // Method to list all coaches
    public void listAllCoaches(){
        System.out.println("Coaches are: ");
        for(Coach coach:coaches){
            System.out.println(coach.getName());
        }
    }
    
    // Static methods to list names of teams, players, and coaches
    public static List<String> listAllTeamsNames(){
        List<String> teamsNames = new ArrayList<>();
        for(Team team:teams){
            teamsNames.add(team.getName());
        }
        return teamsNames;
    }
    
    public static List<String> listAllCoachesNames(){
        List<String> coachesNames = new ArrayList<>();
        for(Coach coach:coaches){
            coachesNames.add(coach.getName());
        }
        return coachesNames;
    }
    
    public static List<String> listAllPlayersNames(){
        List<String> playersNames = new ArrayList<>();
        for(Player player:players){
            playersNames.add(player.getName());
        }
        return playersNames;
    }
}
