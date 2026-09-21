class Solution {
    public int minScore(int n, int[][] roads) {
        List<int[]>[] graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] e : roads) {
            graph[e[0]].add(new int[]{e[1], e[2]});
            graph[e[1]].add(new int[]{e[0], e[2]});
        }

        boolean[] vis = new boolean[n + 1];
        Queue<Integer> q = new ArrayDeque<>();

        q.offer(1);
        vis[1] = true;

        int ans = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            int u = q.poll();

            for (int[] curr : graph[u]) {
                int v = curr[0], w = curr[1];
                ans = Math.min(ans, w);

                if (!vis[v]) {
                    vis[v] = true;
                    q.offer(v);
                }
            }
        }

        return ans;
    }
}