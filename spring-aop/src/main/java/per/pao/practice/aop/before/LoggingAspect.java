package per.pao.practice.aop.before;

import lombok.extern.slf4j.Slf4j;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Component
@Aspect
public class LoggingAspect {

    @Pointcut(value = "execution(* per.pao.practice.service.Math.add(..))")
    public void log() {
        // do nothing
    }

    //    @Before("execution(* per.pao.practice.service.Math.add(..))")
    @Before("log()")
    public void executeLog(JoinPoint jp) {
        String name = jp.getSignature().getName();
        log.info("before method {}", name);
    }

    @After("execution(* per.pao.practice.service.Math.subtract(..))")
    public void executeLogAfter(JoinPoint jp) {
        Arrays.stream(jp.getArgs())
                .forEach(arg -> log.info("after method {} arg:{}", jp.getSignature().getName(), arg));
    }

    @Around(value = "execution(* per.pao.practice.service.Math.multiply(..))")
    public Object executeLogAround(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        Object value = pjp.proceed();
        long end = System.currentTimeMillis();
        log.info("return value: {}", value);
        log.info("execute method: {} took {} ms", pjp.getSignature().getName(), (end - start));
        return value;
    }

}
