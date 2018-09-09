package com.cqupt.mauger.select;

import java.util.Arrays;

/**
 * 简单选择排序 (Simple Selection Sort)
 * 
 * 通过 n-i 次关键字间的比较，从 n-i+1 个记录中选出最小关键字的记录，并和第 i（1 <= i <= n）个记录交换。
 * 
 * @author Mauger
 * @date 2018年8月22日  
 * @version 1.0
 */
public class SimpleSelectSort
{

	public static String simpleSelectSort(int[] arr)
	{
		int min = 0; // 记录最小关键字的位置
		for (int i = 0; i < arr.length - 1; i++)
		{
			min = i;
			for (int j = i + 1; j < arr.length; j++)
			{
				if (arr[min] > arr[j]) // 寻找出最小关键字的位置
				{
					min = j;
				}
			}
			
			if (i != min)
			{
				int temp = arr[min];
				arr[min] = arr[i];
				arr[i] = temp;
			}
		}
		return Arrays.toString(arr);
	}
	
	public static void main(String[] args)
	{
		int[] arr = { 4, 22, 1, 100, 132, 20, 9, 67};
		System.out.println(SimpleSelectSort.simpleSelectSort(arr));
	}

}
