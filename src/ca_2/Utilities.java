/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca_2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Collections;
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

    public static int numberInput(String prompt){

        Scanner myNumberInput = new Scanner(System.in);
        String userNumber;
        
        do{
            System.out.println(prompt);
            System.out.println("(Please enter a NUMBER ONLY)");
            
            userNumber = myNumberInput.nextLine();
            userNumber = userNumber.trim();
            
        }while (!userNumber.matches("-?\\d+"));
        
        return Integer.parseInt(userNumber);
    }

    
    public static void Sorting(List<String> list){

        int n = list.size();

        boolean swapped;

        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (list.get(i - 1).compareTo(list.get(i)) > 0) {
                    String tempBookName = list.get(i - 1);
                    list.set(i - 1, list.get(i));
                    list.set(i, tempBookName);
                                     
                    
                    swapped = true;
                }
            }       
        } while(swapped);   
        

    }
    
    
    public static void printFirstFifty(List<String> list){
         for (int count = 0; count < 50;count++) {
                System.out.println(list.get(count));                
        }
         
     }
    
    
    
        public static void Searching(List<String> list, String key) {
        
  
        Collections.sort(list);

        int middle = list.size() / 2;
        int leftPointer = 0;
        int rightPointer = list.size() - 1;

        while (leftPointer <= rightPointer) {
            int comparison = list.get(middle).compareTo(key);
            if (comparison < 0) {
                leftPointer = middle + 1;
            } else if (comparison > 0) {
                rightPointer = middle - 1;
            } else {
                System.out.println(key + " is found at index position " + middle);

                return;
            }
            middle = (leftPointer + rightPointer) / 2;
        }        
        System.out.println(key + " is not found in the Library Collection.");
    }
    
    
    
    
    
}