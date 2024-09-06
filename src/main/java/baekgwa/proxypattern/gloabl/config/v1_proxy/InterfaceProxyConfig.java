package baekgwa.proxypattern.gloabl.config.v1_proxy;

import baekgwa.proxypattern.gloabl.logger.Logger;
import baekgwa.proxypattern.web.app.TestController;
import baekgwa.proxypattern.web.app.TestRepository;
import baekgwa.proxypattern.web.app.TestRepositoryImpl;
import baekgwa.proxypattern.web.app.TestService;
import baekgwa.proxypattern.web.app.TestServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class InterfaceProxyConfig {

    private final Logger logger;

    @Bean
    public TestService testService() {
        return new TestServiceInterfaceProxy(
                new TestServiceImpl(testRepository()), logger);
    }

    @Bean
    public TestRepository testRepository() {
        return new TestRepositoryInterfaceProxy(
                new TestRepositoryImpl(), logger);
    }
}
