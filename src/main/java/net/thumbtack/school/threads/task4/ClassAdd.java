package net.thumbtack.school.threads.task4;

import net.thumbtack.school.threads.MyList;

public class ClassAdd extends Thread {
    private MyList myList;

    public ClassAdd(MyList myList) {
        this.myList = myList;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            int number = (int) (0 + (Math.random() * 9));
            synchronized (myList) {
                myList.add(number);
            }
        }
    }
}

