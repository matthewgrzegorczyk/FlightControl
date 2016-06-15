package pl.shatan.radar.commands;

import pl.shatan.radar.AirUnit;

/**
 * Created by SwitchiX on 2016-06-16.
 */
public interface Command {
    public void execute(AirUnit unit);
}
