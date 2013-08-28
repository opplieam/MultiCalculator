/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package multicalculatorp2;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

/**
 *
 * @author Opponent
 */
public class TUI implements Observer{
    //Scanner
    private Scanner sc;
    //User Input
    private String userInput;
    //Format and Base
    private String currentFormat = "fixed";
    private String currentBase = "dec";
    //Map
    private Map<String,GeneralCommand> generalCommandMap;
    private Map<String,Format> formatMap;
    private Map<String,Base> baseMap;
    private Map<String,Calculation> operationMap;
    // Operand Handle
    private OperandHandle opHandle;
    // Format
    private Format input;
    // Controller
    public TUI(){
        sc = new Scanner(System.in);
        initStrucure();
    }
    
    private void initStrucure(){
        // instanitiate 
        opHandle = new OperandHandle();
        GeneralCommand exit = new ExitHandle();
        GeneralCommand help = new HelpHandle();
        Format fixed = new FormatFixed();
        Format floating = new FormatFloat();
        Format rat = new FormatRat();
        Base dec = new BaseDecimal();
        Base hexa = new BaseHexadecimal();
        Base bin = new BaseBinary();
        Calculation plus = new CalculationPlus();
        Calculation minus = new CalculationSubtract();
        Calculation multiply = new CalculationMultiply();
        Calculation divide = new CalculationDivide();
        // add observer
        fixed.addObserver(this);
        floating.addObserver(this);
        rat.addObserver(this);
        dec.addObserver(this);
        hexa.addObserver(this);
        bin.addObserver(this);
        plus.addObserver(this);
        minus.addObserver(this);
        multiply.addObserver(this);
        divide.addObserver(this);
        // containing a general command
        generalCommandMap = new HashMap<>();
        generalCommandMap.put("help", help);
        generalCommandMap.put("exit",exit);
        // containing a format
        formatMap = new HashMap<>();
        formatMap.put("fixed", fixed);
        formatMap.put("float", floating);
        formatMap.put("rat", rat);
        // containing a base
        baseMap = new HashMap<>();
        baseMap.put("bin", bin);
        baseMap.put("hex", hexa);
        baseMap.put("dec", dec);
        // containing an operation
        operationMap = new HashMap<>();
        operationMap.put("+", plus);
        operationMap.put("-", minus);
        operationMap.put("*", multiply);
        operationMap.put("/", divide);
    }
    
    public void startTUI(){ 
        System.out.println(" ------- Welcome to Multi-format Calculator ------- ");
        System.out.println("Please type \"help\", to see the avaliable command");
        System.out.println("\"exit\", to terminate a program");
        System.out.println("Default format of program is fixed point");
        System.out.println("Default base of program is decimal");
        System.out.println(" ------------------------------------------ ");
        
        while(true){
            System.out.print("> ");
            userInput = sc.nextLine();
            input = formatMap.get(currentFormat);
            input.setBaseMap(baseMap.get(currentBase));
            if(generalCommandMap.containsKey(userInput)){
                // Help and exit command
                generalCommandMap.get(userInput).handle();
            }else if(formatMap.containsKey(userInput)){
                // format command
                input.setUserInput(opHandle.operand1);
                opHandle.operand1 = input.convertInput();
                input.setUserInput(opHandle.operand2);
                opHandle.operand2 = input.convertInput();
                formatMap.get(userInput).setCurrentFormat();
            }else if(baseMap.containsKey(userInput)){
                // base command
                input.setUserInput(opHandle.operand1);
                opHandle.operand1 = input.convertInput();
                input.setUserInput(opHandle.operand2);
                opHandle.operand2 = input.convertInput();
                baseMap.get(userInput).setCurrentBase();
            }else if(userInput.matches("op\\s.*")){
                // operand handle
                String subUserInput = userInput.substring(3);
                // Check match the format
                if(!formatMap.get(currentFormat).isFormat(subUserInput)){
                    System.out.println("Your input "+ subUserInput +" is not match with "+currentFormat + " format, please try gain");
                }else{
                    input.setUserInput(subUserInput);
                    try{
                        opHandle.storeOperand(input.convertInput());
                    }catch(NumberFormatException e1){
                        System.out.println("Number format Exception");
                    }
                }
            }else if(operationMap.containsKey(userInput)){
                // operation (+,-,*,/) handle
                input.setUserInput(opHandle.operand1);
                opHandle.operand1 = input.convertInput();
//                input.setUserInput(opHandle.operand2);
//                opHandle.operand2 = input.convertInput();
                Calculation calculate = operationMap.get(userInput);
                calculate.setVariable(opHandle.operand1, opHandle.operand2);
                calculate.calculate();
            }
        }
    }

  
    @Override
    public void update(Observable o, Object arg) {
        if(arg instanceof Format){
            Format format = (Format) arg;
            currentFormat = format.getCurrentFormat();
            System.out.println("The current format is " + currentFormat);
            input = formatMap.get(currentFormat);
            input.setBaseMap(baseMap.get(currentBase));
            input.setUserInput(opHandle.operand1);
            opHandle.operand1 = input.convertOutput();
            input.setUserInput(opHandle.operand2);
            opHandle.operand2 = input.convertOutput();
            System.out.println("Operand 1 : " + opHandle.operand1 );
            System.out.println("Operand 2 : " + opHandle.operand2 );
        }else if(arg instanceof Base){
            Base base = (Base) arg;
            currentBase = base.getCurrentBase();
            System.out.println("The current base is " + currentBase);
            input = formatMap.get(currentFormat);
            input.setBaseMap(baseMap.get(currentBase));
            input.setUserInput(opHandle.operand1);
            opHandle.operand1 = input.convertOutput();
            input.setUserInput(opHandle.operand2);
            opHandle.operand2 = input.convertOutput();
            System.out.println("Operand 1 : " + opHandle.operand1 );
            System.out.println("Operand 2 : " + opHandle.operand2 );
        }else if(arg instanceof Calculation){
            Calculation cal = (Calculation) arg;
            String result = cal.getResult();
            //System.out.println("Result "+result);
            //System.out.println("Result Afterround " + result.format("%.3g%n", Double.parseDouble(result)));
            input = formatMap.get(currentFormat);
            input.setUserInput(result.format("%.1f", Double.parseDouble(result)));
            //input.setUserInput(result);
            input.setBaseMap(baseMap.get(currentBase));
            result = input.convertOutput();
            //System.out.println("Result " + result);
            opHandle.operand2 = result;
            opHandle.operand1 = "0";
            System.out.println("Your result is "+opHandle.operand2);
            System.out.println("Operand 1 : " + opHandle.operand1);
            System.out.println("Operand 2 : " + opHandle.operand2);
        }
        
        
    }
    
    
    private class OperandHandle{
        private String operand1 = "0";
        private String operand2 = "0";
        
        public void storeOperand(String operandNow){
            operand1 = operand2;
            operand2 = operandNow;
        }
        
    }
    
   
    
    
}
