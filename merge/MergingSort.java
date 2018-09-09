package com.cqupt.mauger.merge;

import java.util.Arrays;

/**
 * 归并排序(递归实现)
 * 	归并排序是利用归并的思想实现的排序方法，该算法采用经典的分治（divide-and-conquer）策略（分治法将问题分(divide)
 * 成一些小的问题然后递归求解，而治(conquer)的阶段则将分的阶段得到的各答案"修补"在一起，即分而治之)。
 * 
 * 时间复杂度
 * 	最好、最坏、平均时间复杂度均为 O(nlogN)。
 * 
 * 空间复杂度
 * 	O(N+logN)。
 * 
 * 稳定性
 * 	稳定。
 * 
 * @author Mauger
 * @date 2018年8月30日  
 * @version 1.0
 */
public class MergingSort
{
	
	public static String mergeSort(int[] arr)
	{
//		Arrays.sort(arr);
		MSort(arr, 0, arr.length - 1);
		return Arrays.toString(arr);
	}
	
	private static void MSort(int[] arr, int left, int right)
	{
		if (left >= right)
		{
			return;
		}
		int mid = (left + right) / 2;
		MSort(arr, left, mid); // 对左边十足进行递归
		MSort(arr, mid + 1, right); // 对右边十足进行递归
		MSort(arr, left, mid, right); // 合并
	}

	/**
	 * 归并排好序的数组（2路归并）
	 * @param arr 待排序数组
	 * @param left 左边数组第一个索引
	 * @param mid 左边数组最后一个索引
	 * @param right 右边数组最后一个索引
	 */
	private static void MSort(int[] arr, int left, int mid, int right)
	{
		int[] tempArray = new int[arr.length];
		int rightIndex = mid + 1;
		int tempIndex = left;
		int begin = left;
		while (left <= mid && rightIndex <= right)
		{
			if (arr[left] <= arr[rightIndex])
			{
				tempArray[tempIndex++] = arr[left++];
			} else
			{
				tempArray[tempIndex++] = arr[rightIndex++];
			}
		}
		
		while (left <= mid)
		{
			tempArray[tempIndex++] = arr[left++];
		}
		
		while (rightIndex <= right)
		{
			tempArray[tempIndex++] = arr[rightIndex++];
		}
		
		while (begin <= right)
		{
			arr[begin] = tempArray[begin++];
		}
	}
	
	public static void main(String[] args)
	{
		int[] arr = {50, 10, 90, 30, 70, 40, 80, 60, 20};
		System.out.println(MergingSort.mergeSort(arr));
	}
}
