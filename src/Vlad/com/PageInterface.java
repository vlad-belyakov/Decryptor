package Vlad.com;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

public class PageInterface extends JFrame{

    String[] codingTypes = new String[]{"base64","обычный","JSon"};
    String[] enCodingTypes = new String[]{"base64","обычный","JSon"};
    private JPanel panel;
    protected JTabbedPane tabs;
    protected JFrame window;
    private JComboBox codeChoose;
    private JComboBox encodeChoose;
    protected JTextArea inputTextArea;
    private JButton decodeButton;
    private JButton saveButton;
    private JButton openButton;
    protected JTextArea outputTextArea;
    private JButton copyButton;
    private JButton newTab;
    private JButton closeTab;
    private JButton settingsButton;
    private JPanel tab;
    public boolean themeColor;
    public String nameOfTab;

    public PageInterface(){
        window = new JFrame("Расшифровщик");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().add(panel);
        window.setSize(1550,800);
        //window.pack();
        window.setVisible(true);
        tab.setBackground(Color.WHITE);

        saveButton.addActionListener(click -> {
                if (outputTextArea != null) {
                    int select = tabs.getSelectedIndex();
                    JFileChooser dialog = new JFileChooser();
                    dialog.showSaveDialog(panel);
                    var file = dialog.getSelectedFile();
                    if((file != null)) {
                        FileWork f = new FileWork(file.getPath());
                        try {
                            f.Write(outputTextArea.getText());
                            nameOfTab = file.getName();
                            tabs.setTitleAt(select, nameOfTab);
                        } catch (IOException e) {
                            outputTextArea.setText(e.getMessage());
                        }
                    }else{
                        return;
                    }
                }
            });
        openButton.addActionListener(click -> {
            int select = tabs.getSelectedIndex();
            JFileChooser dialog = new JFileChooser();
            dialog.showOpenDialog(panel);
            var file = dialog.getSelectedFile();
            if (!(file == null)) {
                if (file.isFile() && file.canRead()) {
                    FileWork f = new FileWork(file.getPath());
                    nameOfTab = file.getName();
                    try {
                        inputTextArea.setText(f.Read());
                        tabs.setTitleAt(select, nameOfTab);
                    } catch (IOException e) {
                        inputTextArea.setText(e.getMessage());
                    }
                }
            } else {
                return;
            }
        });
        decodeButton.addActionListener(click -> {
            if (inputTextArea != null){
            outputTextArea.setText(null);
            switch (codeChoose.getSelectedItem().toString()) {
                case "base64":
                    if (encodeChoose.getSelectedItem().toString().equals("обычный")) {
                        Base_64 b = new Base_64();
                        outputTextArea.append(b.encodeFromBase64(inputTextArea.getText()));
                    } else if (encodeChoose.getSelectedItem().toString().equals("JSon")) {
                        Base_64 b = new Base_64();
                        JSon_ j = new JSon_();
                        outputTextArea.append(j.prettyView(b.encodeFromBase64(inputTextArea.getText())));
                    } else {
                        outputTextArea.append(inputTextArea.getText());
                    }
                    break;
                case "JSon":
                    if (encodeChoose.getSelectedItem().toString().equals("base64")) {
                        Base_64 b = new Base_64();
                        outputTextArea.append(b.codeToBase64(inputTextArea.getText()));
                    } else {
                        outputTextArea.append(inputTextArea.getText());
                    }
                    break;
                case "обычный":
                    if (encodeChoose.getSelectedItem().toString().equals("base64")) {
                        Base_64 b = new Base_64();
                        outputTextArea.append(b.codeToBase64(inputTextArea.getText()));
                    }
                    break;
            }
        }});
        copyButton.addActionListener(click -> {
            if (outputTextArea != null) {
                String copyText = outputTextArea.getText();
                StringSelection stringSelection = new StringSelection(copyText);
                Clipboard ctrlC = Toolkit.getDefaultToolkit().getSystemClipboard();
                ctrlC.setContents(stringSelection, null);
            }
        });
        newTab.addActionListener(click -> {
            newVladTabb nv = new newVladTabb(tabs);
            tabs.addTab("tab", nv.panel);
        });
        closeTab.addActionListener(click -> {
            int select = tabs.getSelectedIndex();
            if (select >= 0) {
                tabs.removeTabAt(select);
            }
        });
        settingsButton.addActionListener(click -> {
            try {
                Launcher.sett();
                window.setVisible(false);
            } catch (IOException e) {
                e.printStackTrace();
            }

        });

        for(String s:codingTypes) {
            codeChoose.addItem(s);
        }
        for(String s:enCodingTypes) {
            encodeChoose.addItem(s);
        }

        codeChoose.setSelectedIndex(0);
        encodeChoose.setSelectedIndex(1);

        codeChoose.addActionListener(e -> {
            if (codeChoose.getSelectedIndex() == encodeChoose.getSelectedIndex()){
                int i = codeChoose.getSelectedIndex();
                int ran = (int)(Math.random() * (enCodingTypes.length));
                if(ran != i) {
                    encodeChoose.setSelectedIndex(ran);
                }
            }
        });
        encodeChoose.addActionListener(e -> {
            if (encodeChoose.getSelectedIndex() == codeChoose.getSelectedIndex()){
                int i = encodeChoose.getSelectedIndex();
                int ran = (int)(Math.random() * (codingTypes.length));
                if(ran != i) {
                    codeChoose.setSelectedIndex(ran);
                }
            }
        });

        this.addWindowListener(getWindowListener());
    }


    private WindowListener getWindowListener() {
        return new WindowListener() {
            @Override
            public void windowOpened(WindowEvent windowEvent) {}

            @Override
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent windowEvent) {}

            @Override
            public void windowIconified(WindowEvent windowEvent) {}

            @Override
            public void windowDeiconified(WindowEvent windowEvent) {}

            @Override
            public void windowActivated(WindowEvent windowEvent) {}

            @Override
            public void windowDeactivated(WindowEvent windowEvent) {}
        };
    }
}
