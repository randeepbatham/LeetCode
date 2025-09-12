class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> courseGraph = new HashMap<>();

        for (int[] pre : prerequisites){
            if (courseGraph.containsKey(pre[1])){
                courseGraph.get(pre[1]).add(pre[0]);
            }
            else{
                List<Integer> nextCourse = new LinkedList<>();
                nextCourse.add(pre[0]);
                courseGraph.put(pre[1], nextCourse); 
            }
        }

        HashSet<Integer> visited = new HashSet<>();

        for (int currCourse = 0; currCourse < numCourses; currCourse++){
            if (courseSchedule(currCourse, visited, courseGraph) == false){
                return false;
            }
        }
        return true;
    }

    private boolean courseSchedule(int course, HashSet<Integer> visited, HashMap<Integer, List<Integer>> courseGraph){
        if (visited.contains(course)){
            return false;
        } 
        if (courseGraph.get(course) == null){
            return true;
        }

        visited.add(course);

        for (int pre : courseGraph.get(course)){
            if (courseSchedule(pre, visited, courseGraph) == false){
                return false;
            }
        }
        visited.remove(course);
        courseGraph.put(course, null);
        return true;

    } 
}
