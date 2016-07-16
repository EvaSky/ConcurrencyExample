package by.epam.example;

/**
 * Created by Olga Shahray on 13.07.2016.
 *
 * Интерфейс Condition похож на wait-notify модель с рядом дополнительных функций. Объект Condition всегда создается
 * с помощью объекта Lock.  Метод await() очень похож на wait(), а методы signal(), signalAll() похожи
 * на notify() и notifyAll().
 *
 * Пример: Producer читает слова из файла и записывает из в разделяемую очередь. Consumer получает слова из очереди,
 * считает количество неповпоряющихся слов и выводит на консоль.
 */
public class Main {

    public static void main(String[] args) {
        SharedFifoQueue sharedQueue = new SharedFifoQueue(10);

        //Создаем producer и consumer.
        Thread producer = new Producer(sharedQueue);
        Thread consumer = new Consumer(sharedQueue);

        //Запускаем оба потока
        producer.start();
        consumer.start();

        //Дожидаемся окончания работы потоков
        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
