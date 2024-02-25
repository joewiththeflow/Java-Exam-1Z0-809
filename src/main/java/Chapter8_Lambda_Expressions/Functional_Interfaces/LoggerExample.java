package Chapter8_Lambda_Expressions.Functional_Interfaces;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggerExample {

    public static void main(String[] args) {
        Logger logger = Logger.getLogger("Status logger");
        logger.setLevel(Level.SEVERE);

        // Later...
        String currentStatus = "Everything's okay";
        logger.log(Level.INFO, currentStatus);          // You won't see this message as the logger level is at SEVERE

        currentStatus = "Something's horribly wrong!";
        logger.log(Level.SEVERE, currentStatus);        // We will see this message as the logger level is at SEVERE
    }

}
