/**
 * Copyright (c) 2006-2015 Hzins Ltd. All Rights Reserved. 
 *  
 * This code is the confidential and proprietary information of   
 * Hzins. You shall not disclose such Confidential Information   
 * and shall use it only in accordance with the terms of the agreements   
 * you entered into with Hzins,http://www.hzins.com.
 *  
 */   
package com.hzins.netty.channel; 

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

import com.google.protobuf.ByteString;
import com.hzins.netty.protocol.PushMessageProtoc.PushMessagePB;


/**
 * <p>
 * 
 *
 *
 * </p>
 * @author	hz1412998 
 * @date	2015年10月30日 上午11:34:56
 * @version      
 */
public class PbHandler extends ChannelHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
	PushMessagePB pb = (PushMessagePB)msg;
	ByteString s = pb.getParameters();
	s.toByteArray();
	ctx.writeAndFlush(resp(pb.getToUserId()));
	ctx.channel().close();
    }

    private PushMessagePB.Builder resp(long toUserId) {
	PushMessagePB.Builder response = PushMessagePB.newBuilder();
	response.setFromUserId(toUserId);
	response.setToUserId(322);
	String hello = "helloworldsss";
	ByteString s = ByteString.copyFromUtf8(hello);
	response.setParameters(s);
	return response;
    }
    
    

}
 