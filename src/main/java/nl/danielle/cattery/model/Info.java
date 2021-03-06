package nl.danielle.cattery.model;

import java.io.File;
import java.util.Scanner;

public class Info {

    private static final String FILENAMEUSER = "/Users/intoy/Novi/Backend_eindopdracht/cattery/cattery/src/main/resources/user.json";
    private static final String FILENAMEBACKOFFICE = "/Users/intoy/Novi/Backend_eindopdracht/cattery/cattery/src/main/resources/backoffice.json";

    public static String getInfoUser() {
        try {
            File file = new File(FILENAMEUSER);
            Scanner sc = new Scanner(file);

            StringBuilder sb = new StringBuilder();
            while (sc.hasNextLine()) {
                sb.append(sc.nextLine()).append(System.lineSeparator());
            }
            return sb.toString();
        } catch (Exception ex) {
            return ex.toString();
        }
    }

    public static String getInfoBackoffice() {
        try {
            File file = new File(FILENAMEBACKOFFICE);
            Scanner sc = new Scanner(file);

            StringBuilder sb = new StringBuilder();
            while (sc.hasNextLine()) {
                sb.append(sc.nextLine()).append(System.lineSeparator());
            }
            return sb.toString();
        } catch (Exception ex) {
            return ex.toString();
        }
    }
}
