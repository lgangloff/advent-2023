package org.advent;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.function.Consumer;

public class Utils {

    public static boolean DEBUG = false;

    public static void start(String project, String file, Consumer<String> consumer) throws FileNotFoundException, IOException{
        LocalDateTime startAt  = LocalDateTime.now();
        try (BufferedReader br = new BufferedReader(new FileReader(project+"/src/main/resources/" + file))) {
            String line = br.readLine();
            
            while (line != null) {
                consumer.accept(line);
                line = br.readLine();
            }
        }
        LocalDateTime endAt = LocalDateTime.now();

        System.out.println(String.format("Reading file %s in %d ms.", file, ChronoUnit.MILLIS.between(startAt, endAt)));
    }

    public static void main(MainApp app) throws Exception {        
        LocalDateTime startAt  = LocalDateTime.now();

        app.run();

        LocalDateTime endAt = LocalDateTime.now();

        System.out.println(String.format("End in %d ms.", ChronoUnit.MILLIS.between(startAt, endAt)));
    }


    public static void debug(Object object){
        if (DEBUG)
            System.out.println(object);
    }


}
