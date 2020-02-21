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
    private ArrayList<Creature> hasMovedList;

    public List<WorldUnit> getUnitList() {
        return unitList;
    }

    public WorldUnit[][] getGrid() {
        return grid;
    }

    private java.util.Timer worldTimer;

    public World(int width, int height, int initialCows) {
        this.width = width;
        this.height = height;
        Ticker ticker = new Ticker(this);
        java.util.Timer worldTimer = new java.util.Timer();
        this.grid = new WorldUnit[width][height];
            for(int i = 0; i < width; i++) {
                for (int j = 0; j < height; j++) {
                    WorldUnit unit = new WorldUnit(unitList.size(),new int [] {i,j});
                    this.grid[i][j] = unit;
                    unitList.add(unit);
                }
            }

        while (initialCows > 0) {
            this.initializeCow();
            initialCows --;
        }

        this.hasMovedList = new ArrayList<Creature>();
        worldTimer.schedule(ticker, 0, 2000);
        this.getContentPane().setBackground(new Color(50,50,50));
        setSize(width * UNIT_SIZE,(height * UNIT_SIZE) + 23);
        setVisible(true);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void initializeCow() {
        WorldUnit unitToPlaceCow = unitList.get(randy.nextInt(unitList.size()));
        if (unitToPlaceCow.getCreatureSpace() == null) {
            unitToPlaceCow.setCreatureSpace(new Creature(this, unitToPlaceCow, 1));
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

    public void tick() {
        for (int i = 0; i < this.width; i++) {
            for (int j = 0; j < this.height; j++) {
                if (this.grid[i][j].getCreatureSpace() instanceof Creature && !hasMovedList.contains(this.grid[i][j].getCreatureSpace())) {
                    hasMovedList.add(this.grid[i][j].getCreatureSpace());
                    this.grid[i][j].getCreatureSpace().move();
                }
                else if (this.grid[i][j].getCreatureSpace() != null){
                    System.out.println("A creature tried to move, but already had.");
                }
            }
        }
        hasMovedList.clear();
        System.out.println("tick");
        this.repaint();
    }
}
