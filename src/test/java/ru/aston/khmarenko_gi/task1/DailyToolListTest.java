package ru.aston.khmarenko_gi.task1;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DailyToolListTest {
    private final User user1 = new User(21, "Khmarenko", "Gleb");
    private final User user2 = new User(19, "Khmarenki", "Varvara");
    private final User user3 = new User(16, "Mamontov", "Mark");
    private final User user4 = new User(22, "Svechnikov", "Yan");

    @Test
    public void calcDailyAmount() {
        ToolRental tool1 = new ToolRental(0 , new BigDecimal(12),
                new BigDecimal(1000), user1, new BigDecimal(10));

        ToolPurchase tool2 = new ToolPurchase(1 , new BigDecimal(1),
                new BigDecimal(1000), user2, DayOfWeek.FRIDAY);

        ToolPurchase tool3 = new ToolPurchase(2 , new BigDecimal(5),
                new BigDecimal(2500), user3, DayOfWeek.WEDNESDAY);

        ToolRental tool4 = new ToolRental(3 , new BigDecimal(3),
                new BigDecimal(3000), user4, new BigDecimal(30));

        List<Tool> list0 = new ArrayList<>();
        list0.add(tool1);
        list0.add(tool2);
        list0.add(tool3);
        list0.add(tool4);

        DailyToolList dailyToolList0 = new DailyToolList(list0, new BigDecimal(0));

        Assertions.assertEquals("Khmarenki", dailyToolList0.getSortedList().get(0).getUser().getSourName());
        Assertions.assertEquals("Svechnikov", dailyToolList0.getSortedList().get(3).getUser().getSourName());
        Assertions.assertEquals("DailyToolListTest: [Khmarenki Varvara Id: 1 price: 750, " +
                "Khmarenko Gleb Id: 0 price: 100, Mamontov Mark Id: 2 price: 2500, " +
                "Svechnikov Yan Id: 3 price: 900]", dailyToolList0.toString());
        Assertions.assertEquals(new BigDecimal(4250),
                dailyToolList0.calcDailyAmount(new BigDecimal(0)));


        ToolRental tool5 = new ToolRental(0 , new BigDecimal(12),
                new BigDecimal(1000), user1, new BigDecimal(0));

        ToolPurchase tool6 = new ToolPurchase(1 , new BigDecimal(10),
                new BigDecimal(1000), user1, DayOfWeek.MONDAY);

        ToolPurchase tool7 = new ToolPurchase(1 , new BigDecimal(15),
                new BigDecimal(1000), user2, DayOfWeek.SATURDAY);

        ToolRental tool8 = new ToolRental(3 , new BigDecimal(3),
                new BigDecimal(1000), user2, new BigDecimal(1));

        List<Tool> list1 = new ArrayList<>();
        list1.add(tool5);
        list1.add(tool6);
        list1.add(tool7);
        list1.add(tool8);

        DailyToolList dailyToolList1 = new DailyToolList(list1, new BigDecimal(0));

        Assertions.assertEquals("Khmarenki", dailyToolList1.getSortedList().get(1).getUser().getSourName());
        Assertions.assertEquals("Khmarenko", dailyToolList1.getSortedList().get(2).getUser().getSourName());
        Assertions.assertEquals("DailyToolListTest: [Khmarenki Varvara Id: 1 price: 1000, " +
                "Khmarenki Varvara Id: 3 price: 10, Khmarenko Gleb Id: 0 price: 0, " +
                "Khmarenko Gleb Id: 1 price: 500]", dailyToolList1.toString());
        Assertions.assertEquals(new BigDecimal(1510),
                dailyToolList1.calcDailyAmount(new BigDecimal(0)));
    }



}
