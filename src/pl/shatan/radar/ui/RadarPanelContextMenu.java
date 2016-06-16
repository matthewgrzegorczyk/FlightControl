package pl.shatan.radar.ui;


import pl.shatan.radar.ui.listeners.AddAirUnitListener;

import javax.swing.*;

public class RadarPanelContextMenu extends JPopupMenu {
    private JMenuItem addAirUnitMenu;
    private JMenuItem addGroundUnitMenu;

    public RadarPanelContextMenu(RadarPanel radar, double x, double y, double z)
    {
        this.addAirUnitMenu = new JMenuItem("Add Air Unit");
        AddAirUnitListener addAirUnitListener = new AddAirUnitListener((RadarGUI) SwingUtilities.getWindowAncestor(radar), this.addAirUnitMenu, x, y, z);
        this.addAirUnitMenu.addActionListener(addAirUnitListener);

        this.addGroundUnitMenu = new JMenuItem("Add Ground Unit");

        this.add(this.addAirUnitMenu);
        this.add(this.addGroundUnitMenu);
    }
}
