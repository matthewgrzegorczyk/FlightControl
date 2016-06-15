package pl.shatan.radar.ui;

import javax.swing.*;

public class RadarTabbedPane extends JTabbedPane {
    public JPanel getGroundUnitsPanel() {
        return groundUnitsPanel;
    }

    public void setGroundUnitsPanel(JPanel groundUnitsPanel) {
        this.groundUnitsPanel = groundUnitsPanel;
    }

    public JPanel getAirUnitsPanel() {
        return airUnitsPanel;
    }

    public JPanel getUnitInfoPanel() {
        return unitInfoPanel;
    }

    public void setUnitInfoPanel(JPanel unitInfoPanel) {
        this.unitInfoPanel = unitInfoPanel;
    }

    private JPanel groundUnitsPanel;
    private JPanel airUnitsPanel;
    private JPanel unitInfoPanel;

    RadarTabbedPane()
    {
        this.groundUnitsPanel = new JPanel();
        this.airUnitsPanel = new JPanel();
        this.unitInfoPanel = new JPanel();
    }


}
