package net.thumbtack.school.threads.task10;

import java.util.List;
import java.util.concurrent.locks.Lock;

public class ClassAddReentrantLock extends Thread {

    private List<Integer> list;
    private Lock lock;

    public ClassAddReentrantLock(Lock lock, List<Integer> list) {
        this.lock = lock;
        this.list = list;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            lock.lock();
            int number = (int) (0 + (Math.random() * 9));
            list.add(number);
            System.out.println("Add: " + number);
            lock.unlock();
        }
    }


}
