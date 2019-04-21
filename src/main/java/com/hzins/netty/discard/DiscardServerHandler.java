/**
 * Copyright (c) 2006-2015 Hzins Ltd. All Rights Reserved. 
 *  
 * This code is the confidential and proprietary information of   
 * Hzins. You shall not disclose such Confidential Information   
 * and shall use it only in accordance with the terms of the agreements   
 * you entered into with Hzins,http://www.hzins.com.
 *  
 */   
package com.hzins.netty.discard; 

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

import com.alibaba.fastjson.JSONObject;

/**
 * <p>
 * 
 *
 *
 * </p>
 * @author	hz1412998 
 * @date	2015年10月27日 上午9:29:04
 * @version      
 */
public class DiscardServerHandler extends ChannelHandlerAdapter { // (1)

    
    
    @Override
    public void channelRead(final ChannelHandlerContext ctx, Object msg) { // (2)
//	ByteBufAllocator allocator = new PooledByteBufAllocator(true);
	 System.out.println("=======allocator======");
//	  ByteBuf buffer = allocator.buffer(1024);
	  ByteBuf  buffer =  ctx.alloc().buffer();
	    try {
	       //构造订购请求消息并赋值，业务逻辑省略
	       User infoReq = new User ();
	       infoReq.setId(1);
	       infoReq.setName("hhhh");
	       //将对象编码到ByteBuf中
	       byte[] data = JSONObject.toJSONString(infoReq).getBytes();
	       int datalength = data.length;
	       buffer.writeInt(datalength);
	       buffer.writeBytes(data);
	       ctx.writeAndFlush(buffer);
//	       ctx.channel().close();
	    } finally {
		System.out.println("服务端成功发送");
		System.out.println("====ssssss=====");
	    }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) { // (4)
        // Close the connection when an exception is raised.
        cause.printStackTrace();
        ctx.close();
    }
    
    @Override
    public void channelActive(final ChannelHandlerContext ctx) { // (1)
//        final ByteBuf time = ctx.alloc().buffer(4); // (2)
//        time.writeInt((int) (System.currentTimeMillis() / 1000L + 2208988800L));
//
//        final ChannelFuture f = ctx.writeAndFlush(time); // (3)
//        f.addListener(new ChannelFutureListener() {
//            public void operationComplete(ChannelFuture future) {
//        	System.out.println("主机发送消息成功第一次握手成功");
////                assert f == future;
////                ctx.close();
//            }
//        }); // (4)
    }
    
    @Override  
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {  
        ctx.flush();  
    }
}
 