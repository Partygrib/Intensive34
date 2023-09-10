package ru.aston.khmarenko_gi.task4.Entity;

public class Order {
    private long id;
    private String name;
    private String order_date;

    public Order (long id, String name, String order_date) {
        this.id = id;
        this.name = name;
        this.order_date = order_date;
    }

    public Order (String name, String order_date) {
        this.name = name;
        this.order_date = order_date;
    }

    public Long getId() {return this.id;}

    public void setId(long id) {this.id = id;}

    public String getName() {return this.name;}

    public void setName(String name) {this.name = name;}

    public String getDate() {return this.order_date;}

    public void setOrder_date(String order_date) {this.order_date = order_date;}
}
