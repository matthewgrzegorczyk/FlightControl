package pl.shatan.radar;

import javafx.geometry.Point3D;

import java.awt.*;

/**
 * Created by ShataN_2 on 21/04/2016.
 */
public class Unit {
    private Point3D point;
    private boolean selected;
    public static final int closeDistance = 100;

    /**
     * Unit default constructor which sets unit at position (0, 0, 0)
     */
    public Unit()
    {
        this.setPosition(0, 0, 0);
        this.selected = false;
    }

    /**
     * Unit constructor with setting position at points x, y, z.
     * @param x
     * @param y
     * @param z
     */
    public Unit(double x, double y, double z)
    {

        this.setPosition(x, y, z);
        this.selected = false;
    }

    /**
     * Unit position based on the point location.
     * @return String
     */
    public String position()
    {
        return this.point.toString();
    }

    /**
     * Sets unit position.
     * @param x
     * @param y
     * @param z
     */
    public void setPosition(double x, double y, double z)
    {
        this.point = new Point3D(x, y, z);
    }

    /**
     * Gets Unit position based on Point3D.
     * @return Point3D
     */
    public Point3D getPosition() { return this.point; }

    /**
     * Check if units are close to each other which may occur in a collision.
     * @param unit
     * @return True if unit is close the the Unit
     */
    public boolean isClose(Unit unit)
    {
        return this.distance(unit) <= Unit.closeDistance;
    }

    /**
     * Distance from unit to unit.
     * @param unit
     * @return double
     */
    public double distance(Unit unit)
    {
        return this.point.distance(unit.point);
    }

    @Override
    public String toString()
    {
        return this.getClass() + " " + this.position();
    }

    /**
     * Checks if Unit is selected.
     * @return boolean
     */
    public boolean isSelected()
    {
        return this.selected;
    }

    /**
     * Set Unit as selected.
     */
    public void select()
    {
        this.selected = true;
    }

    /**
     * Set Unit as not selected.
     */
    public void deselect()
    {
        this.selected = false;
    }

    public void draw(Graphics2D g) {}
}
