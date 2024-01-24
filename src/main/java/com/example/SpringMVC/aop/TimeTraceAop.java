package com.example.SpringMVC.aop;

import java.util.Objects;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component

public class TimeTraceAop {
    @Around("execution(* com.example.SpringMVC..*(..))")
    //위의 execution을 통해서 어떤 패키지에 AOP를 적용할건지 판단할 수 있다.
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("start = " + joinPoint.toString());
        try{
            return joinPoint.proceed();
            //프록시가 실제 AOP적용 대상이되는 메서드가 호출되는 부분
        }finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("END : "+joinPoint.toString()+" "+timeMs+"ms");
        }
    }
}
