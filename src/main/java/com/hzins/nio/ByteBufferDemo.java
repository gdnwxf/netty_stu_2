package com.hzins.nio;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public class ByteBufferDemo {
	
	
	
	public static void getFile(String fileName) throws Exception{
		RandomAccessFile aFile = new RandomAccessFile(fileName, "rw");
		FileChannel inChannel = aFile.getChannel();
		ByteBuffer buf = ByteBuffer.allocate(10);
		int bytesRead = inChannel.read(buf);
		CharBuffer charBuffer = null;
		while(bytesRead !=-1){
			buf.flip();
			Charset charset = Charset.forName("UTF-8");
			CharsetDecoder decoder = charset.newDecoder();
			charBuffer = decoder.decode(buf);
			System.out.println(charBuffer.toString());
			/*while(buf.hasRemaining()){
				System.out.println(buf.get());
			}*/
			buf.clear();
			bytesRead = inChannel.read(buf);
		}
		
		aFile.close();
		
	}
	
	public static void main(String[] args) throws Exception {
		getFile("file/1.txt");
	}

}
