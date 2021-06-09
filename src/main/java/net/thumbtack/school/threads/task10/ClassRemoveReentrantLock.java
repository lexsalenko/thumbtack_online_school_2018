package net.thumbtack.school.threads.task10;

import java.util.List;
import java.util.concurrent.locks.Lock;

public class ClassRemoveReentrantLock extends Thread {

    private List<Integer> list;
    private Lock lock;

    public ClassRemoveReentrantLock(Lock lock, List<Integer> list) {
        this.lock = lock;
        this.list = list;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            lock.lock();
            int number = (int) (0 + (Math.random() * list.size() - 1));
            list.remove(number);
            System.out.println("Remove: " + number);
            lock.unlock();
        }
    }

}
