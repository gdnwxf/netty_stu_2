package com.hzins.netty.constant;


public class Constants
{
    public static final String BASE_PACKAGE = "com.hzins";
    
    /** json **/
    public static final String JSON = "json";
    
    /** protobuf **/
    public static final String PB = "protobuf";
    
    /** 默认时间格式 **/
    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    
    /** Date默认时区 **/
    public static final String DATE_TIMEZONE = "GMT+8";
    
    /** UTF-8字符集 **/
    public static final String CHARSET_UTF8 = "UTF-8";
    
    /** 系统异常编号 **/
//    public static final String SYSTEM_ERROR_CODE_KEY = "exception.code";
    
    /**配置文件名称 ca-server.properties*/
    public static final String DEFAULT_PROPERTIES = "server.properties";
    
    public static final String SERVER_NAME_KEY = "server.name";
    
    public static final String SERVER_NETTY_PORT_KEY = "server.netty.port";
    
//    public static final String SERVER_NETTY_IP_KEY = "server.netty.ip";
    
    public static final String PROTOCOL_TYPE_KEY = "protocol.type";
    
    public static final String HEARTBEAT_SWITCH_KEY = "heartbeat.switch";
    
    public static final String HEARTBEAT_READIDLE_KEY = "heartbeat.readerIdleTimeMillis";
    
    public static final String HEARTBEAT_WRITEIDLE_KEY = "heartbeat.writerIdleTimeMillis";
    
    public static final String HEARTBEAT_ALLIDLE_KEY = "heartbeat.allIdleTimeMillis";
    
    public static final String EXECUTION_THREADPOOL_CLASS_KEY = "execution.threadpool.class";
    
    public static final String EXECUTION_THREADPOOL_SIZE_KEY = "execution.threadpool.size";
    
    public static final String EXECUTION_THREADPOOL_MAXCHANNELMEMORYSIZE_KEY =
        "execution.threadpool.maxChannelMemorySize";
    
    public static final String EXECUTION_THREADPOOL_MAXTOTALMEMORYSIZE_KEY = "execution.threadpool.maxTotalMemorySize";

    
    /**ExecutionHandler的线程池模型,netty提供了两种MemoryAwareThreadPoolExecutor与OrderedMemoryAwareThreadPoolExecutor，为空表示不指定线程模型*/
    public static String EXECUTION_THREADPOOL_CLASS;
    
    /**业务处理线程池个数(活动线程的最大数量),worker execution threads*/
    public static int EXECUTION_THREADPOOL_SIZE;
    
    /**每个通道排队事件的内存总大小，单位MB，默认0禁用*/
    public static int EXECUTION_THREADPOOL_MAXCHANNELMEMORYSIZE;
    
    /**该线程池队事件的内存总大小，单位MB，默认0禁用*/
    public static int EXECUTION_THREADPOOL_MAXTOTALMEMORYSIZE;
    
    
    /**心跳开关*/
    public static String HEARTBEAT_SWITCH = "off";
    
    /**读空闲时多少秒一次心跳，为0时禁用*/
    public static int HEARTBEAT_READIDLE;
    
    /**写空闲时多少秒一次心跳，为0时禁用*/
    public static int HEARTBEAT_WRITEIDLE;
    
    /**读且写空闲时多少秒一次心跳，为0时禁用*/
    public static int HEARTBEAT_ALLIDLE;
    
    /**协议类型：json,protobuf*/
    public static String PROTOCOL_TYPE = "json";
    
    /**netty默认端口*/
    public static int PORT = -1;
    
    /**netty监听IP*/
//    public static String IP;
    
    /**服务名称*/
    public static String SERVER_NAME = "server";
    
    /**系统错误码*/
//    public static String  SYSTEM_ERROR_CODE="10000";
    
}
