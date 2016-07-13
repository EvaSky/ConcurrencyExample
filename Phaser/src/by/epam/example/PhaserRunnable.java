package by.epam.example;

import java.util.concurrent.Phaser;

/**
 * Created by Olga Shahray on 13.07.2016.
 */
public class PhaserRunnable implements Runnable {

    Phaser phaser;
    String name;

    PhaserRunnable(Phaser p, String n){

        this.phaser=p;
        this.name=n;
        phaser.register();
    }

    @Override
    public void run(){

        System.out.println(name + " выполняет фазу " + phaser.getPhase());
        phaser.arriveAndAwaitAdvance(); // сообщаем, что первая фаза достигнута

        System.out.println(name + " выполняет фазу " + phaser.getPhase());
        phaser.arriveAndAwaitAdvance(); // сообщаем, что вторая фаза достигнута

        System.out.println(name + " выполняет фазу " + phaser.getPhase());
        phaser.arriveAndDeregister(); // сообщаем о завершении фаз и удаляем с регистрации объекты
    }
}
