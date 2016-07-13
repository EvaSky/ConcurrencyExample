package by.epam.example;

import java.util.concurrent.Exchanger;

/**
 * Created by Olga Shahray on 13.07.2016.
 */
public class ExchangerRunnable implements Runnable {

    private Exchanger exchanger;
    private Object  object;

    public ExchangerRunnable(Exchanger exchanger, Object object) {
        this.exchanger = exchanger;
        this.object = object;
    }

    public void run() {
        try {
            Object previous = this.object;
            //позволяет потокам обменяться объектами
            this.object = this.exchanger.exchange(this.object);

            System.out.println(
                    Thread.currentThread().getName() +
                            " exchanged " + previous + " for " + this.object
            );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
