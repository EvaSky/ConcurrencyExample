package by.epam.example;

import java.util.concurrent.Semaphore;

/**
 * Created by Olga Shahray on 13.07.2016.
 */
public class Main {

    public static void main(String[] args) {
        //создаем семафор с указанием количества разрешений. Т.е. к ресурсу одновременно будет иметь доступ 1 поток
        Semaphore semaphore = new Semaphore(1);
        Cart cart = new Cart();

        Thread thread1 = new Thread(new Worker(semaphore, "Adder", cart, true));
        thread1.start();
        Thread thread2 = new Thread(new Worker(semaphore, "Reducer", cart, false));
        thread2.start();
    }

}
