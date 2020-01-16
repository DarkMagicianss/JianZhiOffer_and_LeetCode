package LeetCode.数组.课程表2;

import java.util.Arrays;
import java.util.LinkedList;

public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) return new int[]{};
        if (prerequisites.length == 0){
            int[] result_arr = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                result_arr[i] = i;
            }
            return result_arr;
        }
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
        int[] result_arr = new int[numCourses];
        int result = 0;
        //一旦这里result为空 但是输出的课程的个数和目标值对不上说明其中有环
        while (!list.isEmpty()) {
            Integer index = list.removeFirst();
            result_arr[result] = index;
            result++;
            //result.add(index);
            for (int i = 0; i < prerequisites.length; i++) {
                if (prerequisites[i][1] == index) {
                    inDegree[prerequisites[i][0]]--;
                    if (inDegree[prerequisites[i][0]] == 0) list.addLast(prerequisites[i][0]);
                }
            }
        }
        return result == numCourses ? result_arr : new int[]{};
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.findOrder(2, new int[][]{{1, 0}})));
        System.out.println(Arrays.toString(s.findOrder(2, new int[][]{{1, 0}, {0, 1}})));
    }
}
