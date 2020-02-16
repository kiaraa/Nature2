package world;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class World extends JFrame {
    public final int UNIT_SIZE = 10;

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

    public World(int width, int height) {
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
        this.getContentPane().setBackground(new Color(50,50,50));
        setSize(width * UNIT_SIZE,(height * UNIT_SIZE) + 23);
        setVisible(true);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}
