package ru.job4j.map;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class User {

    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public int getChildren() {
        return children;
    }

    public Calendar getBirthday() {
        return birthday;
    }

    public static void main(String[] args) {
        Calendar now = Calendar.getInstance();
        User first = new User("obito", 1, now);
        User second = new User("obito", 1, now);

        int firstHashCode = first.hashCode();
        int firstHash = firstHashCode ^ (firstHashCode >>> 16);
        int firstBucket = firstHash & 15;

        int secondHashCode = second.hashCode();
        int secondHash = secondHashCode ^ (secondHashCode >>> 16);
        int secondBucket = secondHash & 15;

        Map<User, Object> map = new HashMap<>();
        map.put(first, new Object());
        map.put(second, new Object());

        map.forEach((user, object) -> System.out.println(user + " " + object));

    }
}
