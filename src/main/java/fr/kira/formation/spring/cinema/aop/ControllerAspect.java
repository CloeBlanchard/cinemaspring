package fr.kira.formation.spring.cinema.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class ControllerAspect {

    private final Logger logger = LoggerFactory.getLogger(ControllerAspect.class);

    @AfterThrowing(pointcut = "execution(* fr.kira.formation.spring.cinema..*Controller.*(..))", throwing = "exception")
    public void logException(Exception exception) {
        logger.warn("Exception: " + exception.getMessage());
    }

    @Before("execution(* fr.kira.formation.spring.cinema..*Controller.find*(..))")
    public void logBefore(JoinPoint jp) {
        logger.error("Before "+jp.getSignature().getName());
    }
}
