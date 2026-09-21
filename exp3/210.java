class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        int[] indeg = new int[numCourses];

        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int prerequisite = prerequisites[i][1];

            adj.get(prerequisite).add(course);
            indeg[course]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indeg[i] == 0) {
                q.offer(i);
            }
        }

        int[] ans = new int[numCourses];
        int index = 0;
        int count = 0;

        while (!q.isEmpty()) {

            int currNode = q.poll();

            ans[index++] = currNode;
            count++;

            for (int adjNode : adj.get(currNode)) {

                indeg[adjNode]--;

                if (indeg[adjNode] == 0) {
                    q.offer(adjNode);
                }
            }
        }

        if (count != numCourses) {
            return new int[0];
        }

        return ans;
    }
}