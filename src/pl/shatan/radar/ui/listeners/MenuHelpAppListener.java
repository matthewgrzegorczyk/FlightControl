package pl.shatan.radar.ui.listeners;

import pl.shatan.radar.ui.RadarGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuHelpAppListener implements ActionListener {
    private RadarGUI radarFrame;
    private JMenuItem aboutMI;

    public MenuHelpAppListener(RadarGUI frame, JMenuItem aboutMenuItem) {
        this.radarFrame = frame;
        this.aboutMI = aboutMenuItem;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.aboutMI) {
            JOptionPane.showMessageDialog(this.radarFrame, "Takie tam about.", "About", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
