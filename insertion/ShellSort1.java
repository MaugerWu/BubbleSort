package com.cqupt.mauger.insertion;

import java.util.Arrays;

public class ShellSort1
{

	public static String shellSort(int[] arr)
	{
		int increment = 0;
		while (increment <= arr.length) // 生成初始增量
		{
			increment = 3 * increment + 1;
		}
		
		while (increment >= 1)
		{
			for (int i = increment; i < arr.length; i++)
			{
				int j = i - increment;
				int get = arr[i];
				while (j >= 0 && arr[j] > get)
				{
					arr[j + increment] = arr[j];
					j = j - increment;
				}
				arr[j + increment] = get;
			}
			increment = (increment - 1) / 3; // 递减增量
		}
		return Arrays.toString(arr);
	}
	
	public static void main(String[] args)
	{
		int[] arr = {9, 1, 5, 8, 3, 7, 4, 6, 2};
		System.out.println(ShellSort1.shellSort(arr));
	}
}
