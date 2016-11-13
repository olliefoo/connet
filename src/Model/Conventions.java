package Model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by cbbjs on 11/13/2016.
 */
public class Conventions implements Serializable{
    private static int total = 0;
    private String topics;
    private String date;
    private String time;
    private Date fullDate;
    private String location;
    private int number;

    public Conventions() {
        fullDate = new Date();
    }

    public String toString() {
        String string = "<h1>" + topics + "<h2><br>Place: " + location + "<br>Date: " + fullDate + "<br>Time: " + time;
    return string;
    }
    public static int getTotal() {
        return total;
    }
    public void setNum(int num) {
        number = num;
    }
    public void setTopics(String name) {
        this.topics = name;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public String getTopics() {
        return topics;
    }
    public String getTime() {
        return time;
    }
    public String getDate() {
        return date;
    }
    public String getLocation() {
        return location;
    }
    public int getNumber() {
        return number;
    }
    public Date getFullDate() {
        return fullDate;
    }
    public String getYear() {
        SimpleDateFormat yr = new SimpleDateFormat("yyyy");
        return yr.format(fullDate);
    }

    public String getMonth() {
        SimpleDateFormat mn = new SimpleDateFormat("MMM");
        return mn.format(fullDate);
    }

}
