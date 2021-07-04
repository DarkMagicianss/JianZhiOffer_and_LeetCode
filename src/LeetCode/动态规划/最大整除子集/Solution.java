package com.xiaomi.ad.osctask.ad.solution;


import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LinHu
 * @version 2021/4/3
 */
@Slf4j
public class Solution {
    // 超时的方法
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int maxSizeIndex = 0;
        if (nums.length == 1) {
            List<Integer> list = new ArrayList<>();
            list.add(nums[0]);
            return list;
        }
        for (int i = 0; i < nums.length; i++) {
            int number = nums[i];
            log.info("number:{}", number);
            int size = result.size();
            for (int j = 0; j < size; j++) {
                List<Integer> tempList = result.get(j);
                if (tempList.stream().allMatch(a -> a % number == 0 || number % a == 0)) {
                    List<Integer> newList = new ArrayList<>();
                    newList.addAll(tempList);
                    newList.add(number);
                    result.add(newList);
                    if (newList.size() > result.get(maxSizeIndex).size()) {
                        maxSizeIndex = result.size() - 1;
                    }
                }
            }
            List<Integer> singleList = new ArrayList<>();
            singleList.add(number);
            result.add(singleList);
            result.forEach(list -> log.info("list:{}", list));
        }
        return result.get(maxSizeIndex);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
//        System.out.println(s.largestDivisibleSubset(new int[]{1,2,3}));
//        System.out.println(s.largestDivisibleSubset(new int[]{1,2,4,8}));
//        System.out.println(s.largestDivisibleSubset(new int[]{1,2,4,12,3,6,18,108}));
        System.out.println(s.largestDivisibleSubset(new int[]{5,9,18,54,108,540,90,180,360,720}));
//        TreeNode treeNode1 = new TreeNode(3);
//        TreeNode treeNode2 = new TreeNode(2);
//        TreeNode treeNode3 = new TreeNode(3);
//        TreeNode treeNode4 = new TreeNode(3);
//        TreeNode treeNode5 = new TreeNode(1);
//        treeNode1.left = treeNode2;
//        treeNode1.right = treeNode3;
//        treeNode2.right = treeNode4;
//        treeNode3.right = treeNode5;
//        System.out.println(s.rob(treeNode1));
//        TreeNode treeNode21 = new TreeNode(3);
//        TreeNode treeNode22 = new TreeNode(4);
//        TreeNode treeNode23 = new TreeNode(5);
//        TreeNode treeNode24 = new TreeNode(1);
//        TreeNode treeNode25 = new TreeNode(3);
//        TreeNode treeNode26 = new TreeNode(1);
//        treeNode21.left = treeNode22;
//        treeNode21.right = treeNode23;
//        treeNode22.left = treeNode24;
//        treeNode22.right = treeNode25;
//        treeNode23.right = treeNode26;
//        System.out.println(s.rob(treeNode21));
//        TreeNode treeNode31 = new TreeNode(4);
//        TreeNode treeNode32 = new TreeNode(1);
//        TreeNode treeNode33 = new TreeNode(2);
//        TreeNode treeNode34 = new TreeNode(3);
//        treeNode31.left = treeNode32;
//        treeNode32.left= treeNode33;
//        treeNode33.left = treeNode34;
//        System.out.println(s.rob(treeNode31));
    }

}
