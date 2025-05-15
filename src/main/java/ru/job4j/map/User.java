package ru.job4j.map;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

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

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        User user = (User) object;
        return children == user.children && Objects.equals(name, user.name) && Objects.equals(birthday, user.birthday);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(name);
        result = 31 * result + children;
        result = 31 * result + Objects.hashCode(birthday);
        return result;
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
