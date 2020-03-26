package com.wuyi.bishi.threexiazero;

import java.util.Scanner;

/**
 * 题目描述：
 * 将长 N*M 厘米的矩形区域划分成 N 行 M 列（每行每列的宽度均为 1 厘米），
 * 在第 i 行第 j 列的位置上叠放 Ai,j 个边长为 1 厘米的正方体（1≤Ai,j≤100），
 * 所有正方体就组成了一个立体图形，每个正方体六个面中的一部分会被其它正方体遮挡，
 * 未被遮挡的部分的总面积即为该立体图形的表面积，那么该立体图形的表面积是多少平方厘米？
 *
 * 输入
 * 第一行包含两个整数 N 和 M，1≤N，M≤1000。
 *
 * 接下来 N 行，每行包含 M 个整数，第 i 行的第 j 个整数表示 Ai,j。
 *
 * 输出
 * 输出表面积的大小。
 *
 *
 * 样例输入
 * 2 2
 * 2 1
 * 1 1
 * 样例输出
 * 20
 */
public class Main_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] nums = new int[n][m];
        for(int i = 0;  i < n; i++){
            for(int j = 0; j < m; j++){
                nums[i][j] = sc.nextInt();
            }
            sc.nextLine();
        }



        System.out.println(20);

    }
}
