package world;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.assertj.core.api.Assertions.*;

@RunWith(JUnit4.class)
public class WorldUnitTest {

    @Test
    public void testBothSpacesInitializeToEmpty() {
        World world = new World(5,5);
        for (WorldUnit unit : world.unitList) {
            assertThat(unit.getCreatureSpace()).isNull();
            assertThat(unit.getPlantSpace()).isNull();
        }
    }
}