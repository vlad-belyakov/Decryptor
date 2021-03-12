package Vlad.com;

import java.awt.*;
import java.awt.datatransfer.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;

public class PageInterface extends JFrame{

    String[] codingTypes = new String[]{"base64","обычный","JSon"};
    String[] enCodingTypes = new String[]{"base64","обычный","JSon"};
    private JPanel window;
    private JFrame wow;
    private JComboBox code;
    private JComboBox encode;
    private JTextArea inputTextArea;
    private JButton Decode;
    private JButton Save;
    private JButton Open;
    private JTextArea outputTextArea;
    private JButton Copy;
    private JButton Formate;

    public PageInterface(){
        wow = new JFrame(TextsForWindow.Texts());
        wow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        wow.getContentPane().add(window);
        wow.setSize(300,300);
        wow.pack();
        wow.setVisible(true);
        //this.setLayout(null);


        Save.addMouseListener(getSaveButtonListener());
        Open.addMouseListener(getOpenButtonListener());
        Decode.addMouseListener(getDecodeButtonListener());
        Copy.addMouseListener(getCopyButtonListener());
        Formate.addMouseListener(getFormateButtonListener());
        /*window.setBackground(Color.GRAY);
        Copy.setForeground(Color.LIGHT_GRAY);
        Save.setBackground(Color.GRAY);
        Open.setBackground(Color.GRAY);
        Build.setBackground(Color.GRAY);
        inputTextArea.setBackground(Color.GRAY);
        Copy.setBackground(Color.GRAY);
        outputTextArea.setBackground(Color.GRAY);
        */
        for(String s:codingTypes) {
            code.addItem(s);
        }
        for(String s:enCodingTypes) {
            encode.addItem(s);
        }
        code.setSelectedIndex(0);
        encode.setSelectedIndex(1);
        code.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (code.getSelectedIndex() == encode.getSelectedIndex()){
                    int i = code.getSelectedIndex();
                    int ran = (int)(Math.random() * (enCodingTypes.length));
                    if(ran != i) {
                        encode.setSelectedIndex(ran);
                    }
                    else{

                    }
                }
            }
        });
        encode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (encode.getSelectedIndex() == code.getSelectedIndex()){
                    int i = encode.getSelectedIndex();
                    int ran = (int)(Math.random() * (codingTypes.length));
                    if(ran != i) {
                        code.setSelectedIndex(ran);
                    }
                    else{

                    }
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
    private MouseListener getOpenButtonListener() {
        return new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                JFileChooser dialog = new JFileChooser();
                dialog.showOpenDialog(window);
                var file = dialog.getSelectedFile();
                if(!(file == null)) {
                    if (file.isFile() && file.canRead()) {
                        FileWork f = new FileWork(file.getPath());
                        try {
                            inputTextArea.setText(f.Read());
                        } catch (IOException e) {
                            inputTextArea.setText(e.getMessage());
                        }
                    }
                }else{
                    return;
               }
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {}

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {}

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {
                //Open.setText("Открыть");
            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {
                //Open.setText("Open");
            }
        };
    }
    private MouseListener getSaveButtonListener() {
        return new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                if (outputTextArea != null) {
                    JFileChooser dialog = new JFileChooser();
                    dialog.showSaveDialog(window);
                    var file = dialog.getSelectedFile();
                    if((file != null)) {
                        FileWork f = new FileWork(file.getPath());
                        try {
                            f.Write(outputTextArea.getText());
                        } catch (IOException e) {
                            outputTextArea.setText(e.getMessage());
                        }
                    }else{
                        return;
                    }
                }
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {}

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {
                //Save.setText("Сохранить");
            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {
                //Save.setText("Save");
            }
        };
    }
    private MouseListener getDecodeButtonListener() {
        return new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                if (inputTextArea != null) {
                    outputTextArea.setText(null);
                    if (code.getSelectedItem().toString().equals("base64")) {
                        if (encode.getSelectedItem().toString().equals("обычный")) {
                            //0KXQvtGA0L7RiNC+INC20LjQstC10YIg0L3QsCDRgdCy0LXRgtC1INCS0LjQvdC90Lgg0J/Rg9GFIQ==
                            Base_64 b = new Base_64();
                            outputTextArea.append(b.encodeFromBase64(inputTextArea.getText()));
                        } else if (encode.getSelectedItem().toString().equals("JSon")) {
                            Base_64 b = new Base_64();
                            outputTextArea.append(b.encodeFromBase64(inputTextArea.getText()));
                        } else {
                            outputTextArea.append(inputTextArea.getText());
                        }
                    } else if (code.getSelectedItem().toString().equals("JSon")) {
                        if (encode.getSelectedItem().toString().equals("base64")) {
                            Base_64 b = new Base_64();
                            outputTextArea.append(b.codeToBase64(inputTextArea.getText()));
                        } else {
                            outputTextArea.append(inputTextArea.getText());
                        }
                    } else if (code.getSelectedItem().toString().equals("обычный")) {
                        if (encode.getSelectedItem().toString().equals("base64")) {
                            Base_64 b = new Base_64();
                            outputTextArea.append(b.codeToBase64(inputTextArea.getText()));
                        } else {
                            outputTextArea.append(inputTextArea.getText());
                        }
                    }
                }
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {}

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {
                //Build.setText("Перекодировать");
            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {
                //Build.setText("Decode");
            }
        };
    }

    private MouseListener getCopyButtonListener() {
        return new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                if (outputTextArea != null) {
                    String copyText = outputTextArea.getText();
                    StringSelection stringSelection = new StringSelection(copyText);
                    Clipboard ctrlC = Toolkit.getDefaultToolkit().getSystemClipboard();
                    ctrlC.setContents(stringSelection, null);
                } else {

                }
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {}

            @Override
            public void mouseReleased(MouseEvent mouseEvent) { }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {
                //Copy.setText("Копировать");
            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {
                //Copy.setText("Copy");
            }
        };
    }
    private MouseListener getFormateButtonListener() {
        return new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {

            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {}

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {}

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {
                //Open.setText("форматировать");
            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {
                //Open.setText("Formate");
            }
        };
    }
}
