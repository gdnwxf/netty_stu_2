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
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelId;
import io.netty.channel.ChannelPromise;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.ChannelHandler.Sharable;

import java.util.Map;

/**
 * <p>
 * 
 *
 *
 * </p>
 * @author	hz1412998 
 * @date	2015年10月27日 上午9:31:41
 * @version      
 */
@Sharable
public class TimeClientHandler extends SimpleChannelInboundHandler<ByteBuf> {  
    private ByteBuf buf;

    private  volatile Map<ChannelId,CallBack> callBackMap;
    
    public TimeClientHandler(Map<ChannelId, CallBack> callBackMap) {
	super();
	this.callBackMap = callBackMap;
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) {
//        buf = ctx.alloc().buffer(4); // (1)
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) {
//        buf.release(); // (1)
//        buf = null;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
	buf = ctx.alloc().buffer();
        ByteBuf m = (ByteBuf) msg;
        buf.writeBytes(m); // (2)
        m.release();
        if (buf.readableBytes() >= 4) { // (3)
            int datalength = buf.getInt(buf.readerIndex());
            if (buf.readableBytes() < datalength + 4){
                 return ;
            }
            buf.skipBytes(4);
            byte[] decoded = new byte[datalength];
            buf.readBytes(decoded);
            String json = new String(decoded);
            CallBack callBack = new CallBack();
            callBack.setResponse(json);
            callBackMap.put(ctx.channel().id(), callBack);
            System.out.println("客户端收到数据为"+json);
//            ctx.channel().close();
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
	 final ByteBuf time = ctx.alloc().buffer(4); // (2)
	        time.writeInt((int) (System.currentTimeMillis() / 1000L + 2208988800L));

	        final ChannelFuture f = ctx.writeAndFlush(time); // (3)
//	        f.addListener(new ChannelFutureListener() {
//	            public void operationComplete(ChannelFuture future) {
//	        	System.out.println("客户端发送数据成功");
////	                assert f == future;
////	                ctx.close();
//	            }
//	        }); // (4)
    }

    @Override
    protected void messageReceived(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
	// TODO Auto-generated method stub
	
    }

    
    public ByteBuf getBuf() {
        return buf;
    }

    
    public void setBuf(ByteBuf buf) {
        this.buf = buf;
    }

	@Override
	public void write(ChannelHandlerContext ctx, Object msg,
			ChannelPromise promise) throws Exception {
		// TODO Auto-generated method stub
		ctx.writeAndFlush(msg, promise);
	}

   
    


    

    
    

}
 