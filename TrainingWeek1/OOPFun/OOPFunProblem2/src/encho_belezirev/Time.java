package encho_belezirev;

import java.util.Date;

public class Time {
    private int hours;
    private int minutes;
    private int seconds;
    private int day;
    private int month;
    private int year;

    public Time() {
        this(new Date().getDay(), new Date().getMonth(), new Date().getYear());

    }

    public Time(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public Time(int hours, int minutes, int seconds, int day, int month, int year) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
        this.day = day;
        this.month = month;
        this.year = year;
    }

    @Override
    public String toString() {
        return String.format("%d:%d:%d %d.%d.%d", this.hours, this.minutes, this.seconds, this.day, this.month, this.year);
    }
    
    protected Time now(){
        return new Time();
    }
    
}
