package ru.aston.khmarenko_gi.task1;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ToolRental extends Tool {

    private final BigDecimal rentalDays;

    public ToolRental(int id, BigDecimal weight, BigDecimal amount, User user, BigDecimal rentalDays) {
        super(id, weight, amount, user);
        this.rentalDays = rentalDays;
    }

    @Override
    public BigDecimal getDiscount() {
        if (this.user.getAge() < 18 || this.user.getAge() >= 65)
            return new BigDecimal("0.25");
        else return new BigDecimal(0);
    }

    @Override
    public BigDecimal getServicePrice() {
        BigDecimal price = (amount.divide(new BigDecimal(100))).multiply(rentalDays);
        price = price.subtract(price.multiply(getDiscount()));
        return price.setScale(0, RoundingMode.UP);
    }
}
