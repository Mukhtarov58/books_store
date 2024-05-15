package com.example.books_store.aspect;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import com.example.books_store.TrackUserAction;
import java.util.Arrays;

@Aspect
@Component
public class UserActionAspect {
    @Before("@annotation(com.example.books_store.TrackUserAction)")
    public void beforeMethodExecution(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();

        System.out.println("Method " + methodName + " called with args: " + Arrays.toString(args));
    }

    @AfterReturning(pointcut = "@annotation(com.example.books_store.TrackUserAction)", returning = "result")
    public void afterMethodExecution(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();

        System.out.println("Method " + methodName + " executed successfully with result: " + result);
    }
}