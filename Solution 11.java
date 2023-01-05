/*You are in a city that consists of n intersections numbered from 0 to n - 1 with bi-directional roads between some intersections. The inputs are generated such that you can reach any intersection from any other intersection and that there is at most one road between any two intersections.

You are given an integer n and a 2D integer array roads where roads[i] = [ui, vi, timei] means that there is a road between intersections ui and vi that takes timei minutes to travel. You want to know in how many ways you can travel from intersection 0 to intersection n - 1 in the shortest amount of time.

Return the number of ways you can arrive at your destination in the shortest amount of time. Since the answer may be large, return it modulo 109 + 7.

 */

class Solution {
    public int countPaths(int n, int[][] roads) {
        List<List<Pair>> adj = new ArrayList<>();
        Queue<Pair> queue = new PriorityQueue<>((p1, p2) -> p1.dist - p2.dist);
        long[] distance = new long[n];
        long[] ways = new long[n];
        long mod = 1000000007;

        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (int i = 0; i < roads.length; i++) {
            adj.get(roads[i][0]).add(new Pair(roads[i][1], roads[i][2]));
            adj.get(roads[i][1]).add(new Pair(roads[i][0], roads[i][2]));
        }

        Arrays.fill(distance, Integer.MAX_VALUE);

        queue.add(new Pair(0, 0));
        distance[0] = 0;
        ways[0] = 1;

        while (!queue.isEmpty()) {
            int node = queue.peek().node;
            int dist = queue.poll().dist;
            for (Pair p : adj.get(node)) {
                if (dist + p.dist < distance[p.node]) {
                    distance[p.node] = dist + p.dist;
                    ways[p.node] = ways[node];
                    queue.add(new Pair(p.node, distance[p.node]));
                } else if (dist + p.dist == distance[p.node]) {
                    ways[p.node] = (ways[p.node] + ways[node]) % mod;
                }
            }
        }

        return (int) (ways[n - 1] % mod);
    }
}

class Pair {
    int node, dist;

    Pair(int node, long dist) {
        this.node = node;
        this.dist = (int) dist;
    }
}