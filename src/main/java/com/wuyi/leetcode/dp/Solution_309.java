package com.wuyi.leetcode.dp;

/**
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 *
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 *
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 示例:
 *
 * 输入: [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 *
 */
public class Solution_309 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int sell = 0, buy = -prices[0], coolDown = 0;

        for(int i = 1; i < n; i++){
            int last = coolDown;
            //冷冻由上次冷冻和上次卖的最大值决定
            coolDown = Math.max(coolDown, sell);
            //卖出由上次卖和上次买 + 当前间价格的最大值决定
            //买由上次买和上次冷冻 - 当前价格的最大值决定
            sell = Math.max(sell, buy + prices[i]);//不交易或者卖出
            buy = Math.max(buy, last - prices[i]);//不交易或者买入
            System.out.println("buy: " + buy);
            System.out.println("sell: " + sell);
        }
        return sell;
    }

    public static void main(String[] args) {
        Solution_309 s = new Solution_309();
        int[] nums = {1,2,3,0,2};
        int res = s.maxProfit(nums);
        System.out.println(res);
    }
}
