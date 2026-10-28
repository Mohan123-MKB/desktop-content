


import java.util.*;

class Pair {
    int first, second;
    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

public class Solution {
    public boolean isCycle(int v, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[v];
        
        for (int i = 0; i < v; i++) {
            if (!vis[i]) {
                if (checkCycle(i, adj, vis)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkCycle(int src, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        Queue<Pair> q = new LinkedList<>();
        vis[src] = true;
        q.add(new Pair(src, -1)); // current node, parent node

        while (!q.isEmpty()) {
            int node = q.peek().first;
            int parent = q.peek().second;
            q.remove();

            for (int adjNode : adj.get(node)) {
                if (!vis[adjNode]) {
                    vis[adjNode] = true;
                    q.add(new Pair(adjNode, node));
                } else if (adjNode != parent) {
                    return true; // Found a cycle
                }
            }
        }
        return false;
    }

public static void main(String[] args) {
    int v = 5;
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < v; i++) {
        adj.add(new ArrayList<>());
    }

    adj.get(0).add(1);
    adj.get(1).add(0);

    adj.get(1).add(2);
    adj.get(2).add(1);

    adj.get(2).add(3);
    adj.get(3).add(2);

    adj.get(3).add(4);
    adj.get(4).add(3);

    adj.get(4).add(1); // introduces a cycle
    adj.get(1).add(4);

    Solution sol = new Solution();
    System.out.println(sol.isCycle(v, adj)); // Output: true
}
}
