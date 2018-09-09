package com.cqupt.mauger.insertion;

import java.util.Arrays;

/**
 * 二分插入排序
 * 	对于插入排序，如果比较操作的代价比交换操作大的话，可以采用二分查找法来减少比较操作的次数，我们称之为二分插入排序
 * 
 * 分类：
 * 	属于内部排序-插入排序
 * 
 * 时间复杂度：
 * 	最坏情况-反序为 O(n^2)，最好情况-正序 O(nlogN)，平均 O(n^2)
 * 
 * 稳定性：
 * 	稳定
 * 
 * @author Mauger
 * @date 2018年4月27日    
 * @version 1.0
 */
public class InsertionSortPlus
{

	public static String insertionSortPlus(int[] arr)
	{
		for (int i = 1; i < arr.length; i++)
		{
			int get = arr[i];
			int left = 0;
			int right = i - 1;
			while (left <= right)
			{
				int mid = (left + right) / 2;
				if (arr[mid] > get)
				{
					right = mid - 1;
				} 
				else
				{
					left = mid + 1;
				}
			}
			
			for (int j = i - 1; j >= left; j--)
			{
				arr[j + 1] = arr[j];
			}
			arr[left] = get;
		}
		return Arrays.toString(arr);
	}
	
	public static void main(String[] args)
	{
		int[] arr = {0, 5, 3, 4, 6, 2};
		System.out.println(InsertionSortPlus.insertionSortPlus(arr));
	}
}
