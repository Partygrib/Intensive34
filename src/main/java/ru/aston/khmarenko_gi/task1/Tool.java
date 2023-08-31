package ru.aston.khmarenko_gi.task1;

import java.math.BigDecimal;

public abstract class Tool implements Discount {
    private int id;
    protected BigDecimal weight;
    protected BigDecimal amount;
    protected User user;

    public Tool(int id, BigDecimal weight, BigDecimal amount, User user) {
        this.id = id;
        this.weight = weight;
        this.amount = amount;
        this.user = user;
    }

    public abstract BigDecimal getServicePrice();

    public int getId() {return this.id;}

    public void setId(int id) {this.id = id;}

    public BigDecimal getWeight() {return this.weight;}

    public void setWeight(BigDecimal weight) {this.weight = weight;}

    public BigDecimal getAmount() {return this.amount;}

    public void setAmount(BigDecimal amount) {this.amount = amount;}

    public User getUser() {return this.user;}

    public void setUser(User user) {this.user = user;}
}
