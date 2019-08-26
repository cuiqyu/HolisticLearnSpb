package com.limpid.holisticlearnspb.aspect;

import com.limpid.holisticlearnspb.annotation.Log;
import com.limpid.holisticlearnspb.dao.SysLogMapper;
import com.limpid.holisticlearnspb.entity.SysLogEntity;
import com.limpid.holisticlearnspb.util.HttpContextUtils;
import com.limpid.holisticlearnspb.util.IPUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @ClassName LogAspect
 * @Description 日志切面
 * @Author cuiqiongyu
 * @Date 2019-08-11 11:57
 */
@Aspect
@Component
public class LogAspect {

    @Autowired
    private SysLogMapper sysLogMapper;

    /**
     * @return void
     * @Author cuiqiongyu
     * @Description 标注切入点为自定义的注解
     * @Date 12:01 2019-08-11
     * @Param []
     **/
    @Pointcut("@annotation(com.limpid.holisticlearnspb.annotation.Log)")
    public void pointcut() {

    }

    /**
     * @return java.lang.Object
     * @Author cuiqiongyu
     * @Description 建立环绕通知
     * @Date 12:02 2019-08-11
     * @Param [point]
     **/
    @Around("pointcut()")
    public Object around(ProceedingJoinPoint point) {
        Object result = null;
        long beginTime = System.currentTimeMillis();
        try {
            result = point.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        // 执行时长
        long time = System.currentTimeMillis() - beginTime;
        // 保存日志
        saveLog(point, time);
        return result;
    }

    /**
     * @return void
     * @Author cuiqiongyu
     * @Description 保存日志
     * @Date 12:06 2019-08-11
     * @Param [joinPoint, time]
     **/
    private void saveLog(ProceedingJoinPoint joinPoint, long time) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        SysLogEntity sysLog = new SysLogEntity();
        Log logAnnotation = method.getAnnotation(Log.class);
        if (logAnnotation != null) {
            // 注解上的描述
            sysLog.setOperation(logAnnotation.value());
        }
        // 请求的方法名
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = signature.getName();
        sysLog.setMethod(className + "." + methodName + "()");
        // 请求的方法参数值
        Object[] args = joinPoint.getArgs();
        // 请求的方法参数名称
        LocalVariableTableParameterNameDiscoverer u = new LocalVariableTableParameterNameDiscoverer();
        String[] paramNames = u.getParameterNames(method);
        if (args != null && paramNames != null) {
            String params = "";
            for (int i = 0; i < args.length; i++) {
                params += "  " + paramNames[i] + ": " + args[i];
            }
            sysLog.setParms(params);
        }
        // 获取request
        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
        // 设置IP地址
        sysLog.setIp(IPUtils.getIpAddr(request));
        // 模拟一个用户名
        sysLog.setUser_name("mrbird");
        sysLog.setTimestamp((int) time);
        sysLog.setCreateTime(new Date());
        // 保存系统日志
        sysLogMapper.insert(sysLog);
    }

}
