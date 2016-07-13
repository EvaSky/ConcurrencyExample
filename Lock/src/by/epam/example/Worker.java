package by.epam.example;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Olga Shahray on 13.07.2016.
 */
public class Worker implements Runnable {

    protected Lock lock = new ReentrantLock();

    public Worker(Lock lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        if (lock.tryLock()){
            try{
                ifLockIsFree();
            }
            finally
            {
                lock.unlock();
            }
        }
        else{
            ifLockIsBusy();
        }
    }

    public void ifLockIsFree() {
    }

    public void ifLockIsBusy() {
    }


}
