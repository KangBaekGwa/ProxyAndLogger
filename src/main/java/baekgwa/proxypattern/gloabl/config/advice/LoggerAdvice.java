package baekgwa.proxypattern.gloabl.config.advice;

import baekgwa.proxypattern.gloabl.logger.LogInfo;
import baekgwa.proxypattern.gloabl.logger.Logger;
import lombok.RequiredArgsConstructor;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

@RequiredArgsConstructor
public class LoggerAdvice implements MethodInterceptor {

    private final Logger logger;

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {

        Class<?> targetClass = invocation.getThis().getClass();
        String message = targetClass.getSimpleName() + "." + invocation.getMethod().getName() + "()";
        LogInfo logInfo = logger.start(message);

        Object result = invocation.proceed();

        logger.end(logInfo);

        return result;
    }
}
