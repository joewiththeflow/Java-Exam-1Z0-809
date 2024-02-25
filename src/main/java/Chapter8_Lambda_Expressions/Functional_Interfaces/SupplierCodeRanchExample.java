package Chapter8_Lambda_Expressions.Functional_Interfaces;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

// I think the idea behind this example is to show how the Logger class has a variation of the log method which can take
// a Supplier<Sting>. If this version of log() is used then the Supplier's get() method is only called if the message
// level matches the logging level - allowing a potentially expensive operation such as network call only to be made
// if the message matches the SEVERE level in this example
public class SupplierCodeRanchExample {
    public static void main(String[] args) {
        String host = "coderanch.com";
        int port = 80;

        // Set up logging
        Logger logger = Logger.getLogger("Status Logger");
        logger.setLevel(Level.SEVERE);                              // set log level to SEVERE

        // In case we need to check the status
        Supplier<String> status = () -> {
            int timeout = 1000;
            try (Socket socket = new Socket()) {
                socket.connect(new InetSocketAddress(host, port), timeout);
                return "up";
            } catch (IOException e) {
                return "down";
            }
        };

        try {
            logger.log(Level.INFO, status);         // only calls the get() method of the status Supplier if level is
                                                    // INFO or below - status.get() expensive call not made as logging
                                                    // level is set o SEVERE
            // do stuff with coderanch.com

            throw new IOException();                // Just to test what happens
                                                    // the exception will be caught and then the call made.
                                                    // I don't have a network issue so it will return "up", therefore
                                                    // the issue isn't with this network call etc.

        } catch (Exception e) {
            logger.log(Level.SEVERE, status);       // calls the get() method of the status Supplier if level is SEVERE
                                                    // or below - status.get() called when an Exception occurs as
                                                    // logging level set to SEVERE and this message is logged as SEVERE
        }
    }
}

//