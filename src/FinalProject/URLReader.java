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
public class URLReader {
    String line = "";
     String csvFile = "C:/Users/finkelmanj7070/Downloads/HistoricalQuotes.csv";
     BufferedReader br;
     ArrayList<String> stringdata = new ArrayList<>();
      ArrayList<Double> doubledata = new ArrayList<>();
    
    public URLReader() {
        try {
            this.br = new BufferedReader(new FileReader(csvFile));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(URLReader.class.getName()).log(Level.SEVERE, null, ex);
        }
}
        
  
                    
  public void readIn() {              
        try {
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] cols = line.split(",");
                stringdata.add(cols[1]);
                System.out.println("Coulmn 1= " + cols[1]);
                
                //int [] arr = new int [size];
    //  for(int i=0; i<size; i++) {
        // arr[i] = Integer.parseInt(str[i]);
   //   }
                
                
            }       } catch (IOException ex) {
            Logger.getLogger(URLReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println(stringdata);
        for (String myInt : stringdata) 
            { 
              doubledata.add(Double.valueOf(myInt)); 
            }
            System.out.println(doubledata);
}
}

