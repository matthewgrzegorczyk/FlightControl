package pl.shatan.radar.surface;

import javafx.geometry.Point3D;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

class Surface extends JPanel {

    private void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawString("Java 2D", 50, 50);
        Point3D point = new Point3D(10, 10, 10);

        g2d.drawLine((int) point.getX(), (int) point.getY(), (int) point.getX(), (int) point.getY());
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.doDrawing(g);
    }
}