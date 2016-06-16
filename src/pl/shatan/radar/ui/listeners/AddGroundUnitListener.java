package pl.shatan.radar.ui.listeners;

import pl.shatan.radar.AirUnit;
import pl.shatan.radar.GroundUnit;
import pl.shatan.radar.Radar;
import pl.shatan.radar.ui.RadarGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddGroundUnitListener implements ActionListener {
    private RadarGUI radarFrame;
    private JButton addAirUnitButton;

    public AddGroundUnitListener(RadarGUI frame, JButton button)
    {
        this.radarFrame = frame;
        this.addAirUnitButton = button;
    }
    /**
     * Invoked when an action occurs.
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.addAirUnitButton) {
            Radar radar = radarFrame.getRadarInstance();

            double x = Math.random() * radarFrame.getWidth(),
                    y = Math.random() * radarFrame.getHeight(),
                    z = 0;

            GroundUnit unit = new GroundUnit(x, y);

            radar.addUnit(unit);
        }
    }
}
