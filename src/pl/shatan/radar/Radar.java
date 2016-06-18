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

    private Unit selectedUnit;
    private boolean unitDrag = false;

    /**
     * Default constructor with 100 units and default Radar name.
     */
    public Radar()
    {
        this.name = "World Radar";
        this.units = new ArrayList<Unit>(100);
        this.selectedUnit = null;
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

    public void select(Unit unit) {
        this.selectedUnit = unit;
    }

    public AirPlane spawnAirplane(double x, double y) {
        AirPlane unit = new AirPlane(this, x, y);
        this.units.add(unit);
        return unit;
    }

    public GroundUnit spawnGroundUnit(double x, double y) {
        GroundUnit unit = new GroundUnit(this, x, y);
        this.units.add(unit);
        return unit;
    }

    public Unit getSelectedUnit()
    {
        return selectedUnit;
    }

    public boolean isUnitDragActive()
    {
        return this.unitDrag;
    }

    public void startUnitDrag() {
        this.unitDrag = true;
    }

    public void stopUnitDrag()
    {
        this.unitDrag = false;
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
