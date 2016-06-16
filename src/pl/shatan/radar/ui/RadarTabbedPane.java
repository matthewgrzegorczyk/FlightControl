package pl.shatan.radar.ui;

import pl.shatan.radar.ui.listeners.AddAirUnitListener;

import javax.swing.*;
import java.awt.*;

public class RadarTabbedPane extends JTabbedPane {
    private RadarGUI radarFrame;
    private JPanel groundUnitsPanel;
    private JPanel airUnitsPanel;
    private JPanel unitInfoPanel;

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

        this.add("Air Units", this.groundUnitsPanel);
        this.add("Ground Units", this.airUnitsPanel);
        this.add("Unit Info", this.unitInfoPanel);
    }

    private void initAirUnitsPanel()
    {
        this.groundUnitsPanel.setLayout(new GridLayout(4, 2));
        JButton addAirUnitButton = new JButton("Add Unit");
        addAirUnitButton.addActionListener(new AddAirUnitListener(this.radarFrame, addAirUnitButton));
        this.groundUnitsPanel.add(addAirUnitButton);
    }
    private void initGroundUnitsPanel()
    {
        // TODO: Implement all the forms.
    }

}
