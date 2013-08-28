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
public abstract class Base extends Observable{
    
    protected String base;
    
    public void setCurrentBase(){
        changeBase();
        setChanged();
        notifyObservers(this);
    }
    
    public String getCurrentBase(){
        return base;
    }
    abstract public Double convertToDecimal(String input);
    abstract public String convertBaseOutput(String input);
    abstract public void changeBase();
}
