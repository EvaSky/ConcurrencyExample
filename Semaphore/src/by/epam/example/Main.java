package by.epam.example;

import java.util.concurrent.Semaphore;

/**
 * Created by Olga Shahray on 13.07.2016.
 *
 * Синхронизатор Semaphore реализует шаблон синхронизации Семафор. Чаще всего, семафоры необходимы, когда нужно ограничить
 * доступ к некоторому общему ресурсу. В конструктор этого класса (Semaphore(int permits) или
 * Semaphore(int permits, boolean fair)) обязательно передается количество потоков, которому семафор будет разрешать
 * одновременно использовать заданный ресурс.
 *
 * Задача описывает ситуацию, когда двое рабочик (потока) имеют доступ к 1 тележке (ресурсу). 1 работник наполняет
 * тележку, другой разгружает. Одновременно с тележкой может работать только 1 рабочий.
 *
 */
public class Main {

    public static void main(String[] args) {
        //создаем семафор с указанием количества разрешений. Т.е. к ресурсу одновременно будет иметь доступ 1 поток
        Semaphore semaphore = new Semaphore(1);
        Cart cart = new Cart();

        Thread thread1 = new Thread(new Worker(semaphore, "Adder", cart, true));
        Thread thread2 = new Thread(new Worker(semaphore, "Reducer", cart, false));
        thread1.start();
        thread2.start();
    }

}
