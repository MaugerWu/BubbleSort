package com.cqupt.mauger.quick;

import java.util.LinkedList;

/**
 * 对链表进行排序-快速排序
 * @author Mauger
 * @date 2018年4月4日  
 * @version 1.0
 */
public class QuickSort3 {

	public static void main(String[] args) {

		LinkedList<Integer> list = new LinkedList<Integer>();
		for (int i = 0; i < 10; i++) {
			list.add((int) (Math.random() * 10) + 1);
		}
		
		System.out.println("*********初始列表**********");
		for (Integer integer : list) {
			System.out.print(integer + ", ");
		}

		quickSort(list, 0, list.size() - 1);

		System.out.println("\n*********排序列表**********");
		for (Integer integer : list) {
			System.out.print(integer + ", ");
		}
	}

	public static void quickSort(LinkedList<Integer> list, int left, int right) {
		if (left > right) {
			return;
		}
		int i = left;
		int j = right;
		int temp = list.get(left);
		while (i != j) {
			while (list.get(j) >= temp && j > i) {
				j--;
			}
			if (j > i) {
				list.set(i++, list.get(j));
			}
			
			while (list.get(i) <= temp && j > i) {
				i++;
			}
			if (j > i) {
				list.set(j--, list.get(i));
			}
		}
		
		list.set(i, temp);
		quickSort(list, left, i - 1);
		quickSort(list, i + 1, right);
	}
}
