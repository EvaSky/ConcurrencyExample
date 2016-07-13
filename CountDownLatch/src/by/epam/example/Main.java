package by.epam.example;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Olga Shahray on 13.07.2016.
 *
 * *CountDownLatch (замок с обратным отсчетом) предоставляет возможность любому количеству потоков в блоке кода ожидать
 * до тех пор, пока не завершится определенное количество операций, выполняющихся в других потоках, перед тем как они
 * будут «отпущены», чтобы продолжить свою деятельность. В конструктор CountDownLatch (CountDownLatch(int count))
 * обязательно передается количество операций, которое должно быть выполнено, чтобы замок «отпустил» заблокированные потоки.
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(4);

        new Thread(new Worker(latch,"Sand")).start();
        new Thread(new Worker(latch,"Cement")).start();
        new Thread(new Worker(latch,"Water")).start();
        new Thread(new Worker(latch,"Breakstone")).start();

        System.out.println("Waiting for all workers");
        //дожидаемся пока сработает счетчик 4 раза
        latch.await();
        System.out.println("All workers finished. Now we can shake.");
    }
}
