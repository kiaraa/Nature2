package Entity;

import world.World;
import world.WorldUnit;

import java.awt.*;
import java.util.Random;

public class Creature extends Entity {
    private final int speed;
    private Color color = new Color(0,0,255);
    private WorldUnit currentUnit;
    private Random randy;
    private World world;

    public Creature(World world, WorldUnit currentUnit, int speed) {
        super();
        this.currentUnit= currentUnit;
        this.speed = speed;
        this.randy = new Random();
        this.world = world;
    }

    public Color getColor() {
        return this.color;
    }

    public WorldUnit getCurrentUnit() {
        return this.currentUnit;
    }

    public void move() {
        int [] currentCoords = currentUnit.getCoordinates();
        int [] newCoords = new int [2];

        int xUnitsToMove = randy.nextInt(speed) + 1;
        int yUnitsToMove = randy.nextInt(speed) + 1;

        boolean xMovementIsPositive = randy.nextBoolean();
        boolean yMovementIsPositive = randy.nextBoolean();

        if (xMovementIsPositive) {
            newCoords[0] = currentCoords[0] + xUnitsToMove;
        } else {
            newCoords[0] = currentCoords[0] - xUnitsToMove;
        }

        if (yMovementIsPositive) {
            newCoords[1] = currentCoords[1] + yUnitsToMove;
        } else {
            newCoords[1] = currentCoords[1] - yUnitsToMove;
        }

        try {
            world.grid[newCoords[0]][newCoords[1]].setCreatureSpace(this);
            currentUnit.setCreatureSpace(null);
            this.currentUnit = world.grid[newCoords[0]][newCoords[1]];
            return;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("A creature tried to walk off the earth.");
            this.move();
        }
    }

    public int getSpeed() {
        return this.speed;
    }
}
