package by.epam.example;

import java.util.concurrent.Semaphore;

/**
 * Created by Olga Shahray on 13.07.2016.
 */
public class Worker implements Runnable{

    private Semaphore semaphore;
    private String workerName;
    private Cart cart;
    private boolean isAdder;

    public Worker(Semaphore semaphore, String workerName, Cart cart, boolean isAdder) {
        this.semaphore = semaphore;
        this.workerName = workerName;
        this.cart = cart;
        this.isAdder = isAdder;
    }

    @Override
    public void run() {
        System.out.println(workerName + " started working...");
        try {
            System.out.println(workerName + " waiting for cart...");
            //запрашиваем разрешение у семафора
            semaphore.acquire();
            System.out.println(workerName + " got access to cart...");
            for (int i = 0 ; i < 10 ; i++) {
                if (!isAdder && cart.getWeight().get()>0) {
                    cart.reduceWeight();
                }
                else if(!isAdder){
                    semaphore.release();
                }
                else {
                    cart.addWeight();
                }
                System.out.println(workerName + " changed weight to: " + cart.getWeight());
                Thread.sleep(10L);
            }
            System.out.println(workerName + " finished working with cart...");
        } catch (Exception e) {
            e.printStackTrace(System.err);
        } finally {
            //возвращаем разрешение после выполнения лействий с ресурсом
            semaphore.release();
        }
    }
}
