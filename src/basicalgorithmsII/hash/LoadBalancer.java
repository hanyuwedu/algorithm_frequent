package basicalgorithmsII.hash;

import java.util.*;

/**
 * 12/1
 */
public class LoadBalancer {
    private List<Integer> lbList;
    private Map<Integer, Integer> lbMap;

    public LoadBalancer() {
        this.lbList = new ArrayList<>();
        this.lbMap = new HashMap<>();
    }

    /*
     * @param server_id: add a new server to the cluster
     * @return: nothing
     */
    public void add(int server_id) {
        this.lbList.add(server_id);
        this.lbMap.put(server_id, lbList.size() - 1);
    }

    /*
     * @param server_id: server_id remove a bad server from the cluster
     * @return: nothing
     */
    public void remove_redundunt(int server_id) {
        if (lbMap.containsKey(server_id)) {
            if (lbList.size() == 1) {
                lbList.clear();
                lbMap.clear();
            } else if (lbList.get(lbList.size() - 1) == server_id) {
                lbList.remove(lbList.size() - 1);
                lbMap.remove(server_id);
            } else {
                int serverIndex = lbMap.get(server_id);
                lbList.set(serverIndex, lbList.get(lbList.size() - 1));
                lbList.remove(lbList.size() - 1);

                lbMap.remove(server_id);
                lbMap.put(lbList.get(serverIndex), serverIndex);
            }
        }
    }

    /*
     * @param server_id: server_id remove a bad server from the cluster
     * @return: nothing
     */
    public void remove(int server_id) {
        if (lbMap.containsKey(server_id)) {
            lbList.set(lbMap.get(server_id), lbList.get(lbList.size() - 1));
            lbMap.put(lbList.get(lbList.size() - 1), lbMap.get(server_id));
            lbMap.remove(server_id);
            lbList.remove(lbList.size() - 1);
        }
    }

    /*
     * @return: pick a server in the cluster randomly with equal probability
     */
    public int pick() {
        Random random = new Random();
        int selectedServerIndex = random.nextInt(lbList.size());
        return lbList.get(selectedServerIndex);
    }
}
