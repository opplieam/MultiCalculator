/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package multicalculatorp2;

/**
 *
 * @author Opponent
 */
public class ExitHandle implements GeneralCommand{

    @Override
    public void handle() {
        System.out.println("Terminate application");
        System.exit(0);
    }
    
}
