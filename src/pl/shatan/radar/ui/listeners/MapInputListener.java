package pl.shatan.radar.ui.listeners;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import pl.shatan.radar.ui.RadarGUI;

public class MapInputListener implements ActionListener {

    private File map;
    private JFileChooser mapInput;
    private JMenuItem menuItem;
    private RadarGUI radarFrame;

    public MapInputListener(RadarGUI myFrame, JMenuItem myMenuItem) {
        this.radarFrame = myFrame;
        this.menuItem = myMenuItem;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.menuItem) {
            mapInput = new JFileChooser(".");
            mapInput.showOpenDialog(this.radarFrame);
            this.radarFrame.setRadarBackground(mapInput.getSelectedFile());
        }
    }
}