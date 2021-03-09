package Vlad.com;

import java.util.ArrayList;

public class TextsForWindow {
    TextsForWindow(){}
    private final static ArrayList<String> variants = new ArrayList<>(){{
        add("Привет");
        add("Хочу шоколад");
        add("Ты точно это читаешь?");
        add("Жду косарик");
        add("0L/QtdGA0LXQstC10Ls/");
        add("1");
        add("2");
        add("3");
        add("4");
        add("5");
    }};

    protected static String Texts(){
        int r = (int)(Math.random() * 10);
        return variants.get(r);
    }
}
