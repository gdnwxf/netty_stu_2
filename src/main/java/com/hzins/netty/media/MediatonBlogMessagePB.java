/**
 * Copyright (c) 2006-2015 Hzins Ltd. All Rights Reserved. 
 *  
 * This code is the confidential and proprietary information of   
 * Hzins. You shall not disclose such Confidential Information   
 * and shall use it only in accordance with the terms of the agreements   
 * you entered into with Hzins,http://www.hzins.com.
 *  
 */   
package com.hzins.netty.media; 

import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage.Builder;
import com.google.protobuf.MessageLite;
import com.hzins.netty.protocol.PushMessageProtoc.PushMessagePB;

/**
 * <p>
 * 
 *
 *
 * </p>
 * @author	hz1412998 
 * @date	2015年10月30日 上午10:10:34
 * @version      
 */
public class MediatonBlogMessagePB {
    
    public static MessageLite getPbInstance()
    {
        return PushMessagePB.getDefaultInstance();
    }
    
}
 