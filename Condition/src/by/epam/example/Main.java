package by.epam.example;

/**
 * Created by Olga Shahray on 13.07.2016.
 */
public class Main {

    public static void main(String[] args) {
        SharedFifoQueue sharedQueue = new SharedFifoQueue(10);

        //Create a producer and a consumer.
        Thread producer = new Producer(sharedQueue);
        Thread consumer = new Consumer(sharedQueue);

        //Start both threads.
        producer.start();
        consumer.start();

        //Wait for both threads to terminate.
        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
