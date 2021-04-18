package Vlad.com;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

public class newVladTabb extends JFrame{
    String[] codingTypes = new String[]{"base64", "обычный", "JSon"};
    String[] enCodingTypes = new String[]{"base64", "обычный", "JSon"};
    protected JPanel panel;
    private JComboBox codeChoose;
    private JComboBox encodeChoose;
    protected JTextArea inputTextArea;
    private JButton decodeButton;
    private JButton saveButton;
    private JButton openButton;
    protected JTextArea outputTextArea;
    private JButton copy;
    private JButton copyButton;
    private JButton settingsButton;
    private JPanel tab;
    public boolean themeColor;
    public String nameOfTab;



    public newVladTabb(JTabbedPane tabz) {

        this.add(panel);
        this.setSize(300, 300);
        this.pack();
        this.setVisible(false);



            decodeButton.addActionListener(click -> {
                if (inputTextArea != null) {
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
                }
            });


            for (String s : codingTypes) {
                codeChoose.addItem(s);
            }
            for (String s : enCodingTypes) {
                encodeChoose.addItem(s);
            }

            codeChoose.setSelectedIndex(0);
            encodeChoose.setSelectedIndex(1);

            codeChoose.addActionListener(e -> {
                if (codeChoose.getSelectedIndex() == encodeChoose.getSelectedIndex()) {
                    int i = codeChoose.getSelectedIndex();
                    int ran = (int) (Math.random() * (enCodingTypes.length));
                    if (ran != i) {
                        encodeChoose.setSelectedIndex(ran);
                    }
                }
            });
            encodeChoose.addActionListener(e -> {
                if (encodeChoose.getSelectedIndex() == codeChoose.getSelectedIndex()) {
                    int i = encodeChoose.getSelectedIndex();
                    int ran = (int) (Math.random() * (codingTypes.length));
                    if (ran != i) {
                        codeChoose.setSelectedIndex(ran);
                    }
                }
            });
        saveButton.addActionListener(click -> {
            if (inputTextArea != null) {
                JFileChooser dialog = new JFileChooser();
                dialog.showSaveDialog(panel);
                var file = dialog.getSelectedFile();
                if((file != null)) {
                    FileWork f = new FileWork(file.getPath());
                    try {
                        f.Write(inputTextArea.getText());
                        int select = tabz.getSelectedIndex();
                        nameOfTab = file.getName();
                        tabz.setTitleAt(select, nameOfTab);
                    } catch (IOException e) {
                        inputTextArea.setText(e.getMessage());
                    }
                }else{
                    return;
                }
            }
        });
        openButton.addActionListener(click -> {
            JFileChooser dialog = new JFileChooser();
            dialog.showOpenDialog(panel);
            var file = dialog.getSelectedFile();
            if (!(file == null)) {
                if (file.isFile() && file.canRead()) {
                    FileWork f = new FileWork(file.getPath());
                    nameOfTab = file.getName();
                    try {
                        inputTextArea.setText(f.Read());
                        int select = tabz.getSelectedIndex();
                        tabz.setTitleAt(select, nameOfTab);
                    } catch (IOException e) {
                        inputTextArea.setText(e.getMessage());
                    }
                }
            } else {
                return;
            }
        });
        copyButton.addActionListener(click -> {
            if (inputTextArea != null) {
                String copyText = inputTextArea.getText();
                StringSelection stringSelection = new StringSelection(copyText);
                Clipboard ctrlC = Toolkit.getDefaultToolkit().getSystemClipboard();
                ctrlC.setContents(stringSelection, null);
            }
        });

            this.addWindowListener(getWindowListener());
        }


        private WindowListener getWindowListener () {
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
