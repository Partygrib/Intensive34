package ru.aston.khmarenko_gi.task6;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamAPITest {

    @Test
    @DisplayName("Посчитать сумму чисел в массиве [1, 2, 3, 4, 5], используя reduce()")
    public void sumArrayTest() {
        int[] array = new int[] {1, 2, 3, 4, 5};
        OptionalInt result = IntStream.of(array).reduce(Integer::sum);
        System.out.println(result.getAsInt());
    }

    @Test
    @DisplayName("Собрать все уникальные элементы Stream в список и отсортировать их")
    public void SkipElementTest() {
        List<Integer> list = Stream.of(4, 1, 3, 2, 5, 5, 6, 0, 0)
                .distinct().sorted().toList();
        System.out.println(list);
    }

    @Test
    @DisplayName("Выведите на экран только те элементы списка, которые больше заданного числа")
    public void moreThenElevenTest() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= 24; i += 3) {
            list.add(i);
        }
        list.stream().filter(x -> x < 11).forEach(System.out::println);
    }

    @Test
    @DisplayName("Проверить, все ли числа в массиве [0, 1, …, 19] являются четными")
    public void checkParityInArrayTest() {
        boolean check = IntStream.range(0, 20).allMatch(x -> x % 2 == 0);
        System.out.println(check);
    }

    @Test
    @DisplayName("Создайте два Stream-а: один из массива чисел 1…5, второй из массива 5…10. " +
            "Объедините эти два Stream-а в один и выведите на экран")
    public void mergeTwoStreamsTest() {
        IntStream i1 = IntStream.range(1, 6);
        IntStream i2 = IntStream.range(5, 11);
        IntStream.concat(i1, i2).forEach(System.out::println);
    }

    @Test
    @DisplayName("Разделить слова в Stream на две группы по первой букве: гласные и согласные," +
            "посчитать количество слов в каждой группе")
    public void vowelsAndConsonantsTest() {
        Stream<String> streamString =
                Stream.of("int", "uml", "stream", "sql", "python", "algorithm", "mock");

        Collection<List<String>> results = streamString
                .collect(Collectors.groupingBy(str -> str.startsWith("a") || str.startsWith("e") ||
                        str.startsWith("i") || str.startsWith("o") || str.startsWith("u")))
                .values();

        for (List<String> element : results) {
            System.out.println(element);
            System.out.println(element.size());
        }
    }

    @Test
    @DisplayName("Создание трех Stream из массивов и объединение их в один. " +
            "Затем вывод на экран среднего геометрического значения элементов этого Stream")
    public void ThreeStreamTest() {
        IntStream i1 = IntStream.range(1, 7);
        IntStream i2 = IntStream.range(2, 11);
        IntStream i3 = IntStream.range(11, 21);

        IntStream i1i2 = IntStream.concat(i1, i2);
        OptionalDouble result = IntStream.concat(i1i2, i3).average();
        System.out.println(result.getAsDouble());
    }

    @Test
    @DisplayName("Соберите числа в Stream в одно число, перемножив их между собой и выведите результат")
    public void multiplyingAllElementsTest() {
        LongStream i1 = LongStream.range(1, 10);

        long result = i1.reduce(1, (a, b) -> a * b);
        System.out.println(result);
    }

    @Test
    @DisplayName("Задан массив строк. Используя средства StreamAPI отсортировать строки в лексикографическом порядке")
    public void lexicographicSortTest() {
        String[] array = {"Alan", "Thomas", "Yan", "Yanni", "Anton", "Nancy", "Jacob"};
        Arrays.stream(array).sorted().forEach(System.out::println);
    }

    @Test
    @DisplayName("Собрать даты в Stream в список, где каждый элемент — это количество дат в каждом месяце года")
    public void DateMonthCountTest() {
        List<LocalDate> dates = Arrays.asList(
                LocalDate.of(2023, Month.APRIL, 11),
                LocalDate.of(2022, Month.APRIL, 10),
                LocalDate.of(2022, Month.JULY, 10),
                LocalDate.of(2023, Month.OCTOBER, 16),
                LocalDate.of(2020, Month.DECEMBER, 30),
                LocalDate.of(2021, Month.DECEMBER, 22),
                LocalDate.of(2023, Month.DECEMBER, 2),
                LocalDate.of(2024, Month.SEPTEMBER, 8),
                LocalDate.of(2024, Month.SEPTEMBER, 8)
        );

        Map<Month, Long> map= dates.stream().collect(
                Collectors.groupingBy(LocalDate::getMonth, Collectors.counting()));
        System.out.println(map.values());
        System.out.println(map);
    }
}
