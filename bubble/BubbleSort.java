package com.cqupt.mauger.bubble;

import java.util.Arrays;

/**
 * 冒泡排序（Bubble Sort）是一种简单的排序算法。
 * 
 * 原理：
 * 	比较两个相邻的元素，将值大的元素交换至右端。
 * 
 * 优化：
 * 	如果有的数组已经有顺序了，那就直接停止排序。
 * 
 * @author Mauger
 * @date 2018年3月23日  
 * @version 1.0
 */
public class BubbleSort {

	public static void main(String[] args) {
		
		int[] array = {3,9,0,5,7,2};
		System.out.println(bubbleSort(array));
	}
	
	public static String bubbleSort(int[] arr) {
		
		int len = arr.length;
		boolean sorted = true;
		
		for (int i = 0; i < len - 1; i++)
		{
			sorted = true;
			for (int j = 0; j < len - 1 - i; j++)
			{
				if (arr[j] > arr[j + 1])
				{
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					sorted = false;
				}
			}
			if (sorted)
			{
				break;
			}
		}
		return Arrays.toString(arr);
	}
}