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
public abstract class Security extends DataReader {
    private String name;
    private String ticker;
    private Double cp;
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
    }
    
    public abstract double avggain(int timeperiod);
    
    public abstract double calcslope();
    
    public abstract double calcyint();
    
    
    
    
}
