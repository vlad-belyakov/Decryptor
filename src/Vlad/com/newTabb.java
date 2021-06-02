package Vlad.com;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class newTabb extends JFrame {
    private JTabbedPane tabs;
    public JPanel tab;
    protected JTextArea inputTextArea;
    private JButton copy;
    private JPanel panel;
    private JButton copyButton;
    private JButton openButton;
    private JButton saveButton;
    private JButton decodeB64;
    private JButton decodeJson;
    private String nameOfTab;


    public newTabb(JTabbedPane tabz) throws IOException {


        this.add(panel);
        this.setSize(300, 300);
        this.pack();
        this.setVisible(false);
        inputTextArea.setLineWrap(true);
        inputTextArea.setWrapStyleWord(true);

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
        decodeJson.addActionListener(click -> {
            if (inputTextArea != null){
                String c = inputTextArea.getText();
                //inputTextArea.setText(null);
                Base_64 b = new Base_64();
                JSon_ j = new JSon_();
                inputTextArea.setText(j.prettyView(b.encodeFromBase64(c)));
            }
        });
        decodeB64.addActionListener(click -> {
            if (inputTextArea != null){
                BufferedReader i = new BufferedReader(new InputStreamReader(System.in));
                String c = inputTextArea.getText();
                //inputTextArea.setText(null);
                Base_64 b = new Base_64();
                inputTextArea.setText(b.encodeFromBase64(c));
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
        /*copyButton.addActionListener(click -> {
            if (inputTextArea != null) {
                String copyText = inputTextArea.getText();
                StringSelection stringSelection = new StringSelection(copyText);
                Clipboard ctrlC = Toolkit.getDefaultToolkit().getSystemClipboard();
                ctrlC.setContents(stringSelection, null);
            }
        });*/

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
