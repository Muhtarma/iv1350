
package se.kth.iv1350.createpos.startup;

import se.kth.iv1350.createpos.controller.Controller;
import se.kth.iv1350.createpos.integration.Integration;
import se.kth.iv1350.createpos.integration.Printer;
import se.kth.iv1350.createpos.view.View;

/**
 * The Main class is the entry point of the application. It initializes the necessary components and starts the program.
 */

public class Main {
    public static void main (String[] args){
      Integration integration = new Integration();
      Printer printer = new Printer();
      Controller contr = new Controller(integration, printer, null);
      View view = new View (contr);

      view.newSaleExecution();
    }
    
}
