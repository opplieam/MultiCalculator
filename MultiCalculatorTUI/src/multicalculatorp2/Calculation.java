/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package multicalculatorp2;

import java.util.Observable;

/**
 *
 * @author Opponent
 */
public abstract class Calculation extends Observable{
    
    protected Double variable1;
    protected Double variable2;
    protected Double result;
    
    public void setVariable(String variable1,String variable2){
        
        this.variable1 = Double.valueOf(variable1);
        this.variable2 = Double.valueOf(variable2);
    }
    
    public void calculate(){
        calculateSubClass();
        setChanged();
        notifyObservers(this);
    }
    
    public String getResult(){
        
        
        return result+"";
    }
    
    abstract void calculateSubClass();
    
}
