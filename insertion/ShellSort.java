package com.cqupt.mauger.insertion;

import java.util.Arrays;

/**
 * 希尔排序
 * 	也叫递减增量排序，是插入排序的一种更高效的改进版本。
 * 
 * 分类：
 * 	属于内部排序-希尔排序
 * 
 * 时间复杂度：
 * 	根据步长序列的不同而不同。已知反序中最好的情况为 O(n(logn)^2)，最好情况-正序 O(n)，平均 O(nlogn)~O(n^2)
 * 
 * 稳定性：
 * 	稳定
 * 
 * @author Mauger
 * @date 2018年4月27日  
 * @version 1.0
 */
public class ShellSort 
{

	public static String shellSort(int[] arr)
	{
		int i, j;
		int increment = arr.length;
		do
		{
			increment = increment / 3 + 1; // 增量序列
			for (i = increment; i < arr.length; i++)
			{
				j = i - increment;
				int temp = arr[i];
				while (j >= 0 && arr[j] > temp)
				{
					arr[j + increment] = arr[j];
					j = j - increment;
				}
				arr[j + increment] = temp;
			}
		}
		while(increment > 1);
		return Arrays.toString(arr);
	}
	
	public static void main(String[] args)
	{
		int[] arr = {9, 1, 5, 8, 3, 7, 4, 6, 2};
		System.out.println(ShellSort.shellSort(arr));
	}
}
