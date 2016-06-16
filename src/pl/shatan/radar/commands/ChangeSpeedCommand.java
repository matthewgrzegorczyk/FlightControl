package pl.shatan.radar.commands;

import pl.shatan.radar.AirUnit;

/**
 * Command for changing unit speed.
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
