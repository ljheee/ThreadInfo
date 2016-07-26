package com.ljheee.thread.pool;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * ��ϰʹ���̳߳�
 * @author ljheee
 *
 */
public class TestPool {

	public static void main(String[] args) {
		//4���̳߳أ��̶���С�����壬��������ʱ����
//		testPool();
		
		System.out.println(Thread.currentThread().getName()+"  "+new Date().toString());
		//��ʱ��������ִ�У�
		ScheduledExecutorService service = Executors.newScheduledThreadPool(4);
		
//		service.schedule(new Runnable() {
//			
//			@Override
//			public void run() {
//				System.out.println(Thread.currentThread().getName()+"  "+new Date().toString());
//			}
//		}, 5, TimeUnit.SECONDS);//5s��ִ������
		
		service.scheduleAtFixedRate(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println(Thread.currentThread().getName()+new Date().toLocaleString());
			}
		},
				0, 				//����ӳ�ʱ��
				5,				//ִ�м��
				TimeUnit.SECONDS);
		
		
		
	}


	public static void testPool() {
		int cupNum = Runtime.getRuntime().availableProcessors();
		
		//�̶���С
		ExecutorService executor = Executors.newFixedThreadPool(cupNum);
//		executor.execute(new FooTask(3));
		
		//�ɻ����
		executor = Executors.newCachedThreadPool();//�ɻ����
		
		//������ִ������Ķ��У�
		executor = Executors.newSingleThreadExecutor();
		
		
		int m[] = {56,20,1,20};
		for (int i : m) {
			executor.execute(new FooTask(i));
		}
		
		executor.shutdown();
	}
	
	
	/**
	 * �߳�Ҫִ�е�����[����]
	 * @author Administrator
	 *
	 */
	static class FooTask implements Runnable{

		int n;
		
		public FooTask(int n) {
			this.n = n;
		}

		
		@Override
		public void run() {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.printf("%s %d*%d=%d\n",Thread.currentThread().getName(),n,n,n*n);
		}
		
	}
	
	
}
