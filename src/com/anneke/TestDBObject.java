package com.anneke;

import java.util.Date;

public class TestDBObject {
    private int id;
    private String name;
    private Date date;
    private Double d;
    private int count;

    public TestDBObject(int id, String name, Date date, Double d, int count) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.d = d;
        this.count = count;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }

    public Double getD() {
        return d;
    }

    public int getCount() {
        return count;
    }
}
