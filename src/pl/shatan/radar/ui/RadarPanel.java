package pl.shatan.radar.ui;

import pl.shatan.radar.AirUnit;
import pl.shatan.radar.Radar;
import pl.shatan.radar.Unit;
import pl.shatan.radar.ui.listeners.RadarPanelMouseListener;
import pl.shatan.radar.ui.listeners.RadarPanelMouseMotionListener;
import pl.shatan.radar.ui.listeners.RadarPanelMouseWheelListener;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;

public class RadarPanel extends JPanel {
    public static final double mouseWheelStep = 0.1;

    private Radar radar;
    private BufferedImage mapImage;
    private double scale;
    private int frames;

    public int width;
    public int height;

    private final String FLIGHTER_ICON = "\uF0FB";
    private final int FONT_SIZE = 40;

    RadarPanel() {
        this.width = 600;
        this.height = 800;
        this.mapImage = null;
        this.radar = null;
        this.scale = 1.0;
        this.frames = 0;

        // Adds mouse listener to the radar.
        addMouseListener(new RadarPanelMouseListener(this));
        addMouseMotionListener(new RadarPanelMouseMotionListener(this));
        addMouseWheelListener(new RadarPanelMouseWheelListener(this));
    }

    RadarPanel(Radar myRadar) {
        this();
        this.radar = myRadar;
    }

    RadarPanel(Radar myRadar, BufferedImage myRadarMap) {
        this();
        this.radar = myRadar;
        this.mapImage = myRadarMap;
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        // Draw a black background that is as big as the game board
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
        // Set rendering rules
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        // Set the drawing color to white
        g2d.setPaint(Color.WHITE);
        g2d.setFont(new Font("FontAwesome", Font.PLAIN, this.FONT_SIZE));

        // Set scaling level.
        g2d.scale(this.scale, this.scale);

        this.drawBackground(g2d);
        this.frames++;

        for (Unit unit : radar.getUnits()) {
            unit.update();
        }
        for (Unit unit : radar.getUnits()) {
            unit.draw(g2d);
        }
        g2d.dispose();
    }

    private void drawBackground(Graphics2D g2d) {
        // Need to use rescale with buffered image to be able to zoom in on the map.
        float[] scales = {1f, 1f, 1f};
        float[] offsets = new float[3];
        RescaleOp rop = new RescaleOp(scales, offsets, null);
        int bgX = (this.mapImage == null) ? this.getWidth() / 2 : this.getWidth() / 2 - this.mapImage.getWidth() / 2;
        int bgY = (this.mapImage == null) ? this.getHeight() / 2 : this.getHeight() / 2 - this.mapImage.getHeight() / 2;
        g2d.drawImage(this.mapImage, rop, bgX, bgY);
    }

    public void setBackgroundImage(BufferedImage image) {
        this.mapImage = image;
    }

    public double getScale() {
        return this.scale;
    }

    public void setScale(double newScale) {
        this.scale = newScale;
    }
}
