package by.epam.example;

import java.util.concurrent.Phaser;

/**
 * Created by Olga Shahray on 13.07.2016.
 */
public class Main {

    public static void main(String[] args) {
        Phaser phaser = new Phaser(1);
        new Thread(new PhaserRunnable(phaser, "PhaserThread 1")).start();
        new Thread(new PhaserRunnable(phaser, "PhaserThread 2")).start();

        // ждем завершения фазы 0
        int phase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Фаза " + phase + " завершена");

        // ждем завершения фазы 1
        phase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Фаза " + phase + " завершена");

        // ждем завершения фазы 2
        phase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Фаза " + phase + " завершена");

        phaser.arriveAndDeregister();
    }
}
