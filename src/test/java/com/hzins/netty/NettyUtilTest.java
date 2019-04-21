/**
 * Copyright (c) 2006-2015 Hzins Ltd. All Rights Reserved. 
 *  
 * This code is the confidential and proprietary information of   
 * Hzins. You shall not disclose such Confidential Information   
 * and shall use it only in accordance with the terms of the agreements   
 * you entered into with Hzins,http://www.hzins.com.
 *  
 */   
package com.hzins.netty; 

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

import com.hzins.netty.discard.CallBack;
import com.hzins.netty.discard.TimeClient;

/**
 * <p>
 * 
 *
 *
 * </p>
 * @author	hz1412998 
 * @date	2015年10月28日 上午9:41:04
 * @version      
 */
public class NettyUtilTest {
    
    @Test
    public void testClient() throws Exception{
	
	for(int i=0;i<400;i++){
	    Runnable r =  new Runnable() {
		public void run() {
		    final  CallBack callBack =new CallBack();
			  String sp=null;
			try {
			    long start = System.currentTimeMillis();
//			    sp = TimeClient.start(callBack);
			 if(sp==null || sp.equals("")){
				    throw new RuntimeException();
			  }
			 System.out.println("返回值为"+sp);
			long end = System.currentTimeMillis();
			 System.out.println("耗時====={}"+(end-start)+"ms");
			} catch (Exception e) {
			    e.printStackTrace();
			}
		
		}
	    };
	    
	   Thread t = new Thread(r );
	   t.start();
	}
	Thread.sleep(20000000);
	
    }
    
    
    @Test
public void testClient2() throws Exception{
	ExecutorService service = Executors.newFixedThreadPool(50);
		for (int i = 0; i < 100; ++i) {
			final int index = i;
			Callable<Void> task = new Callable<Void>() {
				@Override
				public Void call() throws Exception {
				    final  CallBack callBack =new CallBack();
					  String sp=null;
					try {
					    long start = System.currentTimeMillis();
//					    sp = TimeClient.start(callBack);
					 if(sp==null || sp.equals("")){
						    throw new RuntimeException();
					  }
					 System.out.println(index+"返回值为"+sp);
					long end = System.currentTimeMillis();
					 System.out.println("耗時====={}"+(end-start)+"ms");
					} catch (Throwable e) {
					}
					return null;
				}
			};
			service.submit(task);
		}
		service.shutdown();
		service.awaitTermination(10, TimeUnit.MINUTES);
}

}
 