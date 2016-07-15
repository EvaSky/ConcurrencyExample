package by.epam.example;

import java.util.concurrent.Exchanger;

/**
 * Created by Olga Shahray on 13.07.2016.
 *
 * Exchanger (обменник) может понадобиться, для того, чтобы обменяться данными между двумя потоками в определенной точки
 * работы обоих потоков. Обменник — обобщенный класс, он параметризируется типом объекта для передачи.
 *
 * Пример: 2 потока меняются объектами А и В
 *
 */
public class Main {

    public static void main(String[] args) {

        Exchanger exchanger = new Exchanger();

        ExchangerRunnable exchangerRunnable1 =
                new ExchangerRunnable(exchanger, "A");

        ExchangerRunnable exchangerRunnable2 =
                new ExchangerRunnable(exchanger, "B");

        new Thread(exchangerRunnable1).start();
        new Thread(exchangerRunnable2).start();
    }
}
