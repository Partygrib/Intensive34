package ru.aston.khmarenko_gi.task1;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ToolPurchase extends Tool {

    private final DayOfWeek dayOfPurchase;

    public ToolPurchase(int id, BigDecimal weight, BigDecimal amount, User user, DayOfWeek dayOfPurchase) {
        super(id, weight, amount, user);
        this.dayOfPurchase = dayOfPurchase;
    }

    @Override
    public BigDecimal getDiscount() {
        switch (dayOfPurchase) {
            case MONDAY -> {
                if (this.weight.compareTo(new BigDecimal(10)) >= 0) {
                    return new BigDecimal("0.5");
                }
            }
            case FRIDAY -> {
                return new BigDecimal("0.25");
            }
            case SATURDAY -> {
                if (this.amount.compareTo(new BigDecimal(5000)) >= 0) {
                    return new BigDecimal("0.5");
                }
            }
        }
        return new BigDecimal(0);
    }

    @Override
    public BigDecimal getServicePrice() {
        return (this.amount.subtract(this.amount.multiply(getDiscount()))).setScale(0, RoundingMode.UP);
    }
}
