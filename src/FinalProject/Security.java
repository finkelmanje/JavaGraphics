/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject;

import java.util.ArrayList;
import java.util.*;

/**
 *
 * @author finkelmanj7070
 */
public class Security extends DataReader{

    private String name;
    private String ticker;
    private Double cp;
    private ArrayList<Double> securityNumData;
    private int graphInterval;
    private Double slope;
    private Double expectedprice;
    private Boolean hasER = false;
    private Double expenseRatio = 0.0;
    public  ArrayList<Security> securityList = new ArrayList<>();

    public Security(String nm, String tk, Double currprice) {
        name = nm;
        ticker = tk;
        cp = currprice;
    }

    public Security(String nm, String tk, Double currprice, String fl) {
        super(fl);
        name = nm;
        ticker = tk;
        cp = currprice;
        super.readIn();
        securityNumData = super.getNumData();
        readIn();

    }

    //determines the historical % gain or loss that the security had from the present to the set timeperiod (10 days ago, 265 days ago, etc.)
    //aka the ratio between the current price and previous price times 100
    public double avggain(int timeperiod) {
        return 100 * cp / securityNumData.get(timeperiod);
    }

    //given an interval in days, calculates the average change in price and creates a slope from that
    //this slope is used to determine your expected growth later on
    public double calcslope(int interval) {
        
        if(interval > securityNumData.size()) {
            System.out.println("Your interval is larger than your data!");
            return 0.0;
        }
        else {
        
        setGraphInterval(interval);

        double differencesum = 0;

        for (int i = securityNumData.size() -1; i > securityNumData.size() - interval; i--) {
            differencesum += securityNumData.get(i) - securityNumData.get(i - 1);
        }

        setSlope((Double) differencesum / interval);

        return getSlope();
        }
    }

    //takes the most recent point, the current price, to estimate a "y-intercept" for the line
    public double finalLine() {

        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter a time interval to base your line off::  ");
        int inp = keyboard.nextInt();
        setSlope((Double) calcslope(inp));

        return getSlope();

    }

    //returns the expected value of an inputed amount of money in an inputed amount of days 
    public double expectedGrowth(double money, int timeperiod) {
        double amount = money / cp;
        setExpectedprice(timeperiod * getSlope() + getCp());
       
        if(getHasER()) {
        return amount * getExpectedprice() - (getExpenseRatio()*(timeperiod/365)*amount*getExpectedprice());
        }
        else {
        
         return amount * getExpectedprice();
        }
    }

     public String compareGrowth(ArrayList<Security> arr, int timeperiod, double money) {
        Security temp;
    ArrayList<Security> copy = arr;
    for (int i = copy.size() -1; i > 0; i--) {
    if (copy.get(i).expectedGrowth(money, timeperiod) > copy.get(i-1).expectedGrowth(money, timeperiod)) {
    temp = copy.get(i-1);
    copy.set(i-1, copy.get(i));
    copy.set(i, temp);
    }
     }
    return copy.get(0).getName() + " has the largest growth potential";
    }
     
     public void addnewSecurity(Security sk) {
         securityList.add(sk);
     }
     
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the ticker
     */
    public String getTicker() {
        return ticker;
    }

    /**
     * @param ticker the ticker to set
     */
    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    /**
     * @return the cp
     */
    public Double getCp() {
        return cp;
    }

    /**
     * @param cp the cp to set
     */
    public void setCp(Double cp) {
        this.cp = cp;
    }

    /**
     * @return the securityNumData
     */
    public ArrayList<Double> getSecurityNumData() {
        return securityNumData;
    }

    /**
     * @param securityNumData the securityNumData to set
     */
    public void setSecurityNumData(ArrayList<Double> securityNumData) {
        this.securityNumData = securityNumData;
    }


    /**
     * @return the graphInterval
     */
    public int getGraphInterval() {
        return graphInterval;
    }

    /**
     * @param graphInterval the graphInterval to set
     */
    public void setGraphInterval(int graphInterval) {
        this.graphInterval = graphInterval;
    }

    /**
     * @return the slope
     */
    public Double getSlope() {
        return slope;
    }

    /**
     * @param slope the slope to set
     */
    public void setSlope(Double slope) {
        this.slope = slope;
    }

    /**
     * @return the expectedprice
     */
    public Double getExpectedprice() {
        return expectedprice;
    }

    /**
     * @param expectedprice the expectedprice to set
     */
    public void setExpectedprice(Double expectedprice) {
        this.expectedprice = expectedprice;
    }

    /**
     * @return the hasER
     */
    public Boolean getHasER() {
        return hasER;
    }

    /**
     * @param hasER the hasER to set
     */
    public void setHasER(Boolean hasER) {
        this.hasER = hasER;
    }

    /**
     * @return the expenseRatio
     */
    public Double getExpenseRatio() {
        return expenseRatio;
    }

    /**
     * @param expenseRatio the expenseRatio to set
     */
    public void setExpenseRatio(Double expenseRatio) {
        this.expenseRatio = expenseRatio;
    }

    /**
     * @return the securityList
     */
    public ArrayList<Security> getSecurityList() {
        return securityList;
    }

    /**
     * @param securityList the securityList to set
     */
    public void setSecurityList(ArrayList<Security> securityList) {
        this.securityList = securityList;
    }
    
     public String toString() {
        return name + " " + ticker + ": " + cp;
    }
    

   

}
