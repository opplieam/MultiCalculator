/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package multicalculatorp2;

/**
 *
 * @author Opponent
 */
public class HelpHandle implements GeneralCommand{

    @Override
    public void handle() {
        System.out.println("Command \t Description");
        System.out.println("op<Number> \t Store an operand");
        System.out.println("+ \t \t Sum the last to operand");
        System.out.println("- \t \t Subtract the last to operand");
        System.out.println("* \t \t Multiply the last to operand");
        System.out.println("/ \t \t Divide the last to operand");
        System.out.println("fixed \t \t Switch to fixed-point format");
        System.out.println("float \t \t Switch to floating-point format");
        System.out.println("rat \t \t Switch to rational format");
        System.out.println("dec \t \t Switch to base 10");
        System.out.println("bin \t \t Switch to binary base");
        System.out.println("hex \t \t Switch to hexadecimal base");
        System.out.println("help \t \t Print the list of commands");
        System.out.println("exit \t \t Terminate the execution");
    }
    
}
