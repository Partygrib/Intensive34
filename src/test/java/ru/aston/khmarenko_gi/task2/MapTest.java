package ru.aston.khmarenko_gi.task2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
    private final Map<Integer, String> map0 = new HashMap<>();

    @Test
    public void testMethodsMap() {
        Assertions.assertTrue(map0.isEmpty());
        map0.put(3, "Three");
        Assertions.assertEquals(1, map0.size());
        map0.put(1, "One");
        map0.put(0, "Zero");
        map0.put(2, "Two");
        map0.put(5, "Five");
        Assertions.assertTrue(map0.containsKey(3));
        Assertions.assertEquals("Three", map0.get(3));
        Assertions.assertEquals("Six?", map0.getOrDefault(6, "Six?"));
        map0.remove(3);
        Assertions.assertFalse(map0.containsKey(3));

        Assertions.assertTrue(map0.containsValue("Two"));
        Assertions.assertEquals("Two", map0.get(2));
        map0.replace(2, "Second");
        Assertions.assertFalse(map0.containsValue("Two"));
        Assertions.assertTrue(map0.containsValue("Second"));

        map0.putIfAbsent(2, "2");
        Assertions.assertEquals("Second", map0.get(2));
        map0.putIfAbsent(6, "Six");
        Assertions.assertEquals("Six", map0.get(6));

        map0.clear();
        Assertions.assertTrue(map0.isEmpty());
    }

    @Test
    public void testMapConstructor() {
        Map<Integer, String> map1 = new HashMap<>(2);
        map0.put(1, "One");
        map0.put(0, "Zero");
        map0.put(2, "Two");
        map1.putAll(map0);
        Assertions.assertTrue(map0.equals(map1));

        Map<Integer, String> map2 = new HashMap<>(2, 1.25F);
        map2.putAll(map1);
        Assertions.assertTrue(map2.equals(map1));

        Map<Integer, String> map3 = new HashMap<>(map2);
        Assertions.assertTrue(map3.equals(map2));
    }
}
