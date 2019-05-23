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

import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.*;

public class DataReader {
    String line = "";
    // String csvFile = "C:/Users/finkelmanj7070/Downloads/HistoricalQuotes.csv";
      String csvFile = "C:/Users/John/Downloads/HistoricalQuotes.csv";

     BufferedReader br;
     ArrayList<String> stringdata = new ArrayList<>();
      ArrayList<Double> doubledata = new ArrayList<>();
    
    public DataReader() {
        try {
            this.br = new BufferedReader(new FileReader(csvFile));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DataReader.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    
    public DataReader(String fileloc) {
     csvFile = fileloc;
        try {
            this.br = new BufferedReader(new FileReader(csvFile));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DataReader.class.getName()).log(Level.SEVERE, null, ex);
        }
}
        
  
                    
  public void readIn() {              
        try {
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] cols = line.split(",");
                stringdata.add(cols[1]);
                System.out.println("Coulmn 1= " + cols[1]);
                
                //double [] arr = new double [stringdata.size() - 1];
    //  for(int i=1; i<stringdata.size(); i++) {
        // arr[i] = Double.parseDouble(str[i]);
   //   }
                
                
            }       } catch (IOException ex) {
            Logger.getLogger(DataReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println(stringdata);
      //  for (int i = 1; i < stringdata.size(); i++) 
          //  { 
         //     doubledata.add(Double.valueOf(stringdata.get(i))); 
         //   }
          //  System.out.println(doubledata);
       //  double [] arr = new double[stringdata.size() - 1];
      for(int i=1; i<stringdata.size(); i++) {
          String number = stringdata.get(i);
          System.out.println(number);
       double convertednumber = Double.parseDouble(number);
        System.out.println(convertednumber);
     }
     // System.out.println(arr);
}
}

