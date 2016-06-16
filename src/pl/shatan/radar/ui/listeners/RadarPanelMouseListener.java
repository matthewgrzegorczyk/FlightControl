package pl.shatan.radar.ui.listeners;


import pl.shatan.radar.Unit;
import pl.shatan.radar.ui.RadarGUI;
import pl.shatan.radar.ui.RadarPanel;
import pl.shatan.radar.ui.RadarPanelContextMenu;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class RadarPanelMouseListener implements MouseListener {
    private RadarPanel radarPanel;

    public RadarPanelMouseListener(RadarPanel panel)
    {
        this.radarPanel = panel;
    }

    /**
     * Invoked when the mouse button has been clicked (pressed
     * and released) on a component.
     *
     * @param e
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == this.radarPanel)
        {
            RadarGUI radarGUI = (RadarGUI) SwingUtilities.getWindowAncestor(this.radarPanel);

            for (Unit unit : radarGUI.getRadarInstance().getUnits()) {
                if(unit.intersects(e.getX(), e.getY())) {
                    unit.select();
                    System.out.println(unit.getRadius());
                    return;
                }
                else {
                    radarGUI.getRadarInstance().select(null);
                }
            }
        }
    }

    /**
     * Invoked when a mouse button has been pressed on a component.
     *
     * @param e
     */
    @Override
    public void mousePressed(MouseEvent e) {
//        System.out.println(e);
        if (e.isPopupTrigger()) {
            RadarPanelContextMenu menu = new RadarPanelContextMenu(this.radarPanel, e.getX(), e.getY(), 0.0);
            menu.show(e.getComponent(), e.getX(), e.getY());
        }
    }

    /**
     * Invoked when a mouse button has been released on a component.
     *
     * @param e
     */
    @Override
    public void mouseReleased(MouseEvent e) {
//        System.out.println(e);
        if (e.isPopupTrigger()) {
            RadarPanelContextMenu menu = new RadarPanelContextMenu(this.radarPanel, e.getX(), e.getY(), 0.0);
            menu.show(e.getComponent(), e.getX(), e.getY());
        }
    }

    /**
     * Invoked when the mouse enters a component.
     *
     * @param e
     */
    @Override
    public void mouseEntered(MouseEvent e) {
//        System.out.println(e);
    }

    /**
     * Invoked when the mouse exits a component.
     *
     * @param e
     */
    @Override
    public void mouseExited(MouseEvent e) {
//        System.out.println(e);
    }
}
