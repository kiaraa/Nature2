package world;

import Entity.Creature;
import Entity.Plant;

public class WorldUnit {
    private Creature creatureSpace;
    private Plant plantSpace;

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
}
