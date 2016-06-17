package pl.shatan.radar.ui.listeners;

import pl.shatan.radar.AirUnit;
import pl.shatan.radar.Unit;
import pl.shatan.radar.commands.ChangeDirectionCommand;
import pl.shatan.radar.commands.ChangeSpeedCommand;
import pl.shatan.radar.ui.RadarGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UnitChangeSpeedListener implements ActionListener {
    private RadarGUI radarFrame;
    private JButton button;
    private JTextField speed;

    public UnitChangeSpeedListener(JButton unitChangeDirectionButton, RadarGUI radar, JTextField speed)
    {
        this.button = unitChangeDirectionButton;
        this.radarFrame = radar;
        this.speed = speed;
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button) {
            AirUnit unit = (AirUnit) this.radarFrame.getRadarInstance().getSelectedUnit();
            if (unit != null) {

                // Parse unit speed from text input.
                try {
                    double unitSpeed = Double.parseDouble(this.speed.getText());
                    ChangeSpeedCommand changeSpeed = new ChangeSpeedCommand(unitSpeed);
                    unit.addCommand(changeSpeed);
                }
                catch(NullPointerException|NumberFormatException exception) {
                    JOptionPane.showMessageDialog(this.radarFrame, "Invalid speed typed. Please type in a number with dot as separator. \n" + exception.getMessage(), "Parsing error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
}
