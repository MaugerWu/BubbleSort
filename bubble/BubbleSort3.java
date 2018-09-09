package com.cqupt.mauger.bubble;

import java.util.Arrays;

/**
 * 最终版
 * 冒泡排序（Bubble Sort）是一种简单的排序算法
 * 原理：比较两个相邻的元素，将值大的元素交换至右端。
 * 如果有的数组已经有顺序了，那就直接停止排序。
 * 
 * @author Mauger
 * @date 2018年3月23日  
 * @version 1.0
 */
public class BubbleSort3 {

	/**
	 * Main方法
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {0,1,2,3,4,5};
//		int[] arr = {5,4,3,2,1,0};
		sort(arr);
	}

	/**
	 * 第一趟排序
	 * 	第1次：[0,1,2,3,4,5]
	 * 	第2次：[0,1,2,3,4,5]
	 * 	第3次：[0,1,2,3,4,5]
	 * 	第4次：[0,1,2,3,4,5]
	 * 	第5次：[0,1,2,3,4,5]
	 * 
	 * @param arr 数组
	 */
	public static void sort(int[] arr) {
		boolean sorted = true; //标识数组是否有序
		
		for (int i = 0; i < arr.length - 1; i++) {
			sorted = true; // 假设第一趟排完后为有序数组
			if (i != 0) {
				System.out.println("\n第" + (i + 1) + "趟排序");
			}
			else {
				System.out.println("第" + (i + 1) + "趟排序");
			}
			
			for (int j = 0; j < arr.length - 1 - i; j++) {
				System.out.print("第" + (j + 1) + "次比较");
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j+1] = temp;
					sorted = false; // 如果进入比较，就说明数组还是无序，还需要比较，上面的假设不成立
				}
				
				System.out.println(Arrays.toString(arr));
			}
			
			// 每一趟比较完之后，判断数组是否已经有序，如果有序，那么就直接跳出循环，这样就可以减少比较的趟数
			if (sorted) {
				break;
			}
		}
		
		System.out.println("\n排序结果：" + Arrays.toString(arr));
	}
}
