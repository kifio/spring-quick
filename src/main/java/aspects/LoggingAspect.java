package aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.logging.Level;
import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {

    private final Logger logger = Logger.getLogger(
            LoggingAspect.class.getName()
    );


//    @Around("execution(* services.*.*(..))")
    @Around("@annotation(services.ToLog)")
    public Object log(ProceedingJoinPoint joinPoint) {
        logger.info("Method will execute");
        try {
            Object o = joinPoint.proceed();
            logger.info("Method executed");
            return o;
        } catch (Throwable throwable) {
            logger.log(Level.WARNING, throwable.toString());
            return Boolean.FALSE;
        }
    }
}
