package com.hzins.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public class ServerSocketChannelDemo {
	public static void start() throws Exception{
		ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
		serverSocketChannel.socket().bind(new InetSocketAddress(9999));
		serverSocketChannel.configureBlocking(false);
		while(true){
			    SocketChannel socketChannel =serverSocketChannel.accept();
			    if(socketChannel != null){
			    	System.out.println("ssssssssssssss");
			    	ByteBuffer buf = ByteBuffer.allocate(48);
					int bytesRead = socketChannel.read(buf);
					buf.flip();
					Charset charset = Charset.forName("UTF-8");
					CharsetDecoder decoder = charset.newDecoder();
					CharBuffer charBuffer  = decoder.decode(buf);
					System.out.println(charBuffer.toString());
					buf.clear();
			    }
			}

	}
	
	public static void main(String[] args) throws Exception {
		start();
	}
}
