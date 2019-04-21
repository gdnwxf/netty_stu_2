package com.hzins.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public class DatagramChannelDemo {
	
	public static void openDatagramChannel() throws IOException{
		DatagramChannel channel = DatagramChannel.open();
		channel.socket().bind(new InetSocketAddress(80));
		ByteBuffer buf = ByteBuffer.allocate(48);
		buf.clear();
		channel.receive(buf);
		buf.flip();
		Charset charset = Charset.forName("UTF-8");
		CharsetDecoder decoder = charset.newDecoder();
		CharBuffer charBuffer  = decoder.decode(buf);
		System.out.println(charBuffer.toString());
	}

	public static void main(String[] args) throws IOException {
		openDatagramChannel();
	}
}
