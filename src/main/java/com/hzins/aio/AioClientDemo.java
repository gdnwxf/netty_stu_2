package com.hzins.aio;

import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.Future;

public class AioClientDemo {
	
	public static void startClient() throws Exception{
		AsynchronousSocketChannel asySocketChannel = AsynchronousSocketChannel.open();
		Future<?>future = asySocketChannel.connect(new InetSocketAddress("localhost", 8999));
		future.get();
		ByteBuffer buf = ByteBuffer.wrap("hello aio server".getBytes("UTF-8"));
		asySocketChannel.write(buf);
//		asySocketChannel.close();
	}

	public static void main(String[] args) throws Exception {
		startClient();
	}
}
