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

/**
 * <p>
 * 
 *
 *
 * </p>
 * @author	hz1412998 
 * @date	2015年10月27日 下午7:59:09
 * @version      
 */
public class CallBack {
    private String response;
    
    
    
    
    public String getResponse() {
        return response;
    }



    
    public void setResponse(String response) {
        this.response = response;
    }



    public Object execute(Object result){
	return result;
    }

}
 