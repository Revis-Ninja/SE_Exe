package basic;

import java.io.PrintStream;

public class date {
    int day;
    int month;
    int year;

    public date(int d, int m, int y){
        day = d;
        month = m;
        year = y;
    }
    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }
    public void print(PrintStream ps){
        ps.print("("+day+"/"+month+"/"+year+")");
    }
}
