package pl.shatan.radar;

/**
 * Created by ShataN_2 on 12/05/2016.
 */
public class AirPlane extends AirUnit {
    private int capacity;

    public AirPlane(Radar radar) {
        super(radar);
    }

    public AirPlane(Radar parent, double x, double y) {
        super(parent, x, y);
    }
}
