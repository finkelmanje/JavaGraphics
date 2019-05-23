/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject;

import java.util.ArrayList;

/**
 *
 * @author finkelmanj7070
 */
public abstract class Security extends DataReader implements SecurityComparable {

    private String name;
    private String ticker;
    private Double cp;
    private ArrayList<Double> securityNumData;

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

    public abstract double avggain(int timeperiod);

    public abstract double calcslope();

    public abstract double calcyint();
    
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

}
