package baekgwa.proxypattern.gloabl.logger;

import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class LoggerImpl implements Logger {

    private ThreadLocal<String> threadId = new ThreadLocal<>();

    @Override
    public LogInfo start(String message) {
        //Thread Id가 비어있으면 (스레드의 첫번째) 새로운 uuid 생성 후 저장.
        if(threadId.get() == null){
            threadId.set(UUID.randomUUID().toString().substring(0, 8));
        }
        String threadUuid = threadId.get();
        Long startTime = System.currentTimeMillis();

        log.info("[START][{}] {}", threadUuid, message);
        return new LogInfo(startTime, message);
    }

    @Override
    public void end(LogInfo logInfo) {
        Long endTime = System.currentTimeMillis();
        Long runningTime = endTime - logInfo.getStartTime();

        log.info("[E N D][{}] {}", threadId.get(), logInfo.getMessage());
    }
}
