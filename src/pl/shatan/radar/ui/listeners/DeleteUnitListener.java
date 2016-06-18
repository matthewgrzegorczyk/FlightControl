package pl.shatan.radar.ui.listeners;


import pl.shatan.radar.AirUnit;
import pl.shatan.radar.Radar;
import pl.shatan.radar.commands.ChangeDirectionCommand;
import pl.shatan.radar.ui.RadarGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteUnitListener implements ActionListener {
    private RadarGUI radarFrame;
    private JButton button;

    public DeleteUnitListener(JButton button, RadarGUI frame)
    {
        this.radarFrame = frame;
        this.button = button;
    }


    /**
     * Invoked when an action occurs.
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button) {
            Radar radar = this.radarFrame.getRadarInstance();
            AirUnit unit = (AirUnit) radar.getSelectedUnit();

            if (unit != null) {
                // Parse unit speed from text input.
                radar.getUnits().remove(unit);
            }
        }
    }
}
