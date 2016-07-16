package by.epam.example;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by Olga Shahray on 13.07.2016.
 *
 *Класс Worker эмулирует работу какого-либо рабочего процесса. Имя процесса передается в конструкторе
 */
public class Worker implements Runnable{

    private CountDownLatch countDownLatch;
    private String name;

    public Worker (CountDownLatch countDownLatch, String name) {
        this.countDownLatch = countDownLatch;
        this.name = name;
    }

    @Override
    public void run() {

        System.out.println(name + " working...");
        try {
            Thread.sleep(RandomGenerator.getRandom(500, 1000));
        } catch (InterruptedException e) {
            e.printStackTrace(System.err);
        }

        //после завершения действий потока уменьшаем счетчик countDownLatch
        countDownLatch.countDown();

        System.out.println(name + " finished");
    }
}
