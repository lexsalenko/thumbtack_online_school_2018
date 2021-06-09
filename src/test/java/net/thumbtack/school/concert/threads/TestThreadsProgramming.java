package net.thumbtack.school.concert.threads;

import net.thumbtack.school.threads.ThreadsProgramming;
import org.junit.Test;

public class TestThreadsProgramming {

    private ThreadsProgramming threadsProgramming = new ThreadsProgramming();

    @Test
    public void TestGetThreadInfo(){
        Thread thread = Thread.currentThread();
        threadsProgramming.getThreadInfo(thread);
    }

    @Test
    public void TestPrimaryAndSecondaryThread(){
        threadsProgramming.primaryAndSecondaryThread();
    }

    @Test
    public void TestThreeThreads(){
        threadsProgramming.ThreeThreads();
    }

    @Test
    public void TestFourThreads() {
        threadsProgramming.task4();
    }

    @Test
    public void TestFiveThreads(){
        threadsProgramming.task5();
    }

    @Test
    public void TestSevenThreads(){
        threadsProgramming.task7();
    }

    @Test
    public void TestTenThreads() {
        threadsProgramming.task10();
    }

    @Test
    public void TestElevenThreads() {
        threadsProgramming.task11();
    }

    @Test
    public void TestThirteenThreads() {
        threadsProgramming.task13();
    }


}
