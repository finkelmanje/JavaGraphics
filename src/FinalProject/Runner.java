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
        
       /*
       Stocks tsla = new Stocks("Tesla", "TSLA", 286.12,"C:/Users/John/Downloads/TSLA.csv");
      //   Stocks tsla = new Stocks("Tesla", "TSLA", 286.12,"C:/Users/finkelmanj7070/Downloads/TSLA.csv");
        tsla.addnewSecurity(tsla);
     //   tsla.readIn();
        System.out.println(tsla.getSecurityNumData().size());
        
       System.out.println(tsla.calcslope(42));
     System.out.println(tsla.expectedGrowth(100, 10));
     
    ETFs schb = new ETFs("Schwab","SCHB", 67.00,"C:/Users/John/Downloads/SCHB.csv" , 0.03);
    //  ETFs schb = new ETFs("Schwab","SCHB", 67.00,"C:/Users/finkelmanj7070/Downloads/SCHB.csv" , 0.03);
     tsla.addnewSecurity(schb);
     System.out.println(schb.calcslope(10));
     System.out.println(schb.expectedGrowth(100, 10));
    System.out.println(tsla.getSecurityList());
     
      System.out.println(tsla.compareGrowth(tsla.getSecurityList(), 10, 100));
      
      tsla.writeData(tsla.getSecurityList());
    //  tsla.readData();
    // schb.readIn();
       */
        DataReader dr = new DataReader(3);
        //Security sty = new Security();
        ArrayList<Security> st = new ArrayList<Security>();
        dr.readData(st);
    
   
       
       

  
    }
}
