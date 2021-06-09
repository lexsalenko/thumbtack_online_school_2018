package net.thumbtack.school.threads.task13;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Formatter {

    private Date date;

    public Formatter(Date date) {
        this.date = date;
        System.out.println(date.toString());
    }

    public String format(Date date) {
        return new SimpleDateFormat().format(date);
    }

    public Date getDate() {
        return date;
    }
}
