package com.ljheee.set.util;

import java.util.Arrays;
import java.util.Collections;

public class TestArrays {
	
	
	public static void main(String[] args) {
		int m[] = {45,6,89,1,0,3,7,56,12,46};
		
		Arrays.sort(m);
		
		//二分搜索；要求有序、速度快
		int index = Arrays.binarySearch(m, 12);
	
		int a[] = {4,6,8,9,11};
		int b[] = {14,2,3,7};
		
		//实现数组合并
		int[] c = Arrays.copyOf(a, a.length+b.length);//数组复制
		for (int i = 0; i < b.length; i++) {
			c[i+a.length] = b[i];
		}
		
		
		Arrays.fill(b, 9);//把数组b，全填冲9
		
		//反转数组
//		Collections.reverse(list);
//		Collections.shuffle(list);//打乱
		
		for (int i = 0; i < m.length/2; i++) {
			//交换i和m.length-1-i
			int temp = m[i];
			m[i] = m[m.length-1-i];
			m[m.length-1-i] = temp;
		}
		
		
		
		System.out.println(Arrays.toString(c));
		
		
	}
}