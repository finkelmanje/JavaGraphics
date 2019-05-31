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

public class Runner implements Serializable {

 
    public static void main(String args[]) {
      //  DataReader rd = new DataReader();
       // rd.readIn();
        
        String nm = "cat";
        Stocks tsla = new Stocks("Tesla", "TSLA", 286.12,"C:/Users/John/Downloads/TSLA.csv");
        tsla.addnewSecurity(tsla);
     //   tsla.readIn();
        System.out.println(tsla.getSecurityNumData().size());
        
       System.out.println(tsla.calcslope(42));
     System.out.println(tsla.expectedGrowth(100, 10));
     
     ETFs schb = new ETFs("Schwab Broad Market ETF","SCHB", 67.00,"C:/Users/John/Downloads/SCHB.csv" , 0.03);
     tsla.addnewSecurity(schb);
     System.out.println(schb.calcslope(10));
     System.out.println(schb.expectedGrowth(100, 10));
  //   System.out.println(tsla.getSecurityList());
     
      System.out.println(tsla.compareGrowth(tsla.getSecurityList(), 10, 100));
    // schb.readIn();
    
   
       
       

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
