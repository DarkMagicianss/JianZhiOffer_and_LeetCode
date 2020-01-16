package LeetCode.数组.课程表_____学习一下拓扑排序;

import java.util.LinkedList;

public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) return false;
        if (prerequisites.length == 0) return true;
        //入度数组 对应的所有的课程的入度个数
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            //[1<-0]表明的就是第0门课入度++
            inDegree[prerequisites[i][0]]++;
        }
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {//即入度为0的课程 这里代表的意思就是不需要前置条件的课程
                list.addLast(i);
            }
        }
        //ArrayList<Integer> result = new ArrayList<>();
        int result = 0;
        //一旦这里result为空 但是输出的课程的个数和目标值对不上说明其中有环
        while (!list.isEmpty()) {
            Integer index = list.removeFirst();
            result++;
            //result.add(index);
            for (int i = 0; i < prerequisites.length; i++) {
                if (prerequisites[i][1] == index) {
                    inDegree[prerequisites[i][0]]--;
                    if (inDegree[prerequisites[i][0]] == 0) list.addLast(prerequisites[i][0]);
                }
            }
        }
        return result == numCourses;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.canFinish(2,new int[][]{{1,0}}));
        System.out.println(s.canFinish(2,new int[][]{{1,0},{0,1}}));
    }
}
