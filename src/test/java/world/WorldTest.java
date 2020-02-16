package world;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.assertj.core.api.Assertions.*;

@RunWith(JUnit4.class)
public class WorldTest {

    @Test
    public void testOneByOneWorldHasOneUnit() {
        World world = new World(1, 1);
        assertThat(world.unitList.size()).isEqualTo(1);
    }

    @Test
    public void testOneByTwoWorldHasTwoUnits() {
        World world = new World(1, 2);
        assertThat(world.unitList.size()).isEqualTo(2);
    }

    @Test
    public void testThreeByFiveWorldHasFifteenUnits() {
        World world = new World(3, 5);
        assertThat(world.unitList.size()).isEqualTo(15);
    }

    @Test
    public void testInitializeGridAsThreeByThreeArray() {
        World world = new World(3, 3);

        int width = world.grid.length;
        int height = world.grid[0].length;
        int numOfSpaces = width * height;

        assertThat(numOfSpaces).isEqualTo(9);
    }

    @Test
    public void testUnitListHasUnits() {
        World world = new World(2, 3);

        WorldUnit testUnit = world.unitList.get(2);

        assertThat(testUnit).isInstanceOf(WorldUnit.class);
    }

    @Test
    public void testUnitInListCorrespondsToUnitInGrid() {
        World world = new World(5,5);

        assertThat(world.grid[0][0]).isSameAs(world.unitList.get(0));
        assertThat(world.grid[4][4]).isSameAs(world.unitList.get(24));
        assertThat(world.grid[2][1]).isSameAs(world.unitList.get(11));
    }
}

