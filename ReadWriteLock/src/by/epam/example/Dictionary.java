package by.epam.example;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by Olga Shahray on 13.07.2016.
 */
/** Dictionary-
 * разделяемый ресурс *
 **/
public class Dictionary {

    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    private final Lock read = readWriteLock.readLock();//получаем отдельный лок для чтения

    private final Lock write = readWriteLock.writeLock();//и для записи

    private Map<String, String> dictionary = new HashMap<>();

    //операция записи. Используется лок для записи
    public void set(String key, String value) {
        write.lock();
        try {
            dictionary.put(key, value);
        } finally {
            write.unlock();
        }
    }

    //операция чтения поля по ключу. Используется лок для чтения
    public String get(String key) {
        read.lock();
        try {
            return dictionary.get(key);
        } finally {
            read.unlock();
        }
    }

    //операция чтения ключей. Используется лок для чтения
    public String[] getKeys() {
        read.lock();
        try {
            String keys[] = new String[dictionary.size()];
            return dictionary.keySet().toArray(keys);
        } finally {
            read.unlock();
        }
    }
}
