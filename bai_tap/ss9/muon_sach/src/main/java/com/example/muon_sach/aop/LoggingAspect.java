package com.example.muon_sach.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    @Pointcut("execution(* com.example.muon_sach.controller.BookController.borrow(..))")
    public void loggingPerformBorrowPointCut(){}
    @Pointcut("execution(* com.example.muon_sach.controller.BookController.returnBook(..))")
    public void loggingPerformGiveBackPointCut() {}
    @Pointcut("execution(* com.example.muon_sach.controller.BookController.showList(..))")
    public void loggingShowAllList () {}

    @AfterReturning(pointcut = "loggingPerformBorrowPointCut()")
    public void handleAfterReturningPerformBorrow(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getName());
    }
}
