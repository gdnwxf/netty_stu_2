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

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelId;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 
 *
 *
 * </p>
 * @author	hz1412998 
 * @date	2015年10月27日 上午9:31:14
 * @version      
 */
public class TimeClient {
    public static volatile  Map<ChannelId,CallBack> callBackMap = new HashMap<ChannelId,CallBack>();
    public static Channel channel;
    static{
	        try {
	            final TimeClientHandler  handler = new TimeClientHandler(callBackMap);
//	        	  b = new Bootstrap(); // (1)
	            Bootstrap b=new Bootstrap();;
	        	b.group(new NioEventLoopGroup());// (2)
	        	 b.channel(NioSocketChannel.class); // (3)
	        	     b.option(ChannelOption.SO_KEEPALIVE, true); // (4)
		            b.handler(new ChannelInitializer<SocketChannel>() {
		                @Override
		                public void initChannel(SocketChannel ch) throws Exception {
		                    ch.pipeline().addLast(handler);
		                }
		            });
	            ChannelFuture f = b.connect("localhost", 8080).sync(); // (5)
	            channel=f.channel();
//	            f.channel().closeFuture().sync();
//	            String response =callBackMap.get(f.channel().id()).getResponse();
	        } catch (Exception e) {
		    e.printStackTrace();
		} finally {
//	            workerGroup.shutdownGracefully();
	        }
    }
    
    
    @SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
    	ByteBufAllocator allocator = new PooledByteBufAllocator(true);
	for(int i=0;i<3;i++){
//		ByteBuf time = Unpooled.buffer();
		ByteBuf time =allocator.buffer();
        time.writeInt((int) (System.currentTimeMillis() / 1000L + 2208988800L));
        channel.flush();
	    channel.writeAndFlush(time).addListeners(new ChannelFutureListener() {
	            public void operationComplete(ChannelFuture future) {
	        	System.out.println("客户端发送数据成功");
	            }
	        }); // (4));
	}
	
	Thread.sleep(90000);
    }
}
 