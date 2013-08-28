/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package multicalculatorp2;

/**
 *
 * @author Opponent
 */
public class FormatFloat extends Format{

    @Override
    public void changeFormat() {
        format = "float";
    }

    @Override
    public boolean isFormat(String input) {
        
        return input.contains("*") && input.contains("^");
    }

    @Override
    public String convertInput() {
        double answer;
        if(userInput.compareTo("0.0") != 0){
            if(userInput.compareTo("0") != 0){
                //System.out.println("User Input " + userInput);
                String[] splitFirstSetNumber = userInput.split("\\*");
                //System.out.println("Split 1 " + splitFirstSetNumber[0]);
                //System.out.println("Split 2 " + splitFirstSetNumber[1]);
                if(!splitFirstSetNumber[0].matches("\\w+\\.\\w+")){
                    
                    double left = baseMap.convertToDecimal(splitFirstSetNumber[0]);

                    String[] splitExpo = splitFirstSetNumber[1].split("\\^");
                    double expo = baseMap.convertToDecimal(splitExpo[1]);

                    answer = left*Math.pow(10, (int)expo);
                }else{
                    String[] splitDot = splitFirstSetNumber[0].split("\\.");
                    System.out.println("Split dot " + splitDot[0]);
                    double left = baseMap.convertToDecimal(splitDot[0]);
                    double right = baseMap.convertToDecimal(splitDot[1]);
                    //System.out.println("left " + left);
                    //System.out.println("right " + right);
                    String[] splitExpo = splitFirstSetNumber[1].split("\\^");
                    double expo = baseMap.convertToDecimal(splitExpo[1]);
                    //System.out.println("expo " + expo);
                    String combine = (int)left+"."+(int)right;
                   // System.out.println("Combine " + combine);
                    double ans = Double.parseDouble(combine);
                   // System.out.println("Ans " + ans);
                    answer = ans*Math.pow(10, (int)expo);
                }
            }else{
                answer = 0;
            }
        }else{
            answer = 0;
        }
        return answer+"";
    }

    @Override
    public String convertOutput() {
            if(userInput.compareTo("0.0") != 0){
                if(userInput.compareTo("0") != 0){
                    double convertResult = Double.parseDouble(userInput);

                    double n = Math.floor(Math.log10(convertResult));
                    double man = convertResult * Math.pow(10, -n);
                    String manString = Double.toString(man);
                    
                    //System.out.println("Man String " + manString.format("%.2f", Double.parseDouble(manString)));
                    manString = manString.format("%.2f", Double.parseDouble(manString));
                    //String splitDot[] = userInput.split("\\.");
                    String splitDot[] = manString.split("\\.");
                    String leftSide = baseMap.convertBaseOutput(splitDot[0]);
                    //System.out.println("Split Dot 1 " + splitDot[1]);
                    String rightSide = baseMap.convertBaseOutput(splitDot[1]);
                    return leftSide+"."+rightSide+"*"+"10"+"^"+(int)n;
                    //return man+"*"+"10"+"^"+(int)n;
                }else{
                    return 0+"*10^1";
                }
            }else{
                return 0+"*10^1";
            }
    }
    
}
