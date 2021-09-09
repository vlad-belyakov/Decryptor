package Vlad.com;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

public class PageDenisInterface  extends JFrame{

    protected JFrame window;
    protected JTabbedPane tabs;
    private JPanel panel;
    private JTextArea inputTextArea;
    private JButton openButton;
    private JButton saveButton;
    //private JButton copyButton;
    private JButton decodeB64;
    private JButton newTab;
    private JPanel tab;
    private JButton decodeJson;
    private JButton codeB64;
    public String nameOfTab;
    public int d = 1;



    protected static void style(){
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // If Nimbus is not available, you can set the GUI to another look and feel.
        }
    }

    public PageDenisInterface() throws IOException{


        window = new JFrame("Расшифровщик");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().add(panel);
        window.setSize(1550,800);
        //window.pack();
        // делает окно по размерам GUI
        window.setVisible(true);


        inputTextArea.setLineWrap(true);
        inputTextArea.setWrapStyleWord(true);
        newTab.addMouseListener(newTabButtonListener());
        //newTabButtonListener().mouseClicked();


        codeB64.addActionListener(click ->{
            if (inputTextArea != null) {
                String c = inputTextArea.getText();
                Base_64 b = new Base_64();
                inputTextArea.setText(b.codeToBase64(c));
            }
        });
        saveButton.addActionListener(click -> {
            if (inputTextArea != null) {
                int select = tabs.getSelectedIndex();
                JFileChooser dialog = new JFileChooser();
                dialog.showSaveDialog(panel);
                var file = dialog.getSelectedFile();
                if((file != null)) {
                    FileWork f = new FileWork(file.getPath());
                    try {
                        f.Write(inputTextArea.getText());
                        nameOfTab = file.getName();
                        tabs.setTitleAt(select, nameOfTab);
                    } catch (IOException e) {
                        inputTextArea.setText(e.getMessage());
                    }
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
                    } catch (IOException e){
                        e.printStackTrace();
                    }
                }
            }
        });
        decodeB64.addActionListener(click -> {
            if (inputTextArea != null){
                String c = inputTextArea.getText();
                Base_64 b = new Base_64();
                inputTextArea.setText(b.encodeFromBase64(c));
            }
        });


        decodeJson.addActionListener(click -> {
            if (inputTextArea != null){
                String c = inputTextArea.getText();
                Base_64 b = new Base_64();
                JSon_ j = new JSon_();
                inputTextArea.setText(j.prettyView(b.encodeFromBase64(c)));
            }
        });

        this.addWindowListener(getWindowListener());

        JTabbedPaneWithCloseButton jt = new JTabbedPaneWithCloseButton();
        int select = tabs.getSelectedIndex();
        tabs.setTabComponentAt(0, jt.getTitlePanel(tabs, tab, "tab 0"));




    }

    /*private JButton closeTabM(){
        JButton XBut = new JButton();
        XBut.setText("x");
        XBut.addActionListener(click -> {
            int select = tabs.getSelectedIndex();
            if (select >= 0) {
                tabs.removeTabAt(select);
            }
            d--;
        });
        return XBut;
    }*/

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

    public MouseListener newTabButtonListener() {
        return new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                newTabb ta = null;
                try {
                    ta = new newTabb(tabs, newTabButtonListener());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                String tname = "tab" + d;
                tabs.addTab(tname, ta.tab);
                tabs.setSelectedIndex(d);
                int select = tabs.getSelectedIndex();

                /*JButton XBut = new JButton("x");
                XBut.addActionListener(click -> {
                    for (int i = 0; i < tabs.getTabCount(); i++) {
                        if(tabs.getTabComponentAt(i) == XBut){
                            tabs.removeTabAt(i);
                        }
                    }
                    d--;
                });*/

                JTabbedPaneWithCloseButton jt = new JTabbedPaneWithCloseButton();
                tabs.setTabComponentAt(select, jt.getTitlePanel(tabs, ta.tab, tname));

                d++;
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {}

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {}

            @Override
            public void mouseEntered(MouseEvent mouseEvent) { }

            @Override
            public void mouseExited(MouseEvent mouseEvent) { }
        };


    }

}
