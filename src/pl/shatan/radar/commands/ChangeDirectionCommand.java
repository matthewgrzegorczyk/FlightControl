package pl.shatan.radar.commands;

import pl.shatan.radar.AirUnit;

/**
 * Command for changing unit direction.
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
