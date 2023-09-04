package ru.aston.khmarenko_gi.task2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListTest {
    private final List<Integer> list0 = new ArrayList<>();

    @Test
    public void testMethodsList() {
        Assertions.assertTrue(list0.isEmpty());
        list0.add(0);
        list0.add(1);
        list0.add(3);
        list0.add(2);
        list0.add(4);
        list0.add(0);
        Assertions.assertFalse(list0.isEmpty());
        Assertions.assertEquals(1, list0.get(1));
        Assertions.assertEquals(0, list0.indexOf(0));
        Assertions.assertEquals(5, list0.lastIndexOf(0));

        list0.set(1, -1);
        Assertions.assertEquals(-1, list0.get(1));
        list0.remove(3);
        Assertions.assertEquals(list0.size(), 5);
        Assertions.assertEquals(-1, list0.toArray()[1]);

        List<Integer> subList0 = new ArrayList<>();
        subList0.add(-1);
        subList0.add(3);
        List<Integer> subList1 = list0.subList(1, 3);
        Assertions.assertEquals(subList0, subList1);

        list0.retainAll(subList0);
        Assertions.assertEquals(subList0, list0);
        list0.removeAll(subList0);
        Assertions.assertTrue(list0.isEmpty());
        subList0.clear();
        Assertions.assertTrue(subList0.isEmpty());
    }

    @Test
    public void testListConstructor() {
        list0.add(0);

        List<Integer> list1 = new ArrayList<>(list0);
        Assertions.assertEquals(list1, list0);
        list0.add(1);
        list0.add(2);
        list0.add(3);

        List<Integer> list2 = new ArrayList<>(2);
        list2.addAll(list0);
        Assertions.assertTrue(list2.contains(3));
        Assertions.assertTrue(list2.containsAll(list0));
        Assertions.assertTrue(list0.containsAll(list2));
        Assertions.assertEquals(list0, list2);
        Assertions.assertEquals(list2.size(), 4);
    }

    @Test
    public void testCollections() {
        Assertions.assertTrue(list0.isEmpty());
        list0.add(0);
        list0.add(1);
        list0.add(3);
        list0.add(0);
        Collections.sort(list0);
        Assertions.assertEquals(0, list0.get(1));
        List<Integer> list1 = new ArrayList<>();
        list1.add(4);
        list1.add(5);
        list1.add(5);
        list1.add(6);
        Collections.copy(list0, list1);
        Assertions.assertEquals(list1, list0);
        Collections.reverse(list0);
        Assertions.assertEquals(4, list0.get(3));

        Collections.swap(list0, 3, 0);
        Assertions.assertEquals(6, list0.get(3));
        Assertions.assertEquals(4, Collections.min(list0));
        Assertions.assertEquals(6, Collections.max(list0));

        Collections.replaceAll(list0, 5, 10);
        Assertions.assertEquals(10, list0.get(1));
        Assertions.assertEquals(10, list0.get(2));

        Assertions.assertEquals(1, Collections.binarySearch(list0, 10));
    }
}
