package com.cqupt.mauger.quick;

import java.util.Arrays;

/**
 * 简易版
 * 快速排序（Quick Sort）是对冒泡排序（Bubble Sort）的一种改进。
 * 
 * 分类：
 * 	属于交换排序
 * 
 * 原理：
 * 	        通过一趟排序将要排序的数据分割成独立的两部分，其中一部分的所有数据都比另外一部分的所有数据都要小，
 * 	然后再按此方法对这两部分数据分别进行快速排序，整个排序过程可以递归进行，以此达到整个数据变成有序序列。
 * 
 * 步骤：
 * 	        随机找出一个数（通常就拿数组第一个数据就行），把它插入一个位置，使得它左边的数都比它小，它右边的数据都比它大，
 * 	这样就将一个数组分成了两个子数组，然后再按照同样的方法把子数组再分成更小的子数组，直到不能分解为止。
 * 	它也是分治思想的一个经典实验（归并排序也是）。
 * 
 * @author Mauger
 * @date 2018年3月24日  
 * @version 1.0
 */
public class QuickSort1
{
	/**
	 * main
	 * @param args
	 */
	public static void main(String[] args)
	{
		int[] arr = {9,5,3,6,8,0,1,4,7,2};
		System.out.println("原始数组为：\n" + Arrays.toString(arr));
		quickSort(arr, 0, arr.length - 1);
		System.out.println("排序后数组为：\n" + Arrays.toString(arr));
	}

	/**
	 * QuickSort
	 * @param arr int[]
	 * @param left 左指针
	 * @param right 右指针
	 */
	public static void quickSort(int[] arr, int left, int right)
	{
		if (left >= right)
		{
			return;
		}
		
		// 使用递归将子数组进行排序
		int k = getBoundary(arr, left, right);
		quickSort(arr, left, k - 1); // 将基准数左边的数组进行排序
		quickSort(arr, k + 1, right); // 将基准数右边的数组进行排序
	}

	/**
	 * 基准数：5
	 * [2, 4, 3, 1, 0] 5 [8, 6, 7, 9]
	 * 基准数：2
	 * [0, 1] 2 [3, 4] 5 [8, 6, 7, 9]
	 * 基准数：0
	 * [0, 1, 2] [3, 4] 5 [8, 6, 7, 9]
	 * 基准数：3
	 * [0, 1, 2, 3, 4, 5] [8, 6, 7, 9]
	 * 基准数：8
	 * [0, 1, 2, 3, 4, 5] [7, 6] 8 [9]
	 * 基准数：7
	 * [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
	 */
	private static int getBoundary(int[] arr, int left, int right)
	{
		// 这里取数组中的第一个数为基准数
		int standard = arr[left];
		int leftIndex = left; // 左指针
		int rightIndex = right; // 右指针
		while (leftIndex < rightIndex)
		{
			// 从右往左遍历数组，找出比基准数小的放至左边的子数组中
			while (leftIndex < rightIndex && arr[rightIndex] >= standard)
			{
				rightIndex--;
			}
			arr[leftIndex] = arr[rightIndex];
			
			// 从左往右遍历数组，找出比基准数大的放至右边的子数组中
			while (leftIndex < rightIndex && arr[leftIndex] <= standard)
			{
				leftIndex++;
			}
			arr[rightIndex] = arr[leftIndex];
		}
		
		// 返回基准数的下标
		arr[leftIndex] = standard;
		System.out.println("基准数：" + leftIndex + "\n" + Arrays.toString(arr));
		return leftIndex;
	}
}