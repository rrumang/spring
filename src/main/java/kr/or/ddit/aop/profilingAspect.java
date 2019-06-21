package kr.or.ddit.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class profilingAspect {
	private static final Logger logger = LoggerFactory.getLogger(profilingAspect.class);
	
	@Pointcut("execution(* kr.or.ddit..service.*.*(..))")
	public void dummy() {}
	
	@Around("dummy()")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		long time = System.currentTimeMillis();
		logger.debug("profiling Aspect around method before :{}", time);
		
		Object[] methodArgs = joinPoint.getArgs();
		Object retval = joinPoint.proceed(methodArgs);
		
		long time2 = System.currentTimeMillis();
		logger.debug("profiling Aspect around method after : {}", time2);
		
		logger.debug("time : {}", time2-time);
		
		return retval;
	}
}
