package pl.shatan.radar.ui.listeners;

import pl.shatan.radar.AirUnit;
import pl.shatan.radar.commands.ChangeDirectionCommand;
import pl.shatan.radar.ui.RadarGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UnitChangeDirectionListener implements ActionListener {
    private RadarGUI radarFrame;
    private JButton button;
    private JTextField angle;

    public UnitChangeDirectionListener(JButton unitChangeDirectionButton, RadarGUI radar, JTextField angle)
    {
        this.button = unitChangeDirectionButton;
        this.radarFrame = radar;
        this.angle = angle;
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
                    double unitAngle = Double.parseDouble(this.angle.getText());
                    ChangeDirectionCommand changeDirecton = new ChangeDirectionCommand(unitAngle);
                    unit.addCommand(changeDirecton);
                }
                catch(NullPointerException|NumberFormatException exception) {
                    JOptionPane.showMessageDialog(this.radarFrame, "Invalid direction typed. Please type in a number with dot as decimal separator. \n" + exception.getMessage(), "Parsing error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
}
