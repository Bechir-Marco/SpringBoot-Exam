package com.example.coursclassroomexam.Aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class Logging {

//    public class PerformanceAspect {
//
//        @Around("execution(* tn.esprit.spring.services.*.*(..))")
//        public void profile(ProceedingJoinPoint pjp) throws Throwable {
//            long start = System.currentTimeMillis();
//            pjp.proceed();
//            long elapsedTime = System.currentTimeMillis() - start;
//            log.info("Method execution time: " + elapsedTime + " milliseconds.");
//        }
//    }

    public class afficheMessage {

        @Before("execution(* com.example.coursclassroomexam.Serv.*.ajouter*(..))")
        public void logMethodEntry(JoinPoint joinPoint) {
            String name = joinPoint.getSignature().getName();
            log.info("Début Execution : " + name + " : ");
        }
    }
}