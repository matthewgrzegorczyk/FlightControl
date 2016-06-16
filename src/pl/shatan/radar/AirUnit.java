package pl.shatan.radar;

import javafx.geometry.Point3D;
import pl.shatan.radar.commands.Command;

import java.util.ArrayList;

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
    private double direction;
    private double deltaDirection;

    /**
     * Air unit speed.
     */
    private double speed;
    private double deltaSpeed;

    private ArrayList<Command> commands;

    public AirUnit()
    {
        this.direction = 0;
        this.speed = 1.5;
    }

    public AirUnit(double x, double y, double z)
    {
        this();
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

    public double getDirection() {
        return direction;
    }

    public void setDirection(double dir) {
        deltaDirection = dir - direction;
    }

    public double getSpeed() { return speed; }

    public void setSpeed(double speed) { deltaSpeed = speed - this.speed; }

    public void addCommand(Command command) {
        commands.add(command);
    }

    public void update() {
        for(Command command : commands) {
            command.execute(this);
        }
        commands.clear();
        if(deltaDirection != 0) {
            direction += deltaDirection / 10;
            deltaDirection /= 10;
            if(deltaDirection < 0.0001) {
                deltaDirection = 0;
            }
        }
        if(deltaSpeed != 0) {
            speed += deltaSpeed / 10;
            deltaSpeed /= 10;
            if(deltaSpeed < 0.0001) {
                deltaSpeed = 0;
            }
        }
    }

    public void move() {
        double x, y, z;
        x = this.getPosition().getX();
        y = this.getPosition().getY();
        z = this.getPosition().getZ();

        x += Math.cos(Math.toRadians(this.direction)) * this.speed;
        y += Math.sin(Math.toRadians(this.direction)) * this.speed;
        this.setPosition(x, y, z);
    }
}
