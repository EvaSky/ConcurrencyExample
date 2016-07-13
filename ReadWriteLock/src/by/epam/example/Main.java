package by.epam.example;

/**
 * Created by Olga Shahray on 13.07.2016.
 *
 * ReadWriteLock-
 * часто используется в многопоточных сервисах и кешах, показывая очень хороший прирост производительности по сравнению
 * с блоками synchronized. Такие локи необычайно полезны, когда в системе много операций чтения и мало операций записи.
 *
 * Данный пример описывает ситуацию, когда есть разделяемый ресурс - класс Dictionary, а также потоки чтения и записи
 * (Reader-ы и Writer)
 *
 * */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        Dictionary dictionary = new Dictionary();
        dictionary.set("java", "object oriented");
        dictionary.set("linux", "rulez");

        //Создаем 1 поток на запись и несколько на чтение
        Writer writer = new Writer(dictionary, "Mr. Writer");
        Reader reader1 = new Reader(dictionary, "Mr. Reader 1");
        Reader reader2 = new Reader(dictionary, "Mr. Reader 2");
        Reader reader3 = new Reader(dictionary, "Mr. Reader 3");

        writer.start();
        reader1.start();
        reader2.start();
        reader3.start();

        Thread.sleep(2000);
        writer.stopWriter();
        reader1.stopReader();
        reader2.stopReader();
        reader3.stopReader();
    }
}
