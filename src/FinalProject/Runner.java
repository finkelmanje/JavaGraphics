/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject;

/**
 *
 * @author finkelmanj7070
 */
import java.util.*;
import java.io.*;

public class Runner extends Security implements Serializable {

 
    public static void main(String args[]) {
        DataReader rd = new DataReader();
        rd.readIn();
        securityList.add(new Stocks("Tesla", "TSLA", 286.12,"C:/Users/finkelmanj7070/Downloads/TSLA.csv"));

   //this process comes from https://www.geeksforgeeks.org/serialization-in-java/
        
        //write to dat file and then read using scanner like earlier project
        //look at https://github.com/mremington/JavaGolfApp/blob/master/src/golfApp/com/UserList.java
  /*  try { 
  
         // Saving of object in a file 
         FileOutputStream file = new FileOutputStream 
         (filename); 
         ObjectOutputStream out = new ObjectOutputStream 
         (file); 
  
         // Method for serialization of object 
         out.writeObject(object); 
  
         out.close(); 
         file.close(); 
  
         System.out.println("Object has been serialized\n"
         + "Data before Deserialization."); 
         printdata(object); 
        
         } */
    }
}
