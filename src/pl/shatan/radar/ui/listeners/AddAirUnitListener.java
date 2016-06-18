package pl.shatan.radar.ui.listeners;

import pl.shatan.radar.AirUnit;
import pl.shatan.radar.Radar;
import pl.shatan.radar.ui.RadarGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddAirUnitListener implements ActionListener {
    private RadarGUI radarFrame;
    private JButton addAirUnitButton;
    private JMenuItem addAirUnitMenuItem;
    private double x, y, z;

    public AddAirUnitListener(RadarGUI frame, JButton button)
    {
        this.radarFrame = frame;
        this.addAirUnitButton = button;
    }

    public AddAirUnitListener(RadarGUI frame, JMenuItem item, double x, double y, double z)
    {
        this.radarFrame = frame;
        this.addAirUnitMenuItem = item;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.addAirUnitButton) {
            Radar radar = radarFrame.getRadarInstance();

            double x = Math.random() * radarFrame.getWidth(),
                    y = Math.random() * radarFrame.getHeight(),
                    z = 0;

            AirUnit unit = radar.spawnAirplane(x, y);
            unit.setDirection(Math.random() * 360);
        }

        if (e.getSource() == this.addAirUnitMenuItem) {
            Radar radar = radarFrame.getRadarInstance();
            AirUnit unit = radar.spawnAirplane(this.x, this.y);
            unit.setDirection(Math.random() * 360);
        }
    }
}
