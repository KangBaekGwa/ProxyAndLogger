package baekgwa.proxypattern.gloabl.config.v1_proxy;

import baekgwa.proxypattern.gloabl.logger.LogInfo;
import baekgwa.proxypattern.gloabl.logger.Logger;
import baekgwa.proxypattern.web.app.TestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;

@RequiredArgsConstructor
@Slf4j
public class TestServiceInterfaceProxy implements TestService {

    private final TestService testService;
    private final Logger logger;

    @Override
    public void saveName(String name) {
        log.info("Service 프록시 실행");
        LogInfo logInfo = logger.start("TestController.saveName()");
        testService.saveName(name);
        logger.end(logInfo);
    }
}
