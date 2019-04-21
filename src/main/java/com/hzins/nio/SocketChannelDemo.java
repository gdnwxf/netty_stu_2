package com.hzins.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class SocketChannelDemo {

	public static void start() throws Exception{
		SocketChannel socketChannel = SocketChannel.open();
		socketChannel.configureBlocking(true);
		socketChannel.connect(new InetSocketAddress("localhost", 9999));
		
	/*	while(!socketChannel.finishConnect() ){
			    //wait, or do something else...
			}*/
		Thread.sleep(1000);
		String newData = "New String to write to file...";
		ByteBuffer bufw = ByteBuffer.allocate(48);
		bufw.clear();
		bufw.put(newData.getBytes("UTF-8"));
		bufw.flip();
		
		  ByteBuffer writeBuffer = ByteBuffer.wrap(newData.getBytes("UTF-8"));  
	        socketChannel.write(writeBuffer);  
	        System.out.println("写入成功");
	        
	        ByteBuffer rbuf = ByteBuffer.allocate(48);
	       int size =  socketChannel.read(rbuf);
	       while(size>0){
	    	  rbuf.flip();
	    	  Charset charset = Charset.forName("UTF-8");
	    	  System.out.println(charset.newDecoder().decode(rbuf));
	    	  rbuf.clear();
	    	  size =  socketChannel.read(rbuf);
	       }
	        
	        writeBuffer.clear();
//		socketChannel.write(bufw);
//		socketChannel.close();
		bufw.clear();
		Thread.sleep(30000);
	}
	
	public static void main(String[] args) throws Exception {
		start();
	}
}
