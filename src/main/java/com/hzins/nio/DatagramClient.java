package com.hzins.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class DatagramClient {
	public static void main(String[] args) throws IOException {
		ByteBuffer buf = ByteBuffer.allocate(48);
		String newData = "New String to write to file";
		buf.clear();
		buf.put(newData.getBytes("UTF-8"));
		buf.flip();
		DatagramChannel channel = DatagramChannel.open();
		int bytesSent = channel.send(buf, new InetSocketAddress("localhost", 80));
	}

}
