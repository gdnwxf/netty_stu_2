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

import java.net.SocketAddress;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelHandlerInvoker;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.ChannelPromise;
import io.netty.util.concurrent.EventExecutorGroup;

/**
 * <p>
 * 
 *
 *
 * </p>
 * @author	hz1412998 
 * @date	2015年10月29日 下午3:24:59
 * @version      
 */
public class MyChannelPipeline implements ChannelPipeline{

    @Override
    public Iterator<Entry<String, ChannelHandler>> iterator() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public ChannelPipeline addFirst(String name, ChannelHandler handler) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public ChannelPipeline addFirst(EventExecutorGroup group, String name, ChannelHandler handler) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public ChannelPipeline addFirst(ChannelHandlerInvoker invoker, String name, ChannelHandler handler) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public ChannelPipeline addLast(String name, ChannelHandler handler) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public ChannelPipeline addLast(EventExecutorGroup group, String name, ChannelHandler handler) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public ChannelPipeline addLast(ChannelHandlerInvoker invoker, String name, ChannelHandler handler) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public ChannelPipeline addBefore(String baseName, String name, ChannelHandler handler) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public ChannelPipeline addBefore(EventExecutorGroup group, String baseName, String name, ChannelHandler handler) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public ChannelPipeline addBefore(ChannelHandlerInvoker invoker, String baseName, String name, ChannelHandler handler) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public ChannelPipeline addAfter(String baseName, String name, ChannelHandler handler) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public ChannelPipeline addAfter(EventExecutorGroup group, String baseName, String name, ChannelHandler handler) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public ChannelPipeline addAfter(ChannelHandlerInvoker invoker, String baseName, String name, ChannelHandler handler) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public ChannelPipeline addFirst(ChannelHandler... handlers) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public ChannelPipeline addFirst(EventExecutorGroup group, ChannelHandler... handlers) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public ChannelPipeline addFirst(ChannelHandlerInvoker invoker, ChannelHandler... handlers) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public ChannelPipeline addLast(ChannelHandler... handlers) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public ChannelPipeline addLast(EventExecutorGroup group, ChannelHandler... handlers) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public ChannelPipeline addLast(ChannelHandlerInvoker invoker, ChannelHandler... handlers) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public ChannelPipeline remove(ChannelHandler handler) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public ChannelHandler remove(String name) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public <T extends ChannelHandler> T remove(Class<T> handlerType) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public ChannelHandler removeFirst() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public ChannelHandler removeLast() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public ChannelPipeline replace(ChannelHandler oldHandler, String newName, ChannelHandler newHandler) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public ChannelHandler replace(String oldName, String newName, ChannelHandler newHandler) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public <T extends ChannelHandler> T replace(Class<T> oldHandlerType, String newName, ChannelHandler newHandler) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public ChannelHandler first() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public ChannelHandlerContext firstContext() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public ChannelHandler last() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public ChannelHandlerContext lastContext() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public ChannelHandler get(String name) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public <T extends ChannelHandler> T get(Class<T> handlerType) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public ChannelHandlerContext context(ChannelHandler handler) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public ChannelHandlerContext context(String name) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public ChannelHandlerContext context(Class<? extends ChannelHandler> handlerType) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Channel channel() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public List<String> names() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Map<String, ChannelHandler> toMap() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public ChannelPipeline fireChannelRegistered() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public ChannelPipeline fireChannelUnregistered() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public ChannelPipeline fireChannelActive() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public ChannelPipeline fireChannelInactive() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public ChannelPipeline fireExceptionCaught(Throwable cause) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public ChannelPipeline fireUserEventTriggered(Object event) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public ChannelPipeline fireChannelRead(Object msg) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public ChannelPipeline fireChannelReadComplete() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public ChannelPipeline fireChannelWritabilityChanged() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public ChannelFuture bind(SocketAddress localAddress) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public ChannelFuture connect(SocketAddress remoteAddress) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public ChannelFuture connect(SocketAddress remoteAddress, SocketAddress localAddress) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public ChannelFuture disconnect() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public ChannelFuture close() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public ChannelFuture deregister() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public ChannelFuture bind(SocketAddress localAddress, ChannelPromise promise) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public ChannelFuture connect(SocketAddress remoteAddress, ChannelPromise promise) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public ChannelFuture connect(SocketAddress remoteAddress, SocketAddress localAddress, ChannelPromise promise) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public ChannelFuture disconnect(ChannelPromise promise) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public ChannelFuture close(ChannelPromise promise) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public ChannelFuture deregister(ChannelPromise promise) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public ChannelPipeline read() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public ChannelFuture write(Object msg) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public ChannelFuture write(Object msg, ChannelPromise promise) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public ChannelPipeline flush() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public ChannelFuture writeAndFlush(Object msg, ChannelPromise promise) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public ChannelFuture writeAndFlush(Object msg) {
	// TODO Auto-generated method stub
	return null;
    }

}
 