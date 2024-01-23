package util;

import java.io.File;

public class LogConnector {
    public static final String LOG_PATH = "logging.txt";
    public static void createLogFile() {
        try {
            File db = new File(LOG_PATH);
            if (db.createNewFile()) {
                System.out.println("Файл логирования создан.");
            }
            else {
                System.out.println("Файл логирования уже создан ранее.");
            }
        }
        catch (Exception e) {
            System.err.println(e);
        }
    }
}