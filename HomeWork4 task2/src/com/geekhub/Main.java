package com.geekhub;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pattern pattern = Pattern.compile("^[a-zA-Z]*$");
        List<String> words = new ArrayList<>();

        System.out.println("enter quantity words fo reduction from 1 to 100");
        int quantityWords = scanner.nextInt();
        scanner.nextLine();

        for (int i = 1; i <= quantityWords; i++) {
            System.out.println("enter " + i + " word:");
            String word = scanner.nextLine();
            while (true) {
                if (pattern.matcher(word).find()) {
                    words.add(word);
                    break;
                } else {
                    System.out.println("enter other word:");
                    word = scanner.nextLine();
                }
            }
        }
        words.forEach(word -> System.out.println(reductionWord(word)));
    }

    private static String reductionWord(String word) {
        String editWord;
        int MAX_COUNT_LENGTH = 10;
        if (word.length() < MAX_COUNT_LENGTH) {
            editWord = word;
        } else {
            char first = word.charAt(0);
            int large = word.length() - 1;
            char last = word.charAt(large);
            editWord = first + "" + (large - 1) + "" + last;
        }
        return editWord;
    }
}
