package pl.shatan.radar.commands;

import pl.shatan.radar.AirUnit;

/**
 * Created by SwitchiX on 2016-06-16.
 */
public class ChangeDirectionCommand implements Command
{
    private double direction;

    public ChangeDirectionCommand(double direction) {
        this.direction = direction;
    }

    public void execute(AirUnit unit) {
        unit.setDirection(direction);
    }
}
