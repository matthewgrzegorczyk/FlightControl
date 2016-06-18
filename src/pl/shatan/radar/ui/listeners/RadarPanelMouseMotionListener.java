package pl.shatan.radar.ui.listeners;

import pl.shatan.radar.AirUnit;
import pl.shatan.radar.Unit;
import pl.shatan.radar.ui.RadarGUI;
import pl.shatan.radar.ui.RadarPanel;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class RadarPanelMouseMotionListener implements MouseMotionListener {
    private RadarPanel radarPanel;

    public RadarPanelMouseMotionListener(RadarPanel panel)
    {
        this.radarPanel = panel;
    }

    /**
     * Invoked when a mouse button is pressed on a component and then
     * dragged.  <code>MOUSE_DRAGGED</code> events will continue to be
     * delivered to the component where the drag originated until the
     * mouse button is released (regardless of whether the mouse position
     * is within the bounds of the component).
     * <p>
     * Due to platform-dependent Drag&amp;Drop implementations,
     * <code>MOUSE_DRAGGED</code> events may not be delivered during a native
     * Drag&amp;Drop operation.
     *
     * @param e
     */
    @Override
    public void mouseDragged(MouseEvent e) {
//        System.out.println(e);
        this.dragUnitOnMouseEvent(e);
    }

    /**
     * Invoked when the mouse cursor has been moved onto a component
     * but no buttons have been pushed.
     *
     * @param e
     */
    @Override
    public void mouseMoved(MouseEvent e) {
//        System.out.println(e);
    }

    public void dragUnitOnMouseEvent(MouseEvent e) {
        if (e.getSource() == this.radarPanel) {
            RadarGUI radarGUI = (RadarGUI) SwingUtilities.getWindowAncestor(this.radarPanel);
            AirUnit unit = (AirUnit) radarGUI.getRadarInstance().getSelectedUnit();
            if (unit != null) {
                unit.setPosition(e.getX(), e.getY(), 0);
            }
        }
    }
}
