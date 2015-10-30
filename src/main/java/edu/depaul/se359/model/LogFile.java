package edu.depaul.se359.model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class LogFile {
    private static LogFile ourInstance = new LogFile();

    private LogFile() {
        // create folder if it doesn't exist
        File folder = new File("./Report");
        if (!folder.exists()) {
            folder.mkdir();
        }
    }

    public static LogFile getInstance() {
        return ourInstance;
    }

    public void writeLogFile(Level logLevel, String report) {
        Logger.getLogger("LogFile").log(logLevel, report);

        // append to file

        try {
            FileWriter fw = new FileWriter("Report/report.log", true);
            fw.write("[" + logLevel + "] " + report + "\n");
            fw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
