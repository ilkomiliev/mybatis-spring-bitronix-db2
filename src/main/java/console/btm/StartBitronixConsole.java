package console.btm;

import bitronix.tm.gui.Console;

import javax.swing.*;
import java.io.IOException;

/**
 * Created by ILIEVI on 16.10.2015.
 */
public class StartBitronixConsole {

    private static final String BITRONIX_CONFIG_FULL_FILENAME = "";

    public static void main(String[] args) throws Exception {
        System.setProperty("bitronix.tm.configuration", BITRONIX_CONFIG_FULL_FILENAME);
        try {
            new Console();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }
}
