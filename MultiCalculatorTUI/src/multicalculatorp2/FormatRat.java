/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package multicalculatorp2;

import org.jlinalg.rational.Rational;

/**
 *
 * @author Opponent
 */
public class FormatRat extends Format{

    private double numo;
    private double deno;
    
    @Override
    public void changeFormat() {
        format = "rat";
    }

    @Override
    public boolean isFormat(String input) {
        
        return input.matches("\\w+/\\w+");
    }

    @Override
    public String convertInput() {
         if(isFormat(userInput)){
//           System.out.println("userInput " + userInput);
            String[] fraction = userInput.split("\\/");
            numo = baseMap.convertToDecimal(fraction[0]);
            deno = baseMap.convertToDecimal(fraction[1]);

            double answer = numo/deno;
            return answer+"";
         }else{
             return userInput;
         }
    }

    @Override
    public String convertOutput() {
        //System.out.println("Result in Format "+ userInput);
        Rational r = Rational.FACTORY.get(Double.parseDouble(userInput));
        //System.out.println("Rational Numo" + r.getNumerator());
        //System.out.println("Rational Deno" + r.getDenominator());
        String nume = baseMap.convertBaseOutput(r.getNumerator()+"");
        String deno = baseMap.convertBaseOutput(r.getDenominator()+"");
        return nume+"/"+deno;
    }
    
}
