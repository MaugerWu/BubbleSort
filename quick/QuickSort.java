package com.cqupt.mauger.quick;

import java.util.LinkedList;

/**
 * 快速排序算法（Quick Sort Algorithm）
 * 
 * 分类：
 * 	属于交换排序
 * 
 * @author Mauger
 * @date 2018年4月4日  
 * @version 1.0
 */
public class QuickSort
{
	public static void main(String[] args)
	{
		LinkedList<Integer> list = new LinkedList<Integer>();
		for (int i = 0; i < 10; i++)
		{
			list.add((int) (Math.random() * 100) + 1);
		}
		for (Integer integer : list)
		{
			System.out.print(integer + ", ");
		}
	}
	
}
