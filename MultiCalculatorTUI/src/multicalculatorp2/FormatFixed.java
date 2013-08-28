/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package multicalculatorp2;

/**
 *
 * @author Opponent
 */
public class FormatFixed extends Format{

    @Override
    public void changeFormat() {
        format = "fixed";
    }

    @Override
    public boolean isFormat(String input) {
        return input.matches("\\w+") || input.matches("\\w+\\.\\w+");
    }

    @Override
    public String convertInput() {
        
        if(userInput.matches("\\w+")){
            Double ans = baseMap.convertToDecimal(userInput);
            return ans+"";
        }else{
            String splitDot[] = userInput.split("\\.");
            double leftSide = baseMap.convertToDecimal(splitDot[0]);
            double rightSide = baseMap.convertToDecimal(splitDot[1]);
            return (int)leftSide+"."+(int)rightSide;
        }
        
    }

    @Override
    public String convertOutput() {
        
        if(userInput.compareTo("0.0") != 0){
            if(userInput.compareTo("0") != 0){
                
                String splitDot[] = userInput.split("\\.");

                String leftSide = baseMap.convertBaseOutput(splitDot[0]);
                //System.out.println("Split Dot " + splitDot[1]);
                String rightSide = baseMap.convertBaseOutput(splitDot[1]);
                return leftSide+"."+rightSide;
            }else{
                return userInput+"";
            }
        }else{
            return userInput+"";
        }
    }
    
}
