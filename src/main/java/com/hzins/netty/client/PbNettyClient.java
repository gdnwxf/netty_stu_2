/**
 * Copyright (c) 2006-2015 Hzins Ltd. All Rights Reserved. 
 *  
 * This code is the confidential and proprietary information of   
 * Hzins. You shall not disclose such Confidential Information   
 * and shall use it only in accordance with the terms of the agreements   
 * you entered into with Hzins,http://www.hzins.com.
 *  
 */   
package com.hzins.netty.client; 

import java.io.DataInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

import com.google.protobuf.ByteString;
import com.hzins.netty.protocol.PushMessageProtoc.PushMessagePB;

/**
 * <p>
 * 
 *
 *
 * </p>
 * @author	hz1412998 
 * @date	2015年10月30日 上午11:40:18
 * @version      
 */
public class PbNettyClient {
    @SuppressWarnings("unchecked")
    public static Object send(String ip, int port, PushMessagePB requestParam, Object... response) throws Exception {
	long start = System.currentTimeMillis();
	Socket socket = null;
	DataInputStream input = null;
	try {
	    socket = new Socket();
	    socket.connect(new InetSocketAddress(ip, port));
	    requestParam.writeDelimitedTo(socket.getOutputStream());
	    input = new DataInputStream(socket.getInputStream());
	   return PushMessagePB.parseDelimitedFrom(input);
	} finally {
	    try {
		input.close();
	    } catch (IOException e) {
	    }
	    try {
		socket.close();
	    } catch (IOException e) {
	    }
	}
    }


    
    public static void main(String[] args) throws Exception {
	String hello = "helloworld";
	ByteString s = ByteString.copyFromUtf8(hello);
	PushMessagePB pb = PushMessagePB.newBuilder().setToUserId(13).setParameters(s)
		.build();
	PushMessagePB result = (PushMessagePB) send("localhost", 8080, pb);
//	System.out.println(result.getFromUserId());
	System.err.println(result.getToUserId());
	System.err.print(result.getParameters().toStringUtf8());
    }
}
 