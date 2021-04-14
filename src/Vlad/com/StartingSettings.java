package Vlad.com;

import javax.swing.*;
import java.io.IOException;

public class StartingSettings {

    private JRadioButton themeChoose;

    private final JFrame window;
    private JButton vladVersion;
    private JPanel settingsPanel;
    private JButton denisVersion;
    public boolean theme = false;
    public boolean notNormal = false;
    public static boolean memor = false;
    public String setti;

    public StartingSettings(){


        window = new JFrame("Настройка");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().add(settingsPanel);
        window.setSize(1550,800);
        //window.pack();
        window.setVisible(true);

        vladVersion.addActionListener(click -> {
            window.setVisible(false);
            new PageInterface();
        });

        denisVersion.addActionListener(click -> {
            window.setVisible(false);
            try {
                new PageDenisInterface();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        /*if(theme){
            themeChoose.setSelected(true);
        }

        if(notNormal){
            DenisVersion.setSelected(true);
        }

        if (memor){
            memory.setSelected(true);
        }*/

        /*themeChoose.addActionListener(click -> {
            theme = themeChoose.isSelected();
            if(theme){
                themeChoose.setSelected(true);
            } else {
                themeChoose.setSelected(false);
            }
        });*/

        /*DenisVersion.addActionListener(click -> {
            notNormal = DenisVersion.isSelected();
            if(notNormal){
                DenisVersion.setSelected(true);
            } else {
                DenisVersion.setSelected(false);
            }
        });

        memory.addActionListener(click -> {
            memor = memory.isSelected();
            if (memor){
                memory.setSelected(true);
            } else {
                memory.setSelected(false);
            }
        });*/
    }

    /*private String setSet(){
        String seti;
        if(notNormal){
            seti = "y-";
        } else {
            seti = "n-";
        }

        if(theme){
            seti = seti + "y-";
        } else {
            seti = seti + "n-";
        }

        if(memor){
            seti = seti + "y";
        } else {
            seti = seti + "n";
        }
        return seti;
    }*/
}
