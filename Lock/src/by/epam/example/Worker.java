package by.epam.example;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Olga Shahray on 13.07.2016.
 *
 * В отличие от syncronized блокировок, ReentrantLock позволяет более гибко выбирать моменты снятия и получения блокировки
 * т.к. использует обычные Java вызовы. Также ReentrantLock позволяет получить информацию о текущем состоянии блокировки,
 * разрешает «ожидать» блокировку в течение определенного времени. Поддерживает правильное рекурсивное получение и освобождение
 * блокировки для одного потока. Если вам необходимы честные блокировки (соблюдающие очередность при захвате монитора) —
 * ReentrantLock также снабжен этим механизмом.
 *
 * Классическая ситуация - доступ потока к разделяемому ресурсу
 *
 */
public class Worker implements Runnable {

    private Resource resource;
    private Lock lock;

    public Worker(Resource r){
        this.resource = r;
        this.lock = new ReentrantLock();
    }

    @Override
    public void run() {
        try {
            //пытаемся заблокировать объект в теч.10 секунд
            if(lock.tryLock(10, TimeUnit.SECONDS)){

                //если успешно заблокировали - выполняем операцию
                resource.doSomething();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally{
            //освобождаем лок
            lock.unlock();
        }
        resource.doLogging();
    }

}
