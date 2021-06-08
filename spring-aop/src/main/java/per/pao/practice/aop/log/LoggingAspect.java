package per.pao.practice.aop.log;

import lombok.extern.slf4j.Slf4j;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
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
    public void executeLogBefore(JoinPoint jp) {
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

    @Before(value = "execution(* per.pao.practice.service.Math.divide(int,int)) && args(i1,i2)", argNames = "jp,i1,i2")
    public void executeLogParameters(JoinPoint jp, int i1, int i2) {
        log.info("method: {}", jp.getSignature().getName());
        log.info("i1: {}", i1);
        log.info("i2: {}", i2);
    }

    @Target(value = {ElementType.METHOD})
    @Retention(value = RetentionPolicy.RUNTIME)
    public @interface Log {

    }

    @Around(value = "execution(public double per.pao.practice.service.Math.pow(..))")
    public Object executeLogAnnotation(ProceedingJoinPoint pjp) throws Throwable {
        log.info("start method: {}", pjp.getSignature().getName());
        Arrays.stream(pjp.getArgs()).forEach(arg -> log.info("arg: {}", arg));
        Object value = pjp.proceed();
        log.info("end method: {}", pjp.getSignature().getName());
        return value;
    }

}
