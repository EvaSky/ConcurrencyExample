package by.epam.example;

/**
 * Created by Olga Shahray on 13.07.2016.
 *
 * RandomGenerator-
 * класс для получения случайного времени засыпания потока
 *
 */
public class RandomGenerator {

    public static long getRandom(long min, long max) {
        return min + (long)(Math.random() * (max - min + 1));
    }
}
