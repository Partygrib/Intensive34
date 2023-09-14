package ru.aston.khmarenko_gi.task4.Entity;

public class User {
    private long id;
    private String name;
    private String surname;
    private String middleName;
    private String number;
    private String email;
    private long orderId;

    public User(long id, String name, String surname, String middleName,
                String number, String email, long orderId) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.middleName = middleName;
        this.number = number;
        this.email = email;
        this.orderId = orderId;
    }

    public User(String name, String surname, String middleName,
                String number, String email, long orderId) {
        this.name = name;
        this.surname = surname;
        this.middleName = middleName;
        this.number = number;
        this.email = email;
        this.orderId = orderId;
    }

    public Long getId() {return this.id;}

    public void setId(long id) {this.id = id;}

    public String getName() {return this.name;}

    public void setName(String name) {this.name = name;}

    public String getSurname() {return this.surname;}

    public void setSurname(String surname) {this.surname = surname;}

    public String getMiddleName() {return this.middleName;}

    public void setMiddleName(String middleName) {this.middleName = middleName;}

    public String getNumber() {return this.number;}

    public void setNumber(String number) {this.number = number;}

    public String getEmail() {return this.email;}

    public void setEmail(String email) {this.email = email;}

    public long getOrderId() {return this.orderId;}

    public void setOrderId(long orderId) {this.orderId = orderId;}
}
