package com.company;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

/**
 * Created by Tanusha on 12/02/2017.
 */
public class Summator implements Runnable {
    public  static final Logger logger = Logger.getLogger(Main.class);
    static{
        DOMConfigurator.configure("src/log.xml");
    }


    private String dataFile;
    private Consumer consumer;
    private volatile boolean error = false;
    private String path;

    public Summator(String path, String dataFile, Consumer consumer) {
        this.dataFile = dataFile;
        this.consumer = consumer;
        this.path = path;
    }

    @Override
    public void run() {
        try {
            String[] arrrayOfString = dataFile.trim().split(" ");
            for (String element : arrrayOfString) {
                //if (element !7= ""){
                if (consumer.err == false) {
                    int yourInteger = Integer.parseInt(element);
                    if (yourInteger % 2 == 0 && yourInteger > 0) {
                        consumer.msg(yourInteger, error);
                        Thread.sleep(500);
                }

                }
                //}
            }
        } catch (NumberFormatException nfe) {
            logger.error("Invalid characters in the file " + path);
            error = true;
            consumer.msg(0, error);
        } catch (InterruptedException e) {
            logger.error("Interrupted exceptoin " + e.getMessage().toString());
        }
    }
}
