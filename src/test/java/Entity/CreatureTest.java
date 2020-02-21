package Entity;

import org.junit.Test;
import world.World;
import world.WorldUnit;

import static org.assertj.core.api.Assertions.*;

public class CreatureTest {

    @Test
    public void testGetsCorrectUnitOnInitialization() {
        World world = new World(5,5,0);
        WorldUnit unit = world.grid[3][2];
        Creature creature = new Creature(world, unit, 1);
        unit.setCreatureSpace(creature);
        assertThat(creature.getCurrentUnit()).isSameAs(unit);
    }

    @Test
    public void testMoveNumberOfSpacesLessThanOrEqualToSpeed() {
        World world = new World(10,10,0);
        Creature creature = new Creature(world, world.grid[3][3], 1);
        WorldUnit initialUnit = creature.getCurrentUnit();
        creature.move();
        WorldUnit currentUnit = creature.getCurrentUnit();
        assertThat(creature.getCurrentUnit()).isNotEqualTo(initialUnit);

        int [] initialUnitCoords = initialUnit.getCoordinates();
        int [] currentUnitCoords = currentUnit.getCoordinates();

        boolean xCoordIsWithinSpeedValue = (currentUnitCoords[0] < (initialUnitCoords[0] + creature.getSpeed()) || (currentUnitCoords[0] > initialUnitCoords[0] - creature.getSpeed()));
        boolean yCoordIsWithinSpeedValue = (currentUnitCoords[1] < (initialUnitCoords[1] + creature.getSpeed()) || (currentUnitCoords[1] > initialUnitCoords[1] - creature.getSpeed()));

        assertThat(xCoordIsWithinSpeedValue && yCoordIsWithinSpeedValue).isTrue();
    }
}