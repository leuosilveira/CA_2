/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca_2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Leonardo
 */
public class Manager {
       
    private static List<Team> teams;
    private static List<Player> players;
    private static List<Coach> coaches; 
    
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
    
    public String getOneTeam(int index){
        return teams.get(index).getName();
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

        int count = 0;
        for(Team team:teams){

            System.out.println(count+"."+team.getName());
            count++;
        }
    }
    
    public void listAllPlayers(){
     
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
