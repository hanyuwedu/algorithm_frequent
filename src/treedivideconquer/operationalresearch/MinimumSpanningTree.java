package treedivideconquer.operationalresearch;

import util.UnionFindSet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinimumSpanningTree {
    public static class Connection {
        public String city1, city2;
        public int cost;

        public Connection(String city1, String city2, int cost) {
            this.city1 = city1;
            this.city2 = city2;
            this.cost = cost;
        }
    }

    /**
     * 12/3
     *
     * @param connections given a list of connections include two cities and cost
     * @return a list of connections from results
     */
    public List<Connection> lowestCost(List<Connection> connections) {
        if (connections == null || connections.isEmpty()) {
            return new ArrayList<>();
        }

         Collections.sort(connections, (o1, o2) -> {
             if (o1.cost != o2.cost) {
                 return o1.cost - o2.cost;
             } else if (!o1.city1.equals(o2.city1)) {
                 return o1.city1.compareTo(o2.city1);
             } else {
                 return o1.city2.compareTo(o2.city2);
             }
         });

        UnionFindSet<String> unionFindSet = new UnionFindSet<>();
        for (Connection conn : connections) {
            unionFindSet.add(conn.city1);
            unionFindSet.add(conn.city2);
        }

        List<Connection> cost = new ArrayList<>();
        for (Connection connection : connections) {
            if (unionFindSet.isConnected(connection.city1, connection.city2)) {
                continue;
            }

            cost.add(connection);
            unionFindSet.connect(connection.city1, connection.city2);
        }

//        if (unionFindSet.components() != 1) {
        if (cost.size() != unionFindSet.size() - 1) {
            return new ArrayList<>();
        } else {
            return cost;
        }
    }
}
