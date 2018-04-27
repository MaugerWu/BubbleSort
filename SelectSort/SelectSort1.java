package com.cqupt.mauger.select;

import java.util.Arrays;

/**
 * 简单选择排序（Simple Selection Sort）是一种简单直观的排序算法。
 * 
 * 原理：
 * 	首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，然后，再从剩余未排序元素中继续寻找最小（大）元素，
 * 	然后放到已排序序列的末尾。以此类推，直到所有元素均排序完毕。 
 * 
 * 	表现最稳定的排序算法之一，因为无论什么数据进去都是O(n2)的时间复杂度，所以用到它的时候，数据规模越小越好。
 * 	唯一的好处可能就是不占用额外的内存空间。
 * 
 * @author Mauger
 * @date 2018年4月20日  
 * @version 1.0
 */
public class SelectSort1
{
	public static void main(String[] args)
	{
		int[] array = { 4, 22, 1, 100, 132, 20, 9, 67};
		System.out.println("原数组： " + Arrays.toString(array));
		System.out.println("正    序： " + selectSort(array));
		System.out.println("倒    序： " + reverseOrder(array));
	}
	
	public static String selectSort(int[] arr)
	{
		int len = arr.length; // 数组长度
		int minIndex; // 最小值索引变量
		int temp; // 暂存变量值
		
		for (int i = 0; i < len - 1; i++)
		{
			minIndex = i;
			for (int j = i + 1; j < len; j++)
			{
				if (arr[j] < arr[minIndex]) // 寻找最小值
				{
					minIndex = j; // 将最小值的索引保存
				}
			}
			temp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = temp;
		}
		return Arrays.toString(arr);
	}
	
	public static String reverseOrder(int[] arr)
	{
		int len = arr.length;
		int maxIndex;
		int temp;
		
		for (int i = 0; i < len - 1; i++)
		{
			maxIndex = i;
			for (int j = i + 1; j < len; j++)
			{
				if (arr[maxIndex] < arr[j])
				{
					maxIndex = j;
				}
			}
			temp = arr[i];
			arr[i] = arr[maxIndex];
			arr[maxIndex] = temp;
		}
		return Arrays.toString(arr);
	}
}