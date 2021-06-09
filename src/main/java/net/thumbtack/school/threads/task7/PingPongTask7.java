package net.thumbtack.school.threads.task7;

public class PingPongTask7 {

    private boolean valueSet = true;

    synchronized void ping() {
        while (!valueSet)
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("InterruptedException caught");
            }

        System.out.println("Ping");
        valueSet = false;
        notify();
    }

    synchronized void pong() {
        while (valueSet)
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("InterruptedException caught");
            }

        valueSet = true;
        System.out.println("Pong");
        notify();
    }

}
