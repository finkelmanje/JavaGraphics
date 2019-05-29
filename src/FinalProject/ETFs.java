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
public class ETFs extends Security {

    private double expenseRatio;

    public ETFs(String nm, String tk, Double currprice, String fl, Double er) {
        super(nm, tk, currprice, fl);
        setExpenseRatio(er);
        setexpenseRatio(er);
        setHasER(true);
    }

    /**
     * @return the expenseRatio
     */
    public double getexpenseRatio() {
        return expenseRatio;
    }

    /**
     * @param expenseRatio the expenseRatio to set
     */
    public void setexpenseRatio(double expenseRatio) {
        this.expenseRatio = expenseRatio;
    }

}
