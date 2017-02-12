package com.company;

/**
 * Created by Tanusha on 12/02/2017.
 */
public class Consumer {
    private int next;
    static int summ;
    static boolean err = false;

    synchronized void msg(int next, boolean error) {
        summ += next;
        if (error) err = true;
        if (err == false) {
            System.out.println("сумма: " + summ);
        }
        //else System.out.println(err);

    }
}
