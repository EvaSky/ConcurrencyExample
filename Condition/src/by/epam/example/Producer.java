package by.epam.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Olga Shahray on 13.07.2016.
 */
public class Producer extends Thread {

    private final static String FILENAME = "d:/JavaEE/Projects/ConcurrencyExample/Condition/src/by/epam/example/resources/input.txt";
    private final SharedFifoQueue queue;

    public Producer(SharedFifoQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        BufferedReader rd = null;

        try {
            rd = new BufferedReader(new FileReader(FILENAME));

            String inputLine = null;
            while((inputLine = rd.readLine()) != null) {
                String[] inputWords = inputLine.split(" ");

                for(String inputWord: inputWords)
                    queue.add(inputWord);
            }

            //Terminate the execution.
            queue.add(null);
        }
        catch (InterruptedException ex) {
            System.err.println("An InterruptedException was caught: " + ex.getMessage());
            ex.printStackTrace();
        }
        catch (IOException ex) {
            System.err.println("An IOException was caught: " + ex.getMessage());
            ex.printStackTrace();
        }
        finally {
            try {
                if(rd != null)
                    rd.close();
            }
            catch (IOException ex) {
                System.err.println("An IOException was caught: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }
}
