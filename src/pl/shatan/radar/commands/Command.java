package pl.shatan.radar.commands;

import pl.shatan.radar.AirUnit;

/**
 * Unit commands interface.
 */
public interface Command {
    public void execute(AirUnit unit);
}
