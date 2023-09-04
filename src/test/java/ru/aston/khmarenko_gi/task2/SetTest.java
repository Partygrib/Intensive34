package ru.aston.khmarenko_gi.task2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.aston.khmarenko_gi.task1.*;

import java.math.BigDecimal;
import java.util.Set;
import java.util.TreeSet;

public class SetTest {
    private final Set<Integer> set0 = new TreeSet<>();
    private final User user1 = new User(21, "Khmarenko", "Gleb");
    private final User user2 = new User(19, "Khmarenko", "Varvara");
    private final User user3 = new User(16, "Mamontov", "Mark");
    private final User user4 = new User(22, "Svechnikov", "Yan");
    private final ToolRental tool1 = new ToolRental(0 , new BigDecimal(12),
            new BigDecimal(1000), user1, new BigDecimal(10));

    private final ToolPurchase tool2 = new ToolPurchase(1 , new BigDecimal(1),
            new BigDecimal(1000), user2, DayOfWeek.FRIDAY);

    private final ToolPurchase tool3 = new ToolPurchase(2 , new BigDecimal(5),
            new BigDecimal(2500), user3, DayOfWeek.WEDNESDAY);

    private final ToolRental tool4 = new ToolRental(3 , new BigDecimal(3),
            new BigDecimal(3000), user4, new BigDecimal(30));

    public SetTest() throws TooYoungCustomer {
    }

    @Test
    public void testMethodsSet() {
        Assertions.assertTrue(set0.isEmpty());
        set0.add(1);
        Assertions.assertTrue(set0.add(11));
        Assertions.assertFalse(set0.add(11));
        set0.add(111);
        Assertions.assertEquals(3, set0.size());
        set0.remove(111);
        Assertions.assertEquals(2, set0.size());
        Assertions.assertFalse(set0.contains(111));

        set0.add(111);
        set0.add(1111);
        Assertions.assertEquals(11, set0.toArray()[1]);
        set0.clear();
        Assertions.assertTrue(set0.isEmpty());
    }

    @Test
    public void testSetConstructor() {
        // в конструкторе можно указать компаратор, в данном случае компаратор Tool сравнивает
        // пофамильно пользователей, таким образом пользователей с одной фамилией не добавляет
        // в TreeSet, так как такой элемент уже присутсвует во множестве
        Set<Tool> set1 = new TreeSet<>(Tool::compareTo);
        set1.add(tool1);
        set1.add(tool4);
        set1.add(tool2);
        Assertions.assertEquals(2, set1.size());
        Assertions.assertEquals("Svechnikov Yan Id: 3 price: 900", set1.toArray()[1].toString());

        // в данном конструкторе "наследуем" принцип сортировки, а значит и компаратор с set1
        Set<Tool> set2 = new TreeSet<>(set1);
        set2.add(tool1);
        set2.add(tool4);
        set2.add(tool2);
        Assertions.assertEquals(2, set1.size());

        // в данном конструкторе создаем пустое множество без правила сортировки,
        // однако сортировка применяется автоматически
        Set<Tool> set3 = new TreeSet<>();
        set3.add(tool1);
        set3.add(tool4);
        set3.add(tool2);
        Assertions.assertEquals(2, set3.size());

        // здесь мы не "наследуем" принцип сортировки, но из-за автоматической сортировки
        // и соответственно компаратора Tool все созданные множества буду одинаковы
        Set<Tool> set4 = new TreeSet<>(set3);
        Assertions.assertEquals(set1, set4);
        set1.add(tool3);
        set2.add(tool3);
        set4.add(tool3);
        Assertions.assertEquals(set1, set4);
        Assertions.assertEquals(set4, set2);
    }
}
