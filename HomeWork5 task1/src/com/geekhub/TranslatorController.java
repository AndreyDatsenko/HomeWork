package com.geekhub;

import com.geekhub.source.SourceLoader;
import com.geekhub.source.URLSourceProvider;

import java.io.IOException;
import java.util.Scanner;

public class TranslatorController {

    public static void main(String[] args) throws Exception {
        SourceLoader sourceLoader = new SourceLoader();
        Translator translator = new Translator();

        Scanner scanner = new Scanner(System.in);
        String command = scanner.next();
        while (!"exit".equals(command)) {
            try{
                String source = sourceLoader.loadSource(command);
                String translation = translator.translate(source);
                System.out.println("Original: " + source);
                System.out.println("Translation: " + translation);
            }catch (Exception e){
                System.out.println("enter another path to translation:");
            }
            command = scanner.next();
        }
    }
}
