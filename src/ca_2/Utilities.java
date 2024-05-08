/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca_2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Leonardo
 */
public class Utilities {

    
    public static void ReadAndGetNames(String file, List<String> names){ 
          
        
        try{
            BufferedReader collection = new BufferedReader(new FileReader(file));
            System.out.println("File read successfully!");
                  
            String line;
            String[] lineParts;
            while((line = collection.readLine()) != null){
                lineParts = line.split(",");  
                names.add(lineParts[1].toUpperCase() + " " + lineParts[2].toUpperCase());
            }
    
        }
//        Error handling if file not found
        catch (Exception e) {
            System.out.println("File not found\n");   
        }
        
    }


    public static String stringInput(String prompt){

        Scanner myStringInput = new Scanner(System.in);
        String userStringInput;

        do{
            System.out.println(prompt);
            System.out.println("(Type here)");

            userStringInput = myStringInput.nextLine();
            userStringInput = userStringInput.trim().toUpperCase();

        }while (userStringInput == "");

        return userStringInput;
    }



}