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
public abstract class Security extends DataReader implements SecurityComparable {

    private String name;
    private String ticker;
    private Double cp;
    private ArrayList<Double> securityNumData;
    private int graphInterval;

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

    }

    //determines the historical % gain or loss that the security had from the present to the set timeperiod (10 days ago, 265 days ago, etc.)
    //aka the ratio between the current price and previous price times 100
    public double avggain(int timeperiod) {
        return 100*cp/securityNumData.get(timeperiod) ;      
    }

    
    //given an interval in days, calculates the average change in price and creates a slope from that
    public double calcslope(int interval) {
        setGraphInterval(interval);
        
        double differencesum = 0;
        
        for (int i = 0; i < interval - 1; i++) {
            differencesum+= securityNumData.get(i) - securityNumData.get(i-1);
        }
        
        double avgdifference = differencesum/interval;
        
        return avgdifference;
    }

    //takes the most recent point, the current price, to estimate a "y-intercept" for the line
    public abstract double calcyint();  
    
    
    
    
    public abstract double finalLine();
    
    
   /* public String compareGrowth(ArrayList<Security> arr, int timeperiod) {
        
    }
    */
    

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

    public String toString() {
        return name + " " + ticker + ": " + cp;
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

}
