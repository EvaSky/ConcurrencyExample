package by.epam.example;

/**
 * Created by Olga Shahray on 13.07.2016.
 *
 * Reader-
 * поток, читающий записи в словаре
 */
public class Reader extends Thread {

    private Dictionary dictionary;
    private boolean isStopped;

    public Reader(Dictionary d, String threadName) {
        this.dictionary = d;
        this.setName(threadName);
    }

    @Override
    public void run() {

        while (!isStopped) {
            String[] keys = dictionary.getKeys();

            for (String key : keys) {
                //чтение из словаря с использованием READ LOCK
                String value = dictionary.get(key);

                System.out.println(this.getName()+ " " + key + " : " + value);
            }

            //обновление каждую секунду
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stopReader() {
        isStopped = true;
    }
}
