package net.thumbtack.school.threads;

import java.util.List;

public class MyList {

    private List<Integer> list;

    public MyList(List<Integer> list) {
        this.list = list;
    }

    public void remove(int index) {
        if(list.size() != 0) {
            list.remove(index);
            System.out.println("Remove: " + index);
        }
    }

    public void add(int number) {
        list.add(number);
        System.out.println("Add: " + number);
    }

    public List<Integer> getList() {
        return list;
    }

    public void setList(List<Integer> list) {
        this.list = list;
    }
}
