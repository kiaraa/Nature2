package world;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.assertj.core.api.Assertions.*;

@RunWith(JUnit4.class)
public class WorldUnitTest {

    @Test
    public void testBothSpacesInitializeToEmpty() {
        World world = new World(5,5, 0);
        for (WorldUnit unit : world.unitList) {
            assertThat(unit.getCreatureSpace()).isNull();
            assertThat(unit.getPlantSpace()).isNull();
        }
    }

    @Test
    public void testUnitGivesAccurateCoordinates() {
        World world = new World(4,3,0);
        WorldUnit unit = world.unitList.get(0);
        assertThat(unit.getCoordinates()).isEqualTo(new int[]{0,0});
        unit = world.unitList.get(1);
        assertThat(unit.getCoordinates()).isEqualTo(new int[]{0,1});
        unit = world.unitList.get(4);
        assertThat(unit.getCoordinates()).isEqualTo(new int[]{1,1});
    }

    @Test
    public void testUnitGivesAccuratePlaceInUnitList() {
        World world = new World(6,4,0);
        WorldUnit unit = world.grid[0][0];
        assertThat(unit.getWorldListIndex()).isEqualTo(0);
        unit = world.grid[5][0];
        assertThat(unit.getWorldListIndex()).isEqualTo(20);
        unit = world.grid[3][2];
        assertThat(unit.getWorldListIndex()).isEqualTo(14);
    }
}