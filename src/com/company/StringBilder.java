package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

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
    private List<String> list = new ArrayList<>();
    /**
     * Массив, в котором будут
     * располагаться проценты, которые
     * говорят о том сколько цифра из массива
     * List встречается в строке.
     */
    private List<Float> list2;

    void getArrayString() {
        Random random = new Random();
        for (int i = 0; i < AMOUNT; i++) {
            list.add(String.valueOf(random.nextInt(MAX)));
        }
    }

    void viewList() {
        list.forEach(s -> System.out.print(" " + s));
    }
    void getPercent() {
        list2 = list.stream().map(Integer::parseInt).sorted().distinct()
                .map(s -> {
                    float x = list.stream()
                            .filter(s1 -> s1.equals(String.valueOf(s))).count();
                    return x / AMOUNT * PERCENT; })
                .collect(Collectors.toList());
    }

    void viewListPercent() {
        System.out.println(" ");
        List<Integer> list1 = list.stream().map(Integer::parseInt)
                .sorted().distinct().collect(Collectors.toList());
      for (int i = 0; i < list1.size(); i++) {
          System.out.println(list1.get(i)
                  + "-" + list2.get(i) + " процентов");
      }
    }
}
