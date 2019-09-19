package by.protasovitski.util;




import org.slf4j.Logger;

import javax.inject.Inject;
import javax.interceptor.AroundConstruct;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
@Loggable
public class LoggingInterceptor {

   /* @Inject
    private Logger logger;*/



    @AroundConstruct
    private void init(InvocationContext ic) throws Exception {
//        logger.info("Entering constructor");
        try {
            ic.proceed();
        } finally {
//            logger.info("Exiting constructor");
        }
    }

    @AroundInvoke
    public Object logMethod(InvocationContext ic) throws Exception {
//        logger.info(ic.getTarget().toString(), ic.getMethod().getName());
        try {
            return ic.proceed();
        } finally {
//            logger.info(ic.getTarget().toString(), ic.getMethod().getName());
        }
    }
}
