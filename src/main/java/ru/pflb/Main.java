package ru.pflb;

import org.apache.commons.collections4.OrderedMap;
import org.apache.commons.collections4.map.LinkedMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        OrderedMap<Integer, List<String>> map = new LinkedMap<>();
        String str;
        while (!(str = reader.readLine()).equals("")) {
            String[] nameScore = str.split(" ");
            Integer key = Integer.valueOf(nameScore[1]);
            List<String> newValue = new ArrayList<>();
            newValue.add(nameScore[0]);
            if (map.containsKey(key)) {
                map.get(key).addAll(newValue);
            } else {
                map.put(key, newValue);
            }
        }
        map.entrySet().stream()
                .sorted(Map.Entry.<Integer, List<String>>comparingByKey().reversed())
                .forEach(entry -> {
                    for (String name : entry.getValue()) {
                        System.out.printf("%d %s\n", entry.getKey(), name);
                    }
                });
    }
}
