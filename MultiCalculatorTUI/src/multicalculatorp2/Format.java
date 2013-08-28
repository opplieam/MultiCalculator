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
public abstract class Format extends Observable{
    
    protected String format;
    protected String userInput;
    protected Base baseMap;
    
    public Format(){
    }
    
    public void setCurrentFormat(){
        changeFormat();
        setChanged();
        notifyObservers(this);
    }
    
    public String getCurrentFormat(){
        return format;
    }
    
    public void setUserInput(String userInput){
        this.userInput = userInput;
    }
    public void setBaseMap(Base baseMap){
        this.baseMap = baseMap;
    }
    
    
    abstract public void changeFormat();
    abstract public boolean isFormat(String input);
    abstract public String convertInput();
    abstract public String convertOutput();
}
