package com.ljheee.thread.pool;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 练习使用线程池
 * @author ljheee
 *
 */
public class TestPool {

	public static void main(String[] args) {
		//4中线程池：固定大小，缓冲，单例，定时调度
//		testPool();
		
		System.out.println(Thread.currentThread().getName()+"  "+new Date().toString());
		//延时（周期性执行）
		ScheduledExecutorService service = Executors.newScheduledThreadPool(4);
		
//		service.schedule(new Runnable() {
//			
//			@Override
//			public void run() {
//				System.out.println(Thread.currentThread().getName()+"  "+new Date().toString());
//			}
//		}, 5, TimeUnit.SECONDS);//5s后执行任务
		
		service.scheduleAtFixedRate(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println(Thread.currentThread().getName()+new Date().toLocaleString());
			}
		},
				0, 				//最初延迟时间
				5,				//执行间隔
				TimeUnit.SECONDS);
		
		
		
	}


	public static void testPool() {
		int cupNum = Runtime.getRuntime().availableProcessors();
		
		//固定大小
		ExecutorService executor = Executors.newFixedThreadPool(cupNum);
//		executor.execute(new FooTask(3));
		
		//可缓存的
		executor = Executors.newCachedThreadPool();//可缓存的
		
		//单例（执行任务的队列）
		executor = Executors.newSingleThreadExecutor();
		
		
		int m[] = {56,20,1,20};
		for (int i : m) {
			executor.execute(new FooTask(i));
		}
		
		executor.shutdown();
	}
	
	
	/**
	 * 线程要执行的任务[操作]
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
