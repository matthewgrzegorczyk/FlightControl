package pl.shatan.radar.ui.listeners;

import pl.shatan.radar.ui.RadarPanel;

import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class RadarPanelMouseWheelListener implements MouseWheelListener {

    private RadarPanel radarPanel;

    public RadarPanelMouseWheelListener(RadarPanel panel)
    {
        this.radarPanel = panel;
    }

    /**
     * Invoked when the mouse wheel is rotated.
     *
     * @param e
     * @see MouseWheelEvent
     */
    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        if(e.getSource() == this.radarPanel) {
            double currentScale = this.radarPanel.getScale();
            double step = e.getPreciseWheelRotation() * -1;
            if ((currentScale >= 1 && currentScale < 2 && step > 0) || (currentScale > 1 && currentScale <= 2.1 && step < 0)) {
                double newScale = currentScale + step * RadarPanel.mouseWheelStep;
                this.radarPanel.setScale(newScale);
            }
        }
    }
}
