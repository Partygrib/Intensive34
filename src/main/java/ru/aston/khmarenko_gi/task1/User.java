package ru.aston.khmarenko_gi.task1;

import ru.aston.khmarenko_gi.task2.TooYoungCustomer;

import java.util.Arrays;
import java.util.Objects;

public class User {
    private int age;
    private String sourName;
    private String name;

    public User (int age, String sourName, String name) throws TooYoungCustomer {
        this.age = age;
        this.sourName = sourName;
        this.name = name;

        boolean ageLimitCheck = age < 14;
        if (ageLimitCheck) throw new TooYoungCustomer("Покупатель не проходит под возрастное ограничение!");
    }

    public int getAge() {return this.age;}
    public void setAge(int age) {this.age = age;}
    public String getSourName() {return this.sourName;}
    public void setSourName(String sourName) {this.sourName = sourName;}
    public String getName() {return this.name;}
    public void setName(String name) {this.name = name;}

    @Override
    public String toString() {
        return sourName + " " + name;
    }

    @Override
    public boolean equals(Object o1) {
        if (this == o1) return true;
        if (o1 == null || getClass() != o1.getClass()) return false;
        User user = (User) o1;
        return age == user.age && Arrays.equals(sourName.toCharArray(),
                user.sourName.toCharArray()) && Arrays.equals(name.toCharArray(),
                user.name.toCharArray());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(age);
        result = result * 31 + Arrays.hashCode(sourName.toCharArray());
        result = result * 31 + Arrays.hashCode(name.toCharArray());
        return result;
    }
}
