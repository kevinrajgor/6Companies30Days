/*There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 
1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course 
bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false. */

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            arr.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            arr.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        int visi[] = new int[numCourses];
        int path[] = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (visi[i] == 0) {
                if (dfs(visi, i, arr, path) == true) {
                    System.out.println(i);
                    return false;
                }
            }
        }
        return true;

    }

    boolean dfs(int vis[], int n, ArrayList<ArrayList<Integer>> arr, int path[]) {
        vis[n] = 1;
        path[n] = 1;
        for (int i = 0; i < arr.get(n).size(); i++) {
            if (vis[arr.get(n).get(i)] == 0) {
                if (dfs(vis, arr.get(n).get(i), arr, path) == true) {
                    return true;
                }
            } else {
                if (path[arr.get(n).get(i)] == 1) {
                    return true;
                }
            }
        }

        path[n] = 0;
        return false;
    }
}