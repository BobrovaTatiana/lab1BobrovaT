package com.company;

/**
 * Created by Tanusha on 12/02/2017.
 */
public class Consumer {
    private int next;
    static volatile int summ;
    static volatile boolean err = false;

    synchronized void msg(int next, boolean error) {
        summ += next;
        if (error) err = true; notifyAll();
        System.out.println("сумма: " + summ);
    }
}
