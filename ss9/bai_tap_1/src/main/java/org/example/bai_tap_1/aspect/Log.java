package org.example.bai_tap_1.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class Log {
    private int visitCount = 0;

    @After(value = "executeVisit()")
    public void afterVisit() {
        visitCount++;
        System.out.println("Số truy cập: " + visitCount);
    }

    @After(value = "executeLibraryCardService()")
    public void logAfterLibraryCardService(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        System.out.printf("Có thay đổi dữ liệu LibraryCard: %s.%s%s: %n", className, method, args);
    }

    @After(value = "executeBookService()")
    public void logAfterBookService(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        System.out.printf("Có thay đổi dữ liệu Book: %s.%s%s: %n", className, method, args);
    }

    @Pointcut(value = "within(org.example.bai_tap_1.service.BookServiceImpl) && " + "(execution(* reduceQuantity(..)) || execution(* increaseQuantity(..)))")
    public void executeBookService() {
    }

    @Pointcut(value = "within(org.example.bai_tap_1.service.LibraryCardServiceImpl) && " + "(execution(* saveLibraryCard(..)) || execution(* deleteLibraryCard(..)))")
    public void executeLibraryCardService() {
    }

    @Pointcut(value = "execution(* org.example.bai_tap_1.service.BookServiceImpl.getBooks(..))")
    public void executeVisit() {
    }
}
