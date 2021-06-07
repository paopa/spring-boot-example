package per.pao.practice.aop.before;

import lombok.extern.slf4j.Slf4j;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

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

}
