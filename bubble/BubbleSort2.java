package com.cqupt.mauger.bubble;

import java.util.Arrays;

/**
 * 优化版
 * 冒泡排序（Bubble Sort）是一种简单的排序算法
 * 原理：比较两个相邻的元素，将值大的元素交换至右端。
 * 比较一趟就可以少一次比较，因为前面已经比较过的就不用比较了
 * 
 * @author Mauger
 * @date 2018年3月23日  
 * @version 1.0
 */
public class BubbleSort2 {

	/**
	 * Main方法
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {9,3,6,8,0,1};
		sort(arr);
	}

	/**
	 * 第一趟排序
	 * 	第1次：[3,9,6,8,0,1]
	 * 	第2次：[3,6,9,8,0,1]
	 * 	第3次：[3,6,8,9,0,1]
	 * 	第4次：[3,6,8,0,9,1]
	 * 	第5次：[3,6,8,0,1,9]
	 * 第二趟排序
	 * 	第1次：[3,6,8,0,1,9]
	 * 	第2次：[3,6,8,0,1,9]
	 * 	第3次：[3,6,0,8,1,9]
	 * 	第4次：[3,6,0,1,8,9]
	 * 第三趟排序
	 * 	第1次：[3,6,0,1,8,9]
	 * 	第2次：[3,0,6,1,8,9]
	 * 	第3次：[3,0,1,6,8,9]
	 * 第四趟排序
	 * 	第1次：[0,3,1,6,8,9]
	 * 	第2次：[0,1,3,6,8,9]
	 * 第五趟排序
	 * 	第1次：[0,1,3,6,8,9]
	 * 
	 * @param arr 数组
	 */
	public static void sort(int[] arr) {
//		long startTime = System.currentTimeMillis(); // 毫秒
//		long startTime=System.nanoTime(); // 纳秒
//		System.out.println(startTime);
		for (int i = 0; i < arr.length - 1; i++)
		{
			if (i != 0)
			{
				System.out.println("\n第" + (i + 1) + "趟排序");
			} else
			{
				System.out.println("第" + (i + 1) + "趟排序");
			}

			for (int j = 0; j < arr.length - 1 - i; j++)
			{
				System.out.print("第" + (j + 1) + "次比较");
				if (arr[j] > arr[j + 1])
				{
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
				System.out.println(Arrays.toString(arr));
			}
		}
		
		System.out.println("\n排序结果：" + Arrays.toString(arr));
//		long endTime = System.currentTimeMillis();
//		System.out.println("排序用时： " + (endTime - startTime) + "ms");
	}
}
