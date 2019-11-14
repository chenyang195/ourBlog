package com.blog.ourblog.log;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.apache.tomcat.util.net.IPv6Utils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


@Aspect
@Component
public class MyLogAdvice {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Pointcut("@annotation(com.blog.ourblog.log.MyLog)")
    public void myPointcut(){

    }
    @AfterReturning(pointcut ="myPointcut()" )
    public void myAfterRet(JoinPoint joinPoint){
        MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        MyLog annotation = method.getAnnotation(MyLog.class);
        String operation = null;
        if (annotation!=null){
            operation = annotation.value();
        }
        Object principal = SecurityUtils.getSubject().getPrincipal();
        String userName;
        if (principal!=null){
            userName=principal.toString();
        }else {
            userName = "系统";
        }
        Object[] args = joinPoint.getArgs();
        Object[] arguments  = new Object[args.length];
        for (int i = 0; i < args.length; i++) {
            if (args[i] instanceof ServletRequest || args[i] instanceof ServletResponse || args[i] instanceof MultipartFile) {
                //ServletRequest不能序列化，从入参里排除，否则报异常：java.lang.IllegalStateException: It is illegal to call this method if the current request is not in asynchronous mode (i.e. isAsyncStarted() returns false)
                //ServletResponse不能序列化 从入参里排除，否则报异常：java.lang.IllegalStateException: getOutputStream() has already been called for this response
                continue;
            }
            arguments[i] = args[i];
        }
        String paramter = "";
        if (arguments != null) {
            try {
                paramter = JSONObject.toJSONString(arguments);
            } catch (Exception e) {
                paramter = arguments.toString();
            }
        }
        logger.info(new Date()+"---"+userName+"---"+operation+"---"+paramter);

    }
    @Pointcut("execution(* com.blog.ourblog.controller.*.*(..))")
    public void myErrorPointcut(){

    }
    @AfterThrowing(pointcut ="myErrorPointcut()",throwing = "ex" )
    public void myErrorRet(JoinPoint joinPoint,Exception ex){
        String methodName = joinPoint.getSignature().getName();
        List<Object> ags = Arrays.asList(joinPoint.getArgs());
        logger.error("方法名:" + methodName + "参数为: " +ags+ " 异常为: " + ex);

    }
}
