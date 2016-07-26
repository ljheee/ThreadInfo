package com.ljheee.set.util;

import java.util.Arrays;

public class SuperArray {
	
	int[] m;
	int capacity;
	int size = 0;

	public SuperArray(int capacity) {
		this.capacity = capacity;
		m = new int[capacity];
	}

	public SuperArray() {
		m = new int[10];
	}
	
	
	public void add(int n){
		if (capacity == size){
			//ÂúÁË£¬×Ô¶¯À©ÈÝ
			m = Arrays.copyOf(m, m.length+10);
			capacity = m.length;
		}
		m[size++] = n;
	}
	
	public static void main(String[] args) {
		SuperArray list = new SuperArray(4);
		for (int i = 0; i < 50; i++) {
			list.add(i);
		}
	}
	
}
