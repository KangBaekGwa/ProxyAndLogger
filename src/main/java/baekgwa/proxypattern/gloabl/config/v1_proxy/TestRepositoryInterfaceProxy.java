package baekgwa.proxypattern.gloabl.config.v1_proxy;

import baekgwa.proxypattern.gloabl.logger.LogInfo;
import baekgwa.proxypattern.gloabl.logger.Logger;
import baekgwa.proxypattern.web.app.TestRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
public class TestRepositoryInterfaceProxy implements TestRepository {

    private final TestRepository testRepository;
    private final Logger logger;

    @Override
    public void save(String name) {
        log.info("Repository 프록시 실행");
        LogInfo logInfo = logger.start("TestRepository.save()");
        testRepository.save(name); //실제 로직 호출
        logger.end(logInfo);
    }
}
