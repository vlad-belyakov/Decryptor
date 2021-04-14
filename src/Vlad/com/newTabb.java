package Vlad.com;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

public class newTabb extends JFrame {
    private JTabbedPane tabs;
    public JPanel tab;
    private JTextArea inputTextArea;
    private JButton open;
    private JButton save;
    private JButton newTab;
    private JButton closeTab;
    private JButton settings;
    private JButton decodeB64;
    private JButton decodeJson;
    private JButton copy;
    private JPanel panel;
    private String nameOfTab;


    public newTabb(JFrame window, JTabbedPane panelka) throws IOException {


        this.add(panel);
        this.setSize(300, 300);
        this.pack();
        this.setVisible(false);


        this.addWindowListener(getWindowListener());
    }

    private WindowListener getWindowListener() {
        return new WindowListener() {
            @Override
            public void windowOpened(WindowEvent windowEvent) {
            }

            @Override
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent windowEvent) {
            }

            @Override
            public void windowIconified(WindowEvent windowEvent) {
            }

            @Override
            public void windowDeiconified(WindowEvent windowEvent) {
            }

            @Override
            public void windowActivated(WindowEvent windowEvent) {
            }

            @Override
            public void windowDeactivated(WindowEvent windowEvent) {
            }
        };
    }


}
