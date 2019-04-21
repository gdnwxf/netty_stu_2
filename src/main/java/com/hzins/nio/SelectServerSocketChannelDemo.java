package com.hzins.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.Iterator;
import java.util.Set;

public class SelectServerSocketChannelDemo {
	public static void start() throws Exception{
		ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
		serverSocketChannel.socket().bind(new InetSocketAddress(9999));
		
		/*while(true){
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
			}*/
		Selector selector = Selector.open();
		serverSocketChannel.configureBlocking(false);
	    SelectionKey key1 = serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
		 while(true) {
			 int readyChannels = selector.select();
			   if(readyChannels == 0) continue;
	    	  Set selectedKeys = selector.selectedKeys();
		      Iterator<SelectionKey> keyIterator = selectedKeys.iterator();
		   while(keyIterator.hasNext()) {
			      SelectionKey key = keyIterator.next();
			     if(key.isAcceptable()) {
			    	 System.out.println("start acceptable");
			    	 SocketChannel  socketChannel = ((ServerSocketChannel) key.channel()).accept() ;
			    		String newData = "New String to write to file";
			    		  ByteBuffer buf = ByteBuffer.allocate(48);
			    		buf.clear();
			    		buf.put(newData.getBytes("UTF-8"));
			    		buf.flip();
			    		socketChannel.write(buf);
			    		buf.clear();
			      } else if (key.isConnectable()) {
			    	  System.out.println("start connectable");
			      } else if (key.isReadable()) {
			    	  SocketChannel socketChannel = (SocketChannel)key.channel();
			    	  ByteBuffer buf = ByteBuffer.allocate(48);
						int bytesRead = socketChannel.read(buf);
						buf.flip();
						Charset charset = Charset.forName("UTF-8");
						CharsetDecoder decoder = charset.newDecoder();
						CharBuffer charBuffer  = decoder.decode(buf);
						System.out.println(charBuffer.toString());
						buf.clear();
			     } else if (key.isWritable()) {
			     }
			    keyIterator.remove();
			}

		 }
		
	}
	
	public static void main(String[] args) throws Exception {
		start();
	}
}
