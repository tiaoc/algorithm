package com.leetcode;

import java.util.*;

public class leetcode6126 {
    public static void main(String[] args) {
        FoodRatings foodRatings = new FoodRatings(new String[]{"kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"},
                new String[]{"korean", "japanese", "japanese", "greek", "japanese", "korean"},
                new int[]{9, 12, 8, 15, 14, 7});
        String s = foodRatings.highestRated("korean");
        s = foodRatings.highestRated("japanese"); // 返回 "ramen"
        // "ramen" 是分数最高的日式料理，评分为 14 。
        foodRatings.changeRating("sushi", 16); // "sushi" 现在评分变更为 16 。
        s = foodRatings.highestRated("japanese");
        s = "0";
    }
}

class FoodRatings {
    Map<String, SortedSet<int[]>> foods = new HashMap<>();
    Map<String, String> type = new HashMap<>();
    Map<String, int[]> idxMap = new HashMap<>();
    String[] name;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        name = foods;
        for (int i = 0; i < foods.length; ++i) {
            this.foods.computeIfAbsent(cuisines[i], v -> new TreeSet<>((a, b) -> {
                if (a[1] < b[1]) {
                    return 1;
                } else if (a[1] == b[1]) {
                    return name[a[0]].compareTo(name[b[0]]);
                }
                return -1;
            }));
            int[] arr = new int[]{i, ratings[i]};
            this.foods.get(cuisines[i]).add(arr);
            this.idxMap.put(foods[i], arr);
            this.type.put(foods[i], cuisines[i]);
        }
    }

    public void changeRating(String food, int newRating) {
        SortedSet<int[]> set = foods.get(type.get(food));
        set.remove(idxMap.get(food));
        int[] newArr = new int[]{idxMap.get(food)[0], newRating};
        set.add(newArr);
        idxMap.put(food, newArr);
    }

    public String highestRated(String cuisine) {
        return name[foods.get(cuisine).first()[0]];
    }
}
