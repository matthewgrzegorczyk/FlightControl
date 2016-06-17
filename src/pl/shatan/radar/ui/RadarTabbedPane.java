package pl.shatan.radar.ui;

import pl.shatan.radar.Unit;
import pl.shatan.radar.commands.ChangeDirectionCommand;
import pl.shatan.radar.ui.listeners.AddAirUnitListener;
import pl.shatan.radar.ui.listeners.UnitChangeDirectionListener;
import pl.shatan.radar.ui.listeners.UnitChangeSpeedListener;

import javax.swing.*;
import javax.xml.soap.Text;
import java.awt.*;

public class RadarTabbedPane extends JTabbedPane {
    private RadarGUI radarFrame;
    private JPanel groundUnitsPanel;
    private JPanel airUnitsPanel;
    private JPanel unitInfoPanel;

    private JTextField airUnitX;
    private JTextField airUnitY;
    private JTextField airUnitZ;
    private JTextField airUnitSpeed;
    private JTextField airUnitDirection;
    private JButton addAirUnitButton;

    private JTextField groundUnitX;
    private JTextField groundUnitY;
    private JTextField groundUnitZ;

    private JTextArea unitInfo;
    private JButton unitChangeDirectionButton;
    private JButton unitChangeSpeedButton;
    private JTextField unitDirectionAngle;
    private JTextField unitSpeed;

    public RadarTabbedPane(RadarGUI frame)
    {
        this.radarFrame = frame;
        initUI();
    }

    public JPanel getGroundUnitsPanel() {
        return groundUnitsPanel;
    }

    public JPanel getAirUnitsPanel() {
        return airUnitsPanel;
    }

    public JPanel getUnitInfoPanel() {
        return unitInfoPanel;
    }

    public void initUI()
    {
        this.groundUnitsPanel = new JPanel();
        this.airUnitsPanel = new JPanel();
        this.unitInfoPanel = new JPanel();

        this.initAirUnitsPanel();
        this.initUnitInfoPanel();

        this.add("Air Units", this.airUnitsPanel);
        this.add("Ground Units", this.groundUnitsPanel);
        this.add("Unit Info", this.unitInfoPanel);
    }

    private void initAirUnitsPanel()
    {
        this.airUnitsPanel.setLayout(new GridLayout(10, 15, 0, 30));
        this.airUnitX = new JTextField("X", 1);
        this.airUnitY = new JTextField("Y", 1);
        this.airUnitZ = new JTextField("Z", 1);

        this.airUnitsPanel.add(this.airUnitX);
        this.airUnitsPanel.add(this.airUnitY);
        this.airUnitsPanel.add(this.airUnitZ);

        // Add Air Unit setup and register listener.
        this.addAirUnitButton = new JButton("Add Unit");
        this.addAirUnitButton.addActionListener(new AddAirUnitListener(this.radarFrame, this.addAirUnitButton));

        this.airUnitsPanel.add(addAirUnitButton);
    }
    private void initGroundUnitsPanel()
    {
    }

    private void initUnitInfoPanel()
    {
        this.unitInfoPanel.setLayout(new GridLayout(10, 20, 0, 30));
        this.unitInfo = new JTextArea(8, 25);
        this.unitInfo.setLineWrap(true);
        this.unitInfo.setText("No Unit selected.");

        this.unitDirectionAngle = new JTextField("0");
        this.unitSpeed = new JTextField("0");

        // Button initializations.
        this.unitChangeDirectionButton = new JButton("Change direction");
        this.unitChangeDirectionButton.addActionListener(new UnitChangeDirectionListener(this.unitChangeDirectionButton, this.radarFrame, this.unitDirectionAngle));
        this.unitChangeSpeedButton = new JButton("Change speed");
        this.unitChangeSpeedButton.addActionListener(new UnitChangeSpeedListener(this.unitChangeSpeedButton, this.radarFrame, this.unitSpeed));

        // Adding forms to the panel.
        this.unitInfoPanel.add(this.unitInfo);
        this.unitInfoPanel.add(this.unitDirectionAngle);
        this.unitInfoPanel.add(unitChangeDirectionButton);
        this.unitInfoPanel.add(this.unitSpeed);
        this.unitInfoPanel.add(this.unitChangeSpeedButton);
    }

    public void updateSelectedUnitInfo()
    {
        Unit selectedUnit = this.radarFrame.getRadarInstance().getSelectedUnit();
        if (selectedUnit != null) {
            String output = selectedUnit.position(true);
            this.unitInfo.setText(output);
        }
        else {
            this.unitInfo.setText("No unit selected.");
        }
    }

}
