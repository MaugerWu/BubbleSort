package com.cqupt.mauger.merge;

import java.util.Arrays;

/**
 * 归并排序（非递归实现）
 * @author Mauger
 * @date 2018年8月30日  
 * @version 1.0
 */
public class MergeSort
{

	public static String mergeSort(int[] arr)
	{
		int n = arr.length;
		if (n < 2)
		{
			return Arrays.toString(arr);
		}
		
		int k = 1;
		while (k < n)
		{
			mergePass(arr, k, n);
			k *= 2;
		}
		return Arrays.toString(arr);
	}
	
	private static void mergePass(int[] arr, int k, int n)
	{
		int i = 0;
		while (i < n-2*k+1)
		{
			merge(arr, i, i+k-1, i+2*k-1); // 两两归并
			i += 2*k; //i = i + 2 * k;
		}
		
		// 看护那些“落单的”长度不足两两归并的部分和前面归并起来
		if (i < n-k)
		{
			merge(arr, i, i+k-1, n-1); // 归并最后两个序列
		}
	}
	
	private static void merge(int[] arr, int low, int mid, int high)
	{
		int[] temp = new int[high - low + 1]; // 暂存合并结果
		int i = low; // 左边数组指针
		int j = mid + 1; // 右边数组指针
		int k = 0; // 合并后数组的指针
		
		for (; i <= mid && j <= high; k++)
		{
			if (arr[i] < arr[j])
			{
				temp[k] = arr[i++];
			} else
			{
				temp[k] = arr[j++];
			}
		}
		
		// 两个 while 循环是为了将剩余的（比另一边多出来的个数）放到 temp 数组中
		while (i <= mid)
		{
			temp[k++] = arr[i++];
		}
		
		while (j <= high)
		{
			temp[k++] = arr[j++];
		}
		
		//将 temp 数组中的元素写入到待排数组中
		for (int l=0; l < temp.length; l++)
		{
			arr[low + l] = temp[l];
		}
	}

	public static void main(String[] args)
	{
		int[] arr = {50, 10, 90, 30, 70, 40, 80, 60, 20};
		System.out.println(MergeSort.mergeSort(arr));
	}
}
