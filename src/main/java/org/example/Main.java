package org.example;

import java.util.Arrays;

public class Main {
    public static int hIndex(int[] citations) {
        int[] count = new int[citations.length+1]; // собираем количество цитат относительно кол-ва статей

        for (int cit : citations) {
            if (cit > citations.length)
                count[citations.length]++;
            else
                count[cit]++;
        }

        System.out.println(Arrays.toString(count));

        int ans = 0;
        for (int i = count.length-1; i >= 0; i--) {
            ans += count[i];
            if (ans >= i) // если кол-во цитат в статье (ans) становится больше, чем статей (i) с таким кол-вом и больше цитат
                return i; // то возвращаем кол-во статей (i)
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(hIndex(new int[]{1,3,1}));
    }
}