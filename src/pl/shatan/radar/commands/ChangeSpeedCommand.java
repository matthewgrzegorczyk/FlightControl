package pl.shatan.radar.commands;

import pl.shatan.radar.AirUnit;

/**
 * Created by SwitchiX on 2016-06-16.
 */
public class ChangeSpeedCommand implements Command
{
    private double speed;

    public ChangeSpeedCommand(double speed) {
        this.speed = speed;
    }

    public void execute(AirUnit unit) {
        unit.setSpeed(speed);
    }
}
