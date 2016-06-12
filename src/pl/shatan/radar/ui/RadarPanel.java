package pl.shatan.radar.ui;

import pl.shatan.radar.AirUnit;
import pl.shatan.radar.Radar;
import pl.shatan.radar.Unit;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;

public class RadarPanel extends JPanel {
    private Radar radar;
    private BufferedImage mapImage;
    private double scale;
    private int frames;
    public int width;
    public int height;

    RadarPanel() {
        this.width = 600;
        this.height = 800;
        this.mapImage = null;
        this.radar = null;
        this.scale = 0.0;
        this.frames = 0;
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

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        // Draw a black background that is as big as the game board
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
        // Set rendering rules
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        // Set the drawing color to white
        g2d.setPaint(Color.WHITE);

        // Set scaling level.
        g2d.scale(this.scale, this.scale);

        this.drawBackground(g2d);
        int i = 0;
        this.frames++;

        AffineTransform defaultTransform = g2d.getTransform();
        for (Unit unit : radar.getUnits()) {
            if(i++ == 0 && this.frames < 40) {
                double dir = ((AirUnit) unit).getDirection();
                ((AirUnit) unit).setDirection(dir + 1);
            }
//            g2d.drawLine((int) unit.getPosition().getX(), (int) unit.getPosition().getY(), (int) unit.getPosition().getX(), (int) unit.getPosition().getY());
//            g2d.fillOval((int) unit.getPosition().getX(), (int) unit.getPosition().getY(), 5, 5);
            g2d.setFont(new Font("FontAwesome", Font.PLAIN, 40));
            if (unit instanceof AirUnit) {
//                g2d.rotate(Math.toRadians(((AirUnit)unit).getDirection()));
                g2d.translate((int) unit.getPosition().getX(), (int) unit.getPosition().getY());
                g2d.drawString("\uf0fb", (int) unit.getPosition().getX(), (int) unit.getPosition().getY());
                ((AirUnit) unit).move();
                g2d.setTransform(defaultTransform);
            }
        }
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
}
