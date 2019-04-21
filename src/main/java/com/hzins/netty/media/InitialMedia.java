package com.hzins.netty.media;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

/**
 * 中介模式 之业务请求动作跳转调度 
 * @author  walle
 * @version  [版本号, 2013-7-10]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Component
public  class InitialMedia  implements InitializingBean
{
    protected Logger logger = LoggerFactory.getLogger(this.getClass());
    
    protected Mediator mediator = Mediator.getInstance();
    

    @Override
    public void afterPropertiesSet() throws Exception {
	// TODO Auto-generated method stub
	 Mediator.getInstance().register(this);
    }
    
}
