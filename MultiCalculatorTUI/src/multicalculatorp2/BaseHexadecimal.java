/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package multicalculatorp2;

/**
 *
 * @author Opponent
 */
public class BaseHexadecimal extends Base{

    @Override
    public void changeBase() {
        base = "hex";
        
    }

    @Override
    public Double convertToDecimal(String input) throws NumberFormatException{
        System.out.println("Input in class base hexa " + input );
        return (double) Integer.parseInt(input, 16);
    }

    @Override
    public String convertBaseOutput(String input) {
        
        //String hex = Integer.toHexString(Integer.parseInt(input));
        return Integer.toHexString(Integer.parseInt(input));
    }
    
}
