package by.epam.example;

import java.util.concurrent.CyclicBarrier;

/**
 * Created by Olga Shahray on 13.07.2016.
 *
 * CyclicBarrier реализует шаблон синхронизации Барьер. Циклический барьер является точкой синхронизации, в которой
 * указанное количество параллельных потоков встречается и блокируется. Как только все потоки прибыли, выполняется
 * опционное действие (или не выполняется, если барьер был инициализирован без него), и, после того, как оно выполнено,
 * барьер ломается и ожидающие потоки «освобождаются». В конструктор барьера (CyclicBarrier(int parties) и
 * CyclicBarrier(int parties, Runnable barrierAction)) обязательно передается количество сторон, которые должны
 * «встретиться», и, опционально, действие, которое должно произойти, когда стороны встретились, но перед тем когда они
 * будут «отпущены».
 *
 * Пример: 2 потока проходят через 2 барьера
 */
public class Main {

    public static void main(String[] args) {

        //задаем 2 опциональных действия, которые должны быть выполнены после того как все потоки встретились
        //но перед тем как барьер будет сломлен
        Runnable barrier1Action = () -> System.out.println("BarrierAction 1 executed ");
        Runnable barrier2Action = () -> System.out.println("BarrierAction 2 executed ");

        CyclicBarrier barrier1 = new CyclicBarrier(2, barrier1Action);
        CyclicBarrier barrier2 = new CyclicBarrier(2, barrier2Action);

        CyclicBarrierRunnable barrierRunnable1 = new CyclicBarrierRunnable(barrier1, barrier2);

        CyclicBarrierRunnable barrierRunnable2 = new CyclicBarrierRunnable(barrier1, barrier2);

        new Thread(barrierRunnable1).start();
        new Thread(barrierRunnable2).start();
    }
}
