package com.company;

/**
 * Created by Tanusha on 12/02/2017.
 */
public class Summator implements Runnable {

    private String dataFile;
    private Consumer consumer;
    private boolean error = false;

    public Summator(String dataFile, Consumer consumer) {
        this.dataFile = dataFile;
        this.consumer = consumer;
    }

    @Override
    public void run() {
        try {
            String[] arrrayOfString = dataFile.trim().split(" ");
            for (String element : arrrayOfString) {
                //if (element != ""){
                int yourInteger = Integer.parseInt(element);
                if (yourInteger % 2 == 0 && yourInteger > 0) {
                    consumer.msg(yourInteger, error);
                }
                //}
            }
        } catch (NumberFormatException nfe) {
            //nfe.printStackTrace();
            System.out.println("Недопустимые символы в файле");
            error = true;
            consumer.msg(0, error);
        }
    }
}
