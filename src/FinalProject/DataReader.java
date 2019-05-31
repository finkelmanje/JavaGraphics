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
    String csvFile = "C:/Users/finkelmanj7070/Downloads/TSLA.csv";
    private byte[] bytes;
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
                stringdata.add(cols[4]);
                System.out.println("Coulmn 4= " + cols[4]);

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
        System.out.println(doubledata);

    }

    public ArrayList<Double> getNumData() {
        return doubledata;
    }

    public void writeData(ArrayList<Security> secList) {
        FileOutputStream fos = null;
        File file;
     // String mycontent = "This is my Data which needs" +
        //     " to be written into the file";
        try {
            //Specify the file path here
            file = new File("src/FinalProject/test.dat");
            fos = new FileOutputStream(file);

            /* This logic will check whether the file
             * exists or not. If the file is not found
             * at the specified location it would create
             * a new file*/
            if (!file.exists()) {
                file.createNewFile();
            }

            /*String content cannot be directly written into
             * a file. It needs to be converted into bytes
             */
       //   for (Double db: arr) {
            //   String dlb =  db.toString();
            // byte[] bytesArray = dlb.getBytes();
            
            //method borrowed from https://stackoverflow.com/questions/20869325/convert-arraylist-to-byte-array/20879137
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            DataOutputStream out = new DataOutputStream(baos);
            for (Security sty : secList) {
                out.writeUTF(sty.toReadString());
            }
            bytes = baos.toByteArray();
            fos.write(bytes);

            fos.flush();
            System.out.println("File Written Successfully");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException ioe) {
                System.out.println("Error in closing the Stream");
            }
        }
    }

    public void readData() {

        try {
            ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
            DataInputStream in = new DataInputStream(bais);
            while (in.available() > 0) {
                String element = in.readUTF();
                System.out.println(element);
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }
}

//load data to secList in UI.java
//saving file location is ok, save all parts of constructor as strings separated by spaces and then each object is separated by line