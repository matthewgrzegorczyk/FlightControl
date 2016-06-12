package pl.shatan.radar;

import javafx.geometry.Point3D;

/**
 * Created by ShataN_2 on 21/04/2016.
 */
public class Unit {
    private Point3D point;
    public static final int closeDistance = 100;

    public Unit()
    {
        this.setPosition(0, 0, 0);
    }

    public Unit(double x, double y, double z)
    {
        this.setPosition(x, y, z);
    }

    public String position()
    {
        return this.point.toString();
    }

    public void setPosition(double x, double y, double z)
    {
        this.point = new Point3D(x, y, z);
    }
    public Point3D getPosition() { return this.point; }

    public boolean isClose(Unit unit)
    {
        return this.distance(unit) <= this.closeDistance;
    }

    public double distance(Unit unit)
    {
        return this.point.distance(unit.point);
    }

    @Override
    public String toString()
    {
        return this.getClass() + " " + this.position();
    }
}
