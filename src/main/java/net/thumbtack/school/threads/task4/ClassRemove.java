package net.thumbtack.school.threads.task4;

import net.thumbtack.school.threads.MyList;

public class ClassRemove extends Thread {

    private MyList myList;

    public ClassRemove(MyList myList) {
        this.myList = myList;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            synchronized (myList) {
                int index = (int) (0 + (Math.random() * (myList.getList().size() - 1)));
                myList.remove(index);
            }
        }
    }

}
