package com.hzins.aio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;

public class AioServerDemo {
	private static CountDownLatch latch;
	public static void startServer() throws Exception{
		final AsynchronousServerSocketChannel server = AsynchronousServerSocketChannel.open();
		server.bind(new InetSocketAddress(8999));
		  latch = new CountDownLatch(1);
		  server.accept(null, new CompletionHandler<AsynchronousSocketChannel, Void>() {  
	          @Override 
			  public void completed(AsynchronousSocketChannel ch, Void att) {  
	                // 接受下一个连接  
	        	  server.accept(att, this);  
	                // 处理当前连接  
	                try {
			    handle(ch);
			} catch (Exception e) {
			    e.printStackTrace();
			}  
	            }  
	           
				public void failed(Throwable exc, Void att) {  
	            	latch.countDown();
	            }  
	        });  
	        latch .await();
	}

	 public static void handle(AsynchronousSocketChannel ch) throws InterruptedException, ExecutionException, CharacterCodingException {
		 ByteBuffer bufw = ByteBuffer.allocate(48);
//			bufw.clear();
//			bufw.flip();
			ch.read(bufw).get();
			bufw.flip();
			Charset charset = Charset.forName("UTF-8");
			CharsetDecoder decoder = charset.newDecoder();	
			System.out.println(decoder.decode(bufw));
		}
	 
	 public static void main(String[] args) throws Exception {
		startServer();
	}
}
