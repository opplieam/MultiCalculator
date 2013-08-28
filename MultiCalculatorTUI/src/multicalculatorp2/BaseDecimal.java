/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package multicalculatorp2;

/**
 *
 * @author Opponent
 */
public class BaseDecimal extends Base{

    @Override
    public void changeBase() {
        base = "dec";
    }

    @Override
    public Double convertToDecimal(String input) {
        return Double.parseDouble(input);
    }

    @Override
    public String convertBaseOutput(String input) {
        //return Integer.parseInt(input) +"";
        return input;
    }
    
}
