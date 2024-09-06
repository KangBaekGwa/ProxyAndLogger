package baekgwa.proxypattern.gloabl.config;

import baekgwa.proxypattern.web.app.TestRepository;
import baekgwa.proxypattern.web.app.TestRepositoryImpl;
import baekgwa.proxypattern.web.app.TestService;
import baekgwa.proxypattern.web.app.TestServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public TestService testService(){
        return new TestServiceImpl(testRepository());
    }

    @Bean
    public TestRepository testRepository(){
        return new TestRepositoryImpl();
    }
}
