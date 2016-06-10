package pl.shatan.radar;

import java.util.ArrayList;

/**
 * Created by ShataN_2 on 21/04/2016.
 */
public class Radar {
    /**
     * Radar name.
     */
    private String name;

    /**
     * List of units on the radar.
     */
    private ArrayList<Unit> units;

    /**
     * Default constructor with 100 units and default Radar name.
     */
    public Radar()
    {
        this.name = "World Radar";
        this.units = new ArrayList<Unit>(100);
    }

    /**
     * Inits radar. Takes radar name as parameter.
     * @param name
     */
    public Radar(String name)
    {
        this.name = name;
        this.units = new ArrayList<Unit>();
    }

    /**
     * Adds unit to the radar.
     * @param unit
     */
    public void addUnit(Unit unit)
    {
        this.units.add(unit);
    }

    /**
     * Gets units which are on the radar.
     * @return ArrayList<Unit>
     */
    public ArrayList<Unit> getUnits()
    {
        return this.units;
    }

}
