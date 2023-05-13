package com.example.muon_sach.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Aspect
public class LoggingAspect {
    @Pointcut("execution(* com.example.muon_sach.controller" +
            ".BookController.borrowBook(..))||execution(* com.example" +
            ".muon_sach.controller.BookController.returnBook(..))")
    public void getMethodBookController() {
    }

    @After(value = "getMethodBookController()")
    public void printConsoleBook(JoinPoint joinPoint) {
        System.out.println("Bạn đã vào " + joinPoint
                .getSignature().getName() + " vào lúc : " + LocalDateTime.now());
    }

    @Pointcut("execution(* com.example.muon_sach.controller" +
            ".BookController.*(..))||execution(* com.example" +
            ".muon_sach.controller.BorrowerController.*(..))")
    public void getAllMethod() {
    }

    @Before(value = "getAllMethod()")
    public void printConsoleLibrary() {
        System.out.println("Bạn đã vào thư viện vào lúc : " + LocalDateTime.now());
    }
}
