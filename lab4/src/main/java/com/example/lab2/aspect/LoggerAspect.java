package com.example.lab2.aspect;
import com.example.lab2.domain.Logger;
import com.example.lab2.repo.LoggerRepo;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Aspect
@Component
public class LoggerAspect {



    Logger logger = new Logger();

    @Autowired
    LoggerRepo loggerRepo;

    @Pointcut("execution(* com.example.lab2.controller.UserController.*(..))")
    public void logMe() {

    }

    @Pointcut("@annotation(com.example.lab2.aspect.annotation.ExecutionTime)")
    public void annotationPointcut() {
    }

    @Around("annotationPointcut()")
    public void logExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable
    {

        long startTime = System.currentTimeMillis();
        proceedingJoinPoint.proceed();
        long endTime = System.currentTimeMillis();
         System.out.println(endTime-startTime);


        long id = logger.getId() + 1;
        logger.setId(id);
        logger.setDate(LocalDate.now());
        logger.setTime(endTime-startTime);
        logger.setOperation(proceedingJoinPoint.getSignature().getName());
        logger.setPrinciple("fake user");

        loggerRepo.save(logger);


    }

        @Before("logMe()")
        public void logBefore(JoinPoint joinPoint) {
            System.out.println("********Before*********" + joinPoint.getSignature().getName());
        }

        @After("logMe()")
        public void logAfter(JoinPoint joinPoint) {
            System.out.println("********After**********" + joinPoint.getSignature().getName());
        }



}
