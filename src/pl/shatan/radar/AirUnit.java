package pl.shatan.radar;

import javafx.geometry.Point3D;
import pl.shatan.radar.commands.Command;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.font.LineMetrics;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.util.ArrayList;

/**
 * Created by ShataN_2 on 21/04/2016.
 */
public class AirUnit extends Unit {
    public static double maxSpeed = 4;
    public static double maxDirection = 360;

    private final String FLIGHTER_ICON = "\uF0FB";
    private final char FLIGHTER_CHAR = '\uF0FB';

    /**
     * Unit unique id.
     */
    private String guid;

    /**
     * Air unit direction as an angle from 0 to 360 on X axis.
     */
    private double direction;
    private double deltaDirection;

    /**
     * Air unit speed.
     */
    private double speed;
    private double deltaSpeed;

    private ArrayList<Command> commands;

    public AirUnit()
    {
        this.direction = 0;
        this.speed = 1.5;
        this.setRadius(50);
    }

    public AirUnit(double x, double y, double z)
    {
        this();
        this.setPosition(x, y, z);
    }

    /**
     * Get unit unique ID.
     * @return String
     */
    public String getGuid() {
        return guid;
    }

    /**
     * Set unit unique ID.
     * @param guid
     */
    public void setGuid(String guid) {
        this.guid = guid;
    }

    public double getDirection() {
        return direction;
    }

    public void setDirection(double dir) {
        deltaDirection = dir - direction;
    }

    public double getSpeed() { return speed; }

    public void setSpeed(double speed) { deltaSpeed = speed - this.speed; }

    public void addCommand(Command command) {
        commands.add(command);
    }

    public void update() {
        for(Command command : commands) {
            command.execute(this);
        }
        commands.clear();
        if(deltaDirection != 0) {
            direction += deltaDirection / 10;
            deltaDirection /= 10;
            if(deltaDirection < 0.0001) {
                deltaDirection = 0;
            }
        }
        if(deltaSpeed != 0) {
            speed += deltaSpeed / 10;
            deltaSpeed /= 10;
            if(deltaSpeed < 0.0001) {
                deltaSpeed = 0;
            }
        }
    }

    @Override
    public void draw(Graphics2D g) {
        AffineTransform defaultTransform = g.getTransform();
        FontMetrics fontMetrics = g.getFontMetrics();
        FontRenderContext fontRenderContext = g.getFontRenderContext();
        LineMetrics lineMetrics = g.getFont().getLineMetrics(this.FLIGHTER_ICON, fontRenderContext);
        float realHeight = fontMetrics.getMaxAscent() - 8;

        g.translate((int) getPosition().getX(), (int) getPosition().getY());
        g.rotate(Math.toRadians(getDirection()));

        // Sets the color to pink if unit is selected.
        if(this.isSelected()) {
            g.setColor(Color.pink);
        }
        else {
            g.setColor(Color.white);
        }

        g.drawString(this.FLIGHTER_ICON, -fontMetrics.charWidth(this.FLIGHTER_CHAR) / 2, realHeight / 2);
        // temporary red dot, is a center point of airplane
        g.setColor(Color.red);
        g.drawOval(-1, -1, 2, 2);
//        g.drawOval(-this.getRadius()/2, -this.getRadius()/2, this.getRadius(), this.getRadius());
        g.setTransform(defaultTransform);
    }

    public void move() {
        double x, y, z;
        x = this.getPosition().getX();
        y = this.getPosition().getY();
        z = this.getPosition().getZ();

        x += Math.cos(Math.toRadians(this.direction)) * this.speed;
        y += Math.sin(Math.toRadians(this.direction)) * this.speed;
        this.setPosition(x, y, z);
    }

    public static AirUnit createRandomAtPosition(double x, double y, double z)
    {
        AirUnit unit = new AirUnit(x, y, z);
        unit.setSpeed(Math.random() * AirUnit.maxSpeed);
        unit.setDirection(Math.random() * AirUnit.maxDirection);

        return unit;
    }

    public boolean detectCollision(Unit unit) {
        return (this.getRadius() + unit.getRadius()) <= this.distance(unit);
    }
}
