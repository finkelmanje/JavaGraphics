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
    String csvFile = "C:/Users/finkelmanj7070/Downloads/HistoricalQuotes.csv";
    // String csvFile = "C:/Users/John/Downloads/HistoricalQuotes.csv";

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
            //this read in method comes from https://stackoverflow.com/questions/12169038/read-csv-file-column-by-column
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] cols = line.split(",");
                stringdata.add(cols[1]);
                System.out.println("Coulmn 1= " + cols[1]);

            }
        } catch (IOException ex) {
            Logger.getLogger(DataReader.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println(stringdata);
        //convert imported data to doubles and save in arraylist
        for (int i = 1; i < stringdata.size(); i++) {
            String number = stringdata.get(i);
            String number1 = number.replace("\"", "");
            double convertednumber = Double.parseDouble(number1);
            doubledata.add(convertednumber);

        }

    }
    
    public ArrayList<Double> getNumData() {
        return doubledata;
    }
}
