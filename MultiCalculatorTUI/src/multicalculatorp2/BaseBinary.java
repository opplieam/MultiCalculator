/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package multicalculatorp2;


/**
 *
 * @author Opponent
 */
public class BaseBinary extends Base{

    @Override
    public void changeBase() {
        base = "bin";
    }

    @Override
    public Double convertToDecimal(String input) {
        
        return (double) Integer.parseInt(input, 2);
    }

    @Override
    public String convertBaseOutput(String input) {
        return Integer.toBinaryString(Integer.parseInt(input));
    }
    
    
}
