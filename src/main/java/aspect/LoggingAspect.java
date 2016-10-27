package aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;

@Aspect
@Order(0)
public class LoggingAspect {
    
    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);    
    /**
     * 记录方法的开始与结束 及执行时间
     * 
     * @param joinPoint
     * @throws Throwable 
     */
    @Around("execution(* service..*.*(..))")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result = null;
        String className = getClassName( joinPoint.getThis().toString());
        String methodName = joinPoint.getSignature().getName(); // 获得方法名
        logger.info("{}.{} begin ",className,methodName);
        long begin = System.currentTimeMillis();

        result = joinPoint.proceed(); //continue on the intercepted method
     
        
        logger.info("{}.{} end {executed in {} msec}",className,methodName,System.currentTimeMillis()-begin);
        return result;
    }
    
    /**
     * 获取类名
     * 
     * @param className
     * @return
     */
    private static String getClassName(String className) {
        if (className.indexOf('@') > 0) {
            className = className.substring(0, className.lastIndexOf('@'));
        }
        if (className.indexOf('.') > 0) {
            className = className.substring(className.lastIndexOf('.') + 1, className.length());
        }
        return className;
    }
    @After("execution(* java.sql.Connection+.*(..))")
    public void afterCommit(){
        logger.info("===========================");
        
    }

}