package models;

import java.util.Vector;

public class StronglyConnectedGraph {
    public Integer val;
    public Vector<StronglyConnectedGraph> neighbours = new Vector<StronglyConnectedGraph>(0);

    public StronglyConnectedGraph(Integer _val) {
        val = _val;
        neighbours.clear();
    }
}
