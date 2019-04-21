//  ==================================================================
//  文件名:CaMain 
//  简要功能描述:
//
//  Created by walle on 2012-11-14.
//  Copyright (c) 2011-2012年 深圳房多多科技有限公司. All rights reserved.
//  ==================================================================
package com.hzins.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 启动类
 * @author  walle
 * @version  [版本号, 2012-11-14]
 */
public class ServerMain
{
    
    
    private static volatile boolean running = true;
    
    public static void main(String[] args)
    {
            final ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("classpath*:applicationContext.xml");
            context.start();
        synchronized (ServerMain.class)
        {
            while (running)
            {
                try
                {
                    ServerMain.class.wait();
                }
                catch (Throwable e)
                {
                }
            }
        }
    }
}
