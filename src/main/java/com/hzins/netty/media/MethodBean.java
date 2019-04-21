package com.hzins.netty.media;

import java.lang.reflect.Method;

public class MethodBean
{
    private Method method;
    
    private Object obj;
    
    public MethodBean(Method method, Object obj)
    {
        super();
        this.method = method;
        this.obj = obj;
    }
    
    public Method getMethod()
    {
        return method;
    }
    
    public void setMethod(Method method)
    {
        this.method = method;
    }
    
    public Object getObj()
    {
        return obj;
    }
    
    public void setObj(Object obj)
    {
        this.obj = obj;
    }
    
}
