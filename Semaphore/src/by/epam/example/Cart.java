package by.epam.example;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Olga Shahray on 13.07.2016.
 */
public class Cart {

    private AtomicInteger weight = new AtomicInteger(0);

    public void addWeight(){
        weight.addAndGet(1);
    }

    public void reduceWeight(){
        weight.decrementAndGet();
    }

    public AtomicInteger getWeight(){
        return weight;
    }
}
