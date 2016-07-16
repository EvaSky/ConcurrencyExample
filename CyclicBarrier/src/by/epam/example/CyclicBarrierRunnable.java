package by.epam.example;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by Olga Shahray on 13.07.2016.
 */
public class CyclicBarrierRunnable implements Runnable {

    CyclicBarrier barrier1;
    CyclicBarrier barrier2;

    public CyclicBarrierRunnable(CyclicBarrier barrier1, CyclicBarrier barrier2) {

        //задаем 2 барьера, через которые должен пройти поток
        this.barrier1 = barrier1;
        this.barrier2 = barrier2;
    }

    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " waiting at barrier 1");
            this.barrier1.await();//ждем прохождения барьера 1

            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " waiting at barrier 2");
            this.barrier2.await(); //ждем прохождения барьера 2

            System.out.println(Thread.currentThread().getName() + " done!");

        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
