package by.epam.example;

/**
 * Created by Olga Shahray on 13.07.2016.
 *
 * Writer-
 * поток, изменяющий записи в словаре
 */

public class Writer extends Thread {

    private boolean isStopped;
    private Dictionary dictionary;

    public Writer(Dictionary d, String threadName) {
        this.dictionary = d;
        this.setName(threadName);
    }

    @Override
    public void run() {

        while (!isStopped) {
            String[] keys = dictionary.getKeys();
            for (String key : keys) {
                String newValue = getNewValueFromDatastore(key);
                //обновляем запись в словаре с использованием лока на запись
                dictionary.set(key, newValue);
            }

            //изменения будут происходить каждую секунду
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stopWriter() {
        isStopped = true;
    }

    public String getNewValueFromDatastore(String key) {
        //симулирование добаления записи. Метод может быть реализован в соответствии с требованиями конкретной здачи
        return "newValue";
    }
}
