package com.hzins.netty.media;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.google.protobuf.GeneratedMessageLite;
import com.hzins.netty.constant.Constants;
import com.hzins.netty.protocol.PushMessageProtoc.PushMessagePB;
import com.hzins.util.BeanManagerUtil;

/**
 * 采用中介模式、单列模式 实现业务之间统一调度<br/>
 * 当采用protobuf协议时必须继承此类并重写getActionKeyByRequest(Object request)方法<br/>
 * <br/>
 * excute方法参数说明：<br/>
 * 第一个参数request：请求对象(Object)<br/>
 * 第二个参数ip：客户端ip(String)<br/>
 * 第三个参数ctx：ProtocolHandler中messageReceived方法传过来的ChannelHandlerContext对象<br/>
 * 第四个参数e：ProtocolHandler中messageReceived方法传过来的MessageEvent对象<br/>
 * 说明：Action的业务方法参数必须为这四个中的一个
 * 
 * 
 * @version [版本号, 2013-7-10]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Component
public class Mediator {

    private static Logger logger = LoggerFactory.getLogger(Mediator.class);

    private static Map<String, MethodBean> methods = new HashMap<String, MethodBean>();

    private static Mediator INSTANCE = null;

    public static Class<?> extendsMediator = null;

    /** 业务方法的参数类型名称 */
    private static List<String> businessMethodParameterNames = new ArrayList<String>();

    // public String ip = null;
    // public String cmd = null;

    static {
	businessMethodParameterNames.add("String");
	businessMethodParameterNames.add("ChannelHandlerContext");
	businessMethodParameterNames.add("MessageEvent");
    }

    /**
     * 注册action
     * 
     * @param baseAction
     * @see [类、类#方法、类#成员]
     */
    public void register(InitialMedia baseAction) {
	try {

	    ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
	    MetadataReaderFactory metadataReaderFactory = new CachingMetadataReaderFactory(resourcePatternResolver);
	    String packagePaths = Constants.BASE_PACKAGE; // 包目录
	    String packageSearchClassPath = "/**/*.class";

	    String packageSearchPath = "classpath*:" + packagePaths.replace(".", "/") + packageSearchClassPath;
	    Resource[] resources = resourcePatternResolver.getResources(packageSearchPath);
	    for (Resource resource : resources) {
		if (resource.isReadable()) {
		    MetadataReader metadataReader = metadataReaderFactory.getMetadataReader(resource);
		    AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
		    String annotationType = Controller.class.getName();
		    if (annotationMetadata.hasAnnotation(annotationType)) {
			System.out.println(annotationMetadata.getClassName());
			@SuppressWarnings("rawtypes")
			Class clz = Class.forName(annotationMetadata.getClassName());
			Method[] mts = clz.getDeclaredMethods();
			for (Method method : mts) {
			    if (method.isAnnotationPresent(Remote.class)) {
				// 有标识@Remote
				Remote remote = method.getAnnotation(Remote.class);
				logger.warn("注册CMD对应名字:" + remote.value());
				if (methods.containsKey(remote.value())) {
				    logger.warn("重复的CMD对应名字为:" + remote.value());
				    logger.error("register controller error repeat definition  remote name");
				    throw new RuntimeException("register controller error repeat definition  remote name");
				}

				methods.put(remote.value(), new MethodBean(method, BeanManagerUtil.getJob(clz)));
			    }
			}
		    }
		}
	    }
	} catch (Exception e) {
	    logger.error("register action error.", e);
	}
    }

    synchronized public static Mediator getInstance() {
	if (INSTANCE == null) {
	    INSTANCE = new Mediator();
	}

	return INSTANCE;
    }

    /**
     * 执行业务逻辑
     * 
     * @param args <br/>
     *        第一个参数request：请求对象(Object)<br/>
     *        第二个参数ip：客户端ip(String)<br/>
     *        第三个参数ctx：
     *        ProtocolHandler中messageReceived方法传过来的ChannelHandlerContext对象<br/>
     *        第四个参数e：ProtocolHandler中messageReceived方法传过来的MessageEvent对象<br/>
     *        说明：Action的业务方法参数必须为这四个中的一个
     * @return
     * @throws InvocationTargetException 
     * @throws IllegalArgumentException 
     * @throws IllegalAccessException 
     * @see [类、类#方法、类#成员]
     */
    public Object execute(PushMessagePB pb) throws Exception {
	long start = System.currentTimeMillis();
	    MethodBean mb = methods.get(pb.getCmd());
	    if (mb == null) {
		logger.error("客户端传的参数错误：  数据内容为：{}", pb);
		return null;
	    }

	     Method m = mb.getMethod();
	      Class<?>[] paratemers = m.getParameterTypes();
	       Object returnobj = null;
//		returnobj = mb.getMethod().invoke(mb.getObj(), pb.getParameters().toByteArray().);
               return returnobj;
    }
    private List<String> noNames(Class<?>[] paratemers) {
	List<String> noNames = new ArrayList<String>();
	if (paratemers == null || paratemers.length == 0)
	    return noNames;

	for (int i = 0; i < paratemers.length; i++) {
	    String psName = paratemers[i].getSimpleName();
	    if (!businessMethodParameterNames.contains(psName))
		noNames.add(psName);
	}
	return noNames;
    }
}
