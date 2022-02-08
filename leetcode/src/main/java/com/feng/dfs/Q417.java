package com.feng.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author YiTian (HuangSuip sp.huang@tuya.com)
 */
public class Q417 {
    public static void main(String[] args) {
        int[][] heights = new int[][] {
            {1, 2, 2, 3, 5},
            {3, 1, 1, 4, 4},
            {2, 4, 5, 3, 1},
            {6, 7, 1, 4, 5},
            {5, 1, 1, 2, 4},
        };
        System.out.println(new Solution().pacificAtlantic(heights));
    }
}

// 写着广度优先遍历，实际上由是一道深度搜索的题目
//大致思路就是找到太平洋所能到达的地方记录下来，然后找到大西洋所能到达的点记录下来，然后找到重叠的点,且值都为1
//的点就是所求，看了一个评论区大佬的思路就是设置一个数组将太平洋能到达的地点加一，然后将大西洋能到达的地点在加一
//最后值为2的点就是所求,忽然想了想这种思路可能不太好，因为深度优先遍历过程中可能会重复遍历到某个点
// 还是设置两个数组的好
class Solution {
    int min = Integer.MIN_VALUE;
    // 创建一个二维数组记录海洋所能到达的点
    int[][] preach;
    int[][] areach;
    //  创建一个集合保存结果
    List<List<Integer>> list = new ArrayList<List<Integer>>();

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        // 分别创建两个数组记录两个海洋所能到达的陆地
        preach = new int[heights.length][heights[0].length];
        areach = new int[heights.length][heights[0].length];
        //将太平洋边上的每个点都进行深搜
        for (int i = 0; i < heights[0].length; i++) {
            dfs(heights, preach, 0, i, min);
        }
        for (int[] ints : preach) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println();
        for (int i = 0; i < heights.length; i++) {
            dfs(heights, preach, i, 0, min);
        }
        for (int[] ints : preach) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println();
        // 将大西洋边上的每个点都进行深搜
        for (int i = 0; i < heights[0].length; i++) {
            dfs(heights, areach, heights.length - 1, i, min);
        }
        for (int[] ints : areach) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println();
        for (int i = 0; i < heights.length; i++) {
            dfs(heights, areach, i, heights[0].length - 1, min);
        }
        for (int[] ints : areach) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println();
        //创建一个集合保存坐标
        List<Integer> temp;
        //比较重复的点，且值为1的点，并将他们的坐标放进集合中去
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                if (preach[i][j] == 1 && areach[i][j] == 1) {
                    temp = new ArrayList<Integer>();
                    temp.add(i);
                    temp.add(j);
                    list.add(temp);
                }
            }
        }
        return list;
    }

    // 创建一个深度优先搜索函数
    public void dfs(int[][] heights, int[][] reach, int rstart, int cstart, int pre) {
        // 深度优先搜索的出口
        // 当超出二维数组的范围时:rstart<0||cstart<0||rstart>=heights.length||cstart>=heights[0].length
        // 当某个点的值必它本身要小的时候:heights[rstart][cstart]<pre
        // 由或者该点已经被搜索过了 : reach[rstart][cstart]==1
        if (rstart < 0 ||
            cstart < 0 ||
            rstart >= heights.length ||
            cstart >= heights[0].length ||
            heights[rstart][cstart] < pre ||
            reach[rstart][cstart] == 1) {
            return;
        }
        int temp = heights[rstart][cstart];
        reach[rstart][cstart] = 1;
        // 想该点的四个方向进行搜索
        //右
        dfs(heights, reach, rstart + 1, cstart, temp);
        //下
        dfs(heights, reach, rstart, cstart - 1, temp);
        //上
        dfs(heights, reach, rstart, cstart + 1, temp);
        //左
        dfs(heights, reach, rstart - 1, cstart, temp);
    }
}


class Solution2 {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int[][] ao = new int[m][n];//太平洋的节点记录矩阵
        int[][] pa = new int[m][n];//大西洋的节点记录矩阵
        //1. 从上下边界开始两大洋的回流搜索，变动的是列
        for (int i = 0; i < n; i++) {
            dfs(heights, pa, 0, i);
            dfs(heights, ao, m - 1, i);
        }
        //2. 从左右边界开始两大洋的回流搜索，变动的是行
        for (int i = 0; i < m; i++) {
            dfs(heights, pa, i, 0);
            dfs(heights, ao, i, n - 1);
        }
        //3. 输出交叠的坐标
        List<List<Integer>> cnt = new ArrayList<List<Integer>>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (ao[i][j] == 1 && pa[i][j] == 1) {
                    cnt.add(Arrays.asList(i, j));
                }
            }
        }
        return cnt;
    }

    public static void dfs(int[][] heights, int[][] tmp, int cur_i, int cur_j) {
        //标记可以从海洋流回经过的节点
        tmp[cur_i][cur_j] = 1;
        //开始深度优先搜索当前坐标的4个方向
        //1. 设置更新的坐标
        int[] di = new int[] {1, -1, 0, 0};//上下移动
        int[] dj = new int[] {0, 0, 1, -1};//左右移动
        int new_i = 0;
        int new_j = 0;
        //2. 更新坐标并递归搜索
        for (int index = 0; index < 4; index++) {
            new_i = cur_i + di[index];
            new_j = cur_j + dj[index];
            //判断下标是否越界
            if (new_i < 0 || new_j < 0 || new_i >= heights.length || new_j >= heights[0].length) {
                continue;
            }
            if (heights[cur_i][cur_j] <= heights[new_i][new_j] && tmp[new_i][new_j] != 1) {
                dfs(heights, tmp, new_i, new_j);
            }
        }
    }
}
