package com.ljheee.set.util;

import java.util.Arrays;
import java.util.Collections;

public class TestArrays {
	
	
	public static void main(String[] args) {
		int m[] = {45,6,89,1,0,3,7,56,12,46};
		
		Arrays.sort(m);
		
		//����������Ҫ�������ٶȿ�
		int index = Arrays.binarySearch(m, 12);
	
		int a[] = {4,6,8,9,11};
		int b[] = {14,2,3,7};
		
		//ʵ������ϲ�
		int[] c = Arrays.copyOf(a, a.length+b.length);//���鸴��
		for (int i = 0; i < b.length; i++) {
			c[i+a.length] = b[i];
		}
		
		
		Arrays.fill(b, 9);//������b��ȫ���9
		
		//��ת����
//		Collections.reverse(list);
//		Collections.shuffle(list);//����
		
		for (int i = 0; i < m.length/2; i++) {
			//����i��m.length-1-i
			int temp = m[i];
			m[i] = m[m.length-1-i];
			m[m.length-1-i] = temp;
		}
		
		
		
		System.out.println(Arrays.toString(c));
		
		
	}
}