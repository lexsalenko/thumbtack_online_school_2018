package net.thumbtack.school.threads.task11;

import net.thumbtack.school.threads.PingPongOperation;

import java.util.concurrent.locks.Lock;

public class PingPongTask11 extends Thread {

    private Lock lock;
    private PingPongOperation pingPongOperation;

    public PingPongTask11(Lock lock, PingPongOperation pingPongOperation) {
        this.lock = lock;
        this.pingPongOperation = pingPongOperation;
    }

    public void run() {
        if (pingPongOperation.getOperation().equals("Ping")) {
            int i = 0;
            while (i < 10) {
                lock.lock();
                System.out.println("Ping");
                i++;
                lock.unlock();
            }
        }
        if (pingPongOperation.getOperation().equals("Pong")) {
            int i = 0;
            while (i < 10) {
                lock.lock();
                System.out.println("Pong");
                i++;
                lock.unlock();
            }
        }
    }
}

