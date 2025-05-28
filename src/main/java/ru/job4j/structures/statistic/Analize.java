package ru.job4j.structures.statistic;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Analize {

    public static Info diff(Set<User> previous, Set<User> current) {
        Map<Integer, User> mapPrevious = new HashMap<>();
        int added = 0;
        int changed = 0;

        for (User user : previous) {
            mapPrevious.put(user.getId(), user);
        }
        for (User user : current) {
            if (!mapPrevious.containsKey(user.getId())) {
                added++;
            } else {
                if (mapPrevious.containsKey(user.getId())
                        && !mapPrevious.get(user.getId()).getName().equals(user.getName())) {
                    changed++;
                }
                mapPrevious.remove(user.getId());
            }
        }
        int deleted = mapPrevious.size();

        return new Info(added, changed, deleted);
    }
}
