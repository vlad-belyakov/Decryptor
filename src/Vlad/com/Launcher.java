package Vlad.com;

import java.io.IOException;

public class Launcher {

    public static void main(String[] args) throws IOException {
        launch();
    }


    public static void sett() throws IOException {
        new StartingSettings();
    }

    public static void launch() throws IOException{
        PageDenisInterface.style();
        new PageDenisInterface();
    }

}
