package com.cqupt.mauger.insertion;

import java.util.Arrays;

/**
 * 直接插入排序 （Straight Insertion Sort）的基本操作是将一个记录插入到已经排好序的有序表中，
 * 从而得到一个新的、记录数增 1 的有序表，它的工作原理非常类似于我们抓扑克牌。
 * 
 * 分类：
 * 	属于内部排序-插入排序
 * 
 * 时间复杂度：
 * 	最坏情况-反序为 O(n^2)，最好情况-正序 O(n)，平均 O(n^2)
 * 
 * 稳定性：
 * 	稳定
 * 
 * @author Mauger
 * @date 2018年4月27日  
 * @version 1.0
 */
public class InsertionSort 
{

	public static String insertionSort(int[] arr)
	{
		int i, j;
		for (i = 1; i < arr.length; i++)
		{
			if (arr[i] < arr[i - 1])
			{
				int temp = arr[i]; // 设置哨兵，抓牌
				for (j = i - 1; arr[j] > temp; j--)
				{
					arr[j + 1] = arr[j]; // 记录后移
				}
				arr[j + 1] = temp; // 插入到正确的位置
			}
		}
		return Arrays.toString(arr);
	}
	
	/**
	 * 另一种写法
	 * @param arr int[]
	 * @return String
	 */
	public static String insertionSort1(int[] arr)
	{
		for (int i = 1; i < arr.length; i++) // 默认 arr[0]为有序序列
		{
			int get = arr[i]; // 右手抓牌
			int j = i - 1; // 左手牌有序
			while (j >= 0 && arr[j] > get)
			{
				arr[j + 1] = arr[j]; // 若左手牌比拿到的牌大，则后移
				j--;
			}
			arr[j + 1] = get; // 将牌插入到正确的位置
		}
		return Arrays.toString(arr);
	}
	
	public static void main(String[] args)
	{
		int[] arr = {0, 5, 3, 4, 6, 2};
		System.out.println(InsertionSort.insertionSort(arr) + "\n" + InsertionSort.insertionSort1(arr));
	}
}
