package com.cqupt.mauger.bubble;

import java.util.Arrays;

/**
 * 双向冒泡排序算法（Bidirectional Bubble Sorting Algorithm），
 * 也称为鸡尾酒排序算法（Cocktail Sorting Algorithm），是冒泡排序的一种变形。
 * 此算法与冒泡排序的不同处在于排序时是以双向在序列中进行排序。
 * @author Mauger
 * @date 2018年4月4日  
 * @version 1.0
 */
public class BidirectionalBubbleSort {

	public static void main(String[] args) {
		
		int[] arr = {9,8,7,6,5,4,3,2,1,0};
		System.out.println(cocktailSort(arr));
	}

	private static String cocktailSort(int[] arr) {
		
		int len = arr.length;
		boolean sorted = true;
		int startIndex = 0;
		int endIndex = len - 1;
		
		while (startIndex < endIndex) {
			sorted = true;
			for (int i = startIndex; i < endIndex; i++) {
				if (arr[i] > arr[i+1]) {
					int temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = temp;
					sorted = false;
				}
			}

			for (int j = endIndex - 1; j > startIndex; j--) {
				if (arr[j] < arr[j-1]) {
					int temp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = temp;
					sorted = false;
				}
			}
			
			if (sorted) {
				break;
			}
			startIndex++;
			endIndex--;
		}
		
		return Arrays.toString(arr);
	}
}
