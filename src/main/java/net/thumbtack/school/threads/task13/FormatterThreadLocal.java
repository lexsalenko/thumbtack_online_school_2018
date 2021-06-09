package net.thumbtack.school.threads.task13;

public class FormatterThreadLocal implements Runnable {

    private Formatter formatter;

    public FormatterThreadLocal(Formatter formatter) {
        this.formatter = formatter;
    }

    @Override
    public void run() {
        ThreadLocal<Formatter> formatterThreadLocal = new ThreadLocal<>();
        formatterThreadLocal.set(formatter);
        System.out.println(formatterThreadLocal.get().format(formatter.getDate()));
    }

}
