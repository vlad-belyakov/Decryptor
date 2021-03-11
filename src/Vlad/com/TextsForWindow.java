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
        add("Я для этого создавал этот класс)");
        add("Пам парам");
        add("Это не пасхалка");
        add("Врум врум");
        add("фантазия закончилась");
    }};

    protected static String Texts(){
        int r = (int)(Math.random() * 10);
        return variants.get(r);
    }
}
