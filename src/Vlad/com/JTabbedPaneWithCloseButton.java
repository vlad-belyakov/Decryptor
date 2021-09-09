package Vlad.com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JTabbedPaneWithCloseButton {

    static JLabel titleLbl;
    public static JPanel getTitlePanel(final JTabbedPane tabbedPane, final JPanel panel, String title) {
        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        titlePanel.setOpaque(false);
        titleLbl = new JLabel(title);
        titleLbl.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
        titlePanel.add(titleLbl);
        JButton closeButton = new JButton("x");

        closeButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = tabbedPane.getTabCount();
                tabbedPane.remove(panel);
                PageDenisInterface.d--;
            }
        });
        titlePanel.add(closeButton);

        return titlePanel;
    }
    public void setTitle(int select, String title, JTabbedPane tabs, JPanel panell){
        JLabel tit = new JLabel(title);
        tabs.setTabComponentAt(select, getTitlePanel(tabs, panell, title));
    }
}