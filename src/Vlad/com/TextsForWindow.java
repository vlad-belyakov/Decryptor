package Vlad.com;

import java.util.ArrayList;

public class TextsForWindow {
    TextsForWindow(){}
    private final static ArrayList<String> variants = new ArrayList<>(){{
        add("");
        add("");
        add("");
        add("");
        add("");
        add("");
        add("");
        add("");
        add("");
        add("");
    }};

    protected static String Texts(){
        int r = (int)(Math.random() * 10);
        return variants.get(r);
    }
}
