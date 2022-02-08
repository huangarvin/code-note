package com.feng.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YiTian (HuangSuip sp.huang@tuya.com)
 */
public class Q39 {
    public static void main(String[] args) {
        int[] nums = {2, 6, 3, 5};
        int target = 8;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        dfs(nums, tmp, target, result, 0);
        for (List<Integer> integers : result) {
            System.out.println(integers);
        }
        System.out.println();
        result = combinationSum(nums, target);
        for (List<Integer> integers : result) {
            System.out.println(integers);
        }
    }

    private static void dfs(int[] nums, List<Integer> tmp, int target, List<List<Integer>> result, int index) {
        if (target == 0) {
            result.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if (nums[i] <= target) {
                tmp.add(nums[i]);
                dfs(nums, tmp, target - nums[i], result, i);
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        backtracking(new ArrayList<>(), combinations, 0, target, candidates);
        return combinations;
    }

    private static void backtracking(List<Integer> tempCombination, List<List<Integer>> combinations,
                                     int start, int target, final int[] candidates) {
        if (target == 0) {
            combinations.add(new ArrayList<>(tempCombination));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                tempCombination.add(candidates[i]);
                backtracking(tempCombination, combinations, i, target - candidates[i], candidates);
                tempCombination.remove(tempCombination.size() - 1);
            }
        }
    }
}
