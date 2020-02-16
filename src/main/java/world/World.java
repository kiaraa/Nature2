package world;

import Entity.Creature;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class World extends JFrame {
    public final int UNIT_SIZE = 10;
    public final Random randy = new Random();

    public List<WorldUnit> unitList = new ArrayList<>();
    public WorldUnit[][] grid;
    private int width;
    private int height;

    public List<WorldUnit> getUnitList() {
        return unitList;
    }

    public WorldUnit[][] getGrid() {
        return grid;
    }

    public World(int width, int height, int initialCows) {
        this.width = width;
        this.height = height;
        this.grid = new WorldUnit[width][height];
            for(int i = 0; i < width; i++) {
                for (int j = 0; j < height; j++) {
                    WorldUnit unit = new WorldUnit();
                    this.grid[i][j] = unit;
                    unitList.add(unit);
                }
            }

        while (initialCows > 0) {
            this.initializeCow();
            initialCows --;
        }

        this.getContentPane().setBackground(new Color(50,50,50));
        setSize(width * UNIT_SIZE,(height * UNIT_SIZE) + 23);
        setVisible(true);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void initializeCow() {
        WorldUnit unitToPlaceCow = unitList.get(randy.nextInt(unitList.size() - 1));
        if (unitToPlaceCow.getCreatureSpace() == null) {
            unitToPlaceCow.setCreatureSpace(new Creature());
        } else {
            initializeCow();
        }
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        for (int i = 0; i < this.width; i++) {
            for (int j = 0; j < this.height; j++) {
                if (!(grid[i][j].getCreatureSpace() == null)) {
                    g.setColor(grid[i][j].getCreatureSpace().getColor());
                }
                g.fillRect(i * UNIT_SIZE, j * UNIT_SIZE + 23, UNIT_SIZE, UNIT_SIZE);
                g.setColor(new Color(0,0,0));
            }
        }
    }
}
