package net.thumbtack.school.threads;

import net.thumbtack.school.threads.task10.ClassAddReentrantLock;
import net.thumbtack.school.threads.task10.ClassRemoveReentrantLock;
import net.thumbtack.school.threads.task11.PingPongTask11;
import net.thumbtack.school.threads.task13.Formatter;
import net.thumbtack.school.threads.task13.FormatterThreadLocal;
import net.thumbtack.school.threads.task2and3.MyThread;
import net.thumbtack.school.threads.task4.ClassAdd;
import net.thumbtack.school.threads.task4.ClassRemove;
import net.thumbtack.school.threads.task5.ClassAddAndRemove;
import net.thumbtack.school.threads.task7.PingPongTask7;
import net.thumbtack.school.threads.task7.PingTask7;
import net.thumbtack.school.threads.task7.PongTask7;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadsProgramming {

    // Task 1

    public void getThreadInfo(Thread thread) {
        System.out.println("id = " + thread.getId());
        System.out.println("name = " + thread.getName());
        System.out.println("priority = " + thread.getPriority());
        System.out.println("state = " + thread.getState());
    }


    // Task 2

    public void primaryAndSecondaryThread() {
        System.out.println("Main thread started...");
        MyThread t = new MyThread("Secondary");
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread Interrupted");
        }
        System.out.println("Main thread finished...");

    }


    // Task 3

    public void ThreeThreads() {

        System.out.println("Main thread started...");

        MyThread threadOne = new MyThread("One");
        MyThread threadTwo = new MyThread("Two");
        MyThread threadThree = new MyThread("Three");

        threadOne.start();
        threadTwo.start();
        threadThree.start();
        try {
            threadOne.join();
            threadTwo.join();
            threadThree.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread Interrupted");
        }
        System.out.println("Main thread finished...");
    }


    // Task 4

    public void task4() {
        MyList myList = new MyList(new ArrayList<>());
        new ClassAdd(myList).start();
        new ClassRemove(myList).start();
    }


    // Task 5

    public void task5() {
        MyList myList = new MyList(new ArrayList<>());

        ClassAddAndRemove add = new ClassAddAndRemove(myList, AddRemoveOperation.ADD);
        ClassAddAndRemove remove = new ClassAddAndRemove(myList, AddRemoveOperation.REMOVE);

        add.start();
        remove.start();

        try {
            add.join();
            remove.join();
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }

    }

    // Task 6



    // Task 7

    public void task7() {
        PingPongTask7 pingPongTask7 = new PingPongTask7();
        PongTask7 p = new PongTask7(pingPongTask7);
        PingTask7 c = new PingTask7(pingPongTask7);

        p.start();
        c.start();

        try {
            p.join();
            c.join();
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }

    }


    // Task 10

    public void task10() {

        List<Integer> list = new ArrayList<Integer>();

        Lock lock = new ReentrantLock();

        ClassAddReentrantLock classAdd = new ClassAddReentrantLock(lock, list);
        ClassRemoveReentrantLock classRemove = new ClassRemoveReentrantLock(lock, list);

        classAdd.start();
        classRemove.start();

        try {
            classAdd.join();
            classRemove.join();
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }

    }

    // Task 11

    public void task11() {

        Lock lock1 = new ReentrantLock();

        PingPongTask11 ping = new PingPongTask11(lock1, PingPongOperation.PING);
        PingPongTask11 pong = new PingPongTask11(lock1, PingPongOperation.PONG);

        ping.start();
        pong.start();

        try {
            ping.join();
            pong.join();
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
    }

    // Task 12


    // Task 13

    public void task13() {

        Formatter formatter = new Formatter(new Date());
        FormatterThreadLocal formatterThreadLocal_1 = new FormatterThreadLocal(formatter);
        FormatterThreadLocal formatterThreadLocal_2 = new FormatterThreadLocal(formatter);
        FormatterThreadLocal formatterThreadLocal_3 = new FormatterThreadLocal(formatter);
        FormatterThreadLocal formatterThreadLocal_4 = new FormatterThreadLocal(formatter);
        FormatterThreadLocal formatterThreadLocal_5 = new FormatterThreadLocal(formatter);

        new Thread(formatterThreadLocal_1).start();
        new Thread(formatterThreadLocal_2).start();
        new Thread(formatterThreadLocal_3).start();
        new Thread(formatterThreadLocal_4).start();
        new Thread(formatterThreadLocal_5).start();

    }




}
