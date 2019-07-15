package by.protasovitski.springfirst.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class TimeCheck {

    @Pointcut("@annotation(TimeAnn)")
    public void callAroundPersonController(){}

    @Around("callAroundPersonController()")
    public Object profile(ProceedingJoinPoint pjp) throws Throwable{

        long start = System.currentTimeMillis();
        System.out.println("Going to call the method.");
        Object output  = pjp.proceed();
        System.out.println("Method execution completed");
        long elapsedTime = System.currentTimeMillis()-start;
        System.out.println("Method execution time : " +elapsedTime + "milliseconds.");
        return output;
    }


}
