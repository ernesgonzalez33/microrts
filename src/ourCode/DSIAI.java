package ourCode;

import ai.abstraction.Harvest;
import ai.abstraction.pathfinding.AStarPathFinding;
import ai.core.AI;
import ai.core.ParameterSpecification;
import rts.*;
import rts.units.Unit;
import rts.units.UnitType;
import rts.units.UnitTypeTable;

import java.util.ArrayList;
import java.util.List;

public class DSIAI extends AI {

    public DSIAI(UnitTypeTable utt) {
    }

    public DSIAI(){}

    @Override
    public void reset() {

    }

    @Override
    public PlayerAction getAction(int player, GameState gs) throws Exception {

        PhysicalGameState pgs = gs.getPhysicalGameState();
        PlayerAction pa = new PlayerAction();
        Player p = gs.getPlayer(player);
        Unit resource = null;
        Unit base = null;
        int cont = 0;

        for(Unit u:pgs.getUnits()){
            if (u.getType().isResource && cont == 0){
                resource = u;
                cont++;
            }
            if (u.getType().isStockpile){
                base = u;
            }

            if (u.getType().canHarvest && u.getPlayer() == p.getID()) {
                pa.addUnitAction(u, new Harvest(u, resource, base, new AStarPathFinding()).execute(gs));
            }
        }

        return pa;
    }

    @Override
    public AI clone() {
        return null;
    }

    @Override
    public List<ParameterSpecification> getParameters() {
        return new ArrayList<>();
    }
}
