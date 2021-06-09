package net.thumbtack.school.threads.task5;

import net.thumbtack.school.threads.MyList;
import net.thumbtack.school.threads.AddRemoveOperation;

public class ClassAddAndRemove extends Thread {

    private MyList myList;
    private AddRemoveOperation addRemoveOperation;

    public ClassAddAndRemove(MyList myList, AddRemoveOperation addRemoveOperation) {
        this.myList = myList;
        this.addRemoveOperation = addRemoveOperation;
    }

    public void run() {
        if (addRemoveOperation.getOperation().equals("Add")) {
            int number = (int) (0 + (Math.random() * 9));

            for (int i = 0; i < 10; i++) {
                synchronized (myList) {
                    myList.add(number);
                }
            }
        }
        if (addRemoveOperation.getOperation().equals("Remove")) {
            for (int i = 0; i < 10; i++) {
                synchronized (myList) {
                    int index = (int) (0 + (Math.random() * (myList.getList().size() - 1)));
                    myList.remove(index);
                }
            }
        }
    }


}
