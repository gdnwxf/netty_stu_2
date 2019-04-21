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

import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;

import com.hzins.netty.media.MediatonBlogMessagePB;

/**
 * <p>
 * 
 *
 *
 * </p>
 * @author	hz1412998 
 * @date	2015年10月29日 下午3:37:09
 * @version      
 */
@Sharable
public class MutilChannelInitializer extends ChannelInitializer<SocketChannel>{

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
	  // TODO Aut
	   ChannelPipeline pipeline = ch.pipeline();
	    pipeline.addLast(new ProtobufVarint32FrameDecoder());
	    pipeline.addLast(new ProtobufDecoder(MediatonBlogMessagePB.getPbInstance()));
	    pipeline.addLast( new ProtobufVarint32LengthFieldPrepender());
	    pipeline.addLast(new ProtobufEncoder());
//	    pipeline.addLast("aggregator", new HttpObjectAggregator(Integer.MAX_VALUE));
	    ch.pipeline().addLast(new PbHandler());
    }
   
}
 