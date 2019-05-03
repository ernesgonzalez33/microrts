package ourCode;

import ai.core.AI;
import ai.core.ParameterSpecification;
import rts.GameState;
import rts.PhysicalGameState;
import rts.PlayerAction;
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
