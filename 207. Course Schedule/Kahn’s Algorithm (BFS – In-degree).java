class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++){
            graph.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];
        for(int[] preq :prerequisites){
            graph.get(preq[0]).add(preq[1]);
            indegree[preq[1]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if (indegree[i] == 0){
                queue.add(i);
            }
        }

        int visited = 0;
        while (!queue.isEmpty()){
            int node = queue.poll();
            visited++;

            for (int nei : graph.get(node)){
                indegree[nei]--;
                if (indegree[nei] == 0){
                    queue.add(nei);
                }
            }
        }
        return numCourses == visited;
    } 
}
