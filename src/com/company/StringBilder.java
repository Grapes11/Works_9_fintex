package com.company;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class StringBilder {
    /**
     * Максимальное число в
     * сгенерированной строке цифр.
     */
    private static final int MAX = 26;
    /**
     * Количество чисел в сгенерированной
     * строке чисел.
     */
    private static final int AMOUNT = 60;
    /**
     * Используется для перевода в проценты.
     */
    private static final int PERCENT = 100;
    /**
     * Массив, в котором будут
     * располагаться сгенерированные числа.
     */
    private List<String> list = Stream.generate(String::new)
            .limit(AMOUNT)
            .collect(Collectors.toList());
    /**
     * Массив, в котором будут
     * располагаться проценты, которые
     * говорят о том сколько цифра из массива
     * List встречается в строке.
     */
    private List<Float> listPercent;
    void getArrayString() {
        list = list.stream()
                .map(s -> s = String.valueOf(new Random().nextInt(MAX)))
                .collect(Collectors.toList());
    }

    void viewList() {
        list.forEach(s -> System.out.print(" " + s));
    }
    void getPercent() {
        listPercent = list.stream().map(Integer::parseInt).sorted().distinct()
                .map(s -> {
                    float x = list.stream()
                            .filter(s1 -> s1.equals(String.valueOf(s))).count();
                    return x / AMOUNT * PERCENT; })
                .collect(Collectors.toList());
    }

    void viewPercent() {
        System.out.println(" ");
        List<Integer> list1 = list.stream().map(Integer::parseInt)
                .sorted().distinct().collect(Collectors.toList());
        for (int i = 0; i < list1.size(); i++) {
            System.out.println(list1.get(i)
                  + "-" + listPercent.get(i) + " процентов");
        }
    }
}
