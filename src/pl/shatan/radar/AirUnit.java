package pl.shatan.radar;

import javafx.geometry.Point3D;

/**
 * Created by ShataN_2 on 21/04/2016.
 */
public class AirUnit extends Unit {
    /**
     * Unit unique id.
     */
    private String guid;

    /**
     * Air unit direction as an angle from 0 to 360 on X axis.
     */
    private double directionX;

    /**
     * Air unit direction as an angle from 0 to 360 on Y axis.
     */
    private double directionY;

    /**
     * Air unit direction as an angle from 0 to 360 on Z axis.
     */
    private double directionZ;

    /**
     * Air unit speed.
     */
    private double speed;

    public AirUnit()
    {
        // TODO: Implement AirUnit constructor.
    }

    public AirUnit(double x, double y, double z)
    {
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

    public void simulateFlight()
    {

    }
}
