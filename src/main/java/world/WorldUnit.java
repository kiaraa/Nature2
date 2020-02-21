package world;

import Entity.Creature;
import Entity.Plant;

public class WorldUnit {
    private Creature creatureSpace;
    private Plant plantSpace;
    private int [] gridCoords;
    private int worldListIndex;

    public WorldUnit(int worldListIndex, int [] gridCoords) {
        this.creatureSpace = null;
        this.plantSpace = null;
        this.worldListIndex = worldListIndex;
        this.gridCoords = gridCoords;
    }

    public Creature getCreatureSpace() {
        return creatureSpace;
    }

    public void setCreatureSpace(Creature creatureSpace) {
        this.creatureSpace = creatureSpace;
    }

    public Plant getPlantSpace() {
        return plantSpace;
    }

    public void setPlantSpace(Plant plantSpace) {
        this.plantSpace = plantSpace;
    }

    public WorldUnit() {
        this.creatureSpace = null;
        this.plantSpace = null;
    }

    public int [] getCoordinates() {
        return this.gridCoords;
    }

    public int getWorldListIndex() {
        return this.worldListIndex;
    }
}
