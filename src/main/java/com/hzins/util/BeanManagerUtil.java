/**
 * Copyright (c) 2006-2015 Hzins Ltd. All Rights Reserved. 
 *  
 * This code is the confidential and proprietary information of   
 * Hzins. You shall not disclose such Confidential Information   
 * and shall use it only in accordance with the terms of the agreements   
 * you entered into with Hzins,http://www.hzins.com.
 *  
 */   
package com.hzins.util; 

import org.springframework.beans.BeanUtils;

/**
 * <p>
 * 
 *
 *
 * </p>
 * @author	hz1412998 
 * @date	2015年2月5日 上午11:30:53
 * @version      
 */
public class BeanManagerUtil {

    public static  <T> T getJob(Class<T> clazz) {
	T bean = null;
	T bean2;
	try {
	    bean2 = SpringContextHolder.getBean(clazz);
	    if (bean2 != null) {
		return (T) bean2;
	    }
	} catch (Exception e) {
	}

	bean = (T) BeanUtils.instantiate(clazz);

	// 注入
	SpringContextHolder.getApplicationContext().getAutowireCapableBeanFactory().autowireBean(bean);
	return bean;
    }

}
 