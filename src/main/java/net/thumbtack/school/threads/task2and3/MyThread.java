package net.thumbtack.school.threads.task2and3;

public class MyThread extends Thread {

    private String name; // name of thread

    public MyThread(String threadname) {
        name = threadname;
    }

    public void run(){

        System.out.printf("%s started... \n", Thread.currentThread().getName());
        try{
            Thread.sleep(500);
        }
        catch(InterruptedException e){
            System.out.println("Thread has been interrupted");
        }
        System.out.printf("%s fiished... \n", Thread.currentThread().getName());
    }

}
