package baekgwa.proxypattern.gloabl.config.v2_proxyfactory;

import baekgwa.proxypattern.gloabl.config.advice.LoggerAdvice;
import baekgwa.proxypattern.gloabl.logger.Logger;
import baekgwa.proxypattern.web.app.TestRepository;
import baekgwa.proxypattern.web.app.TestRepositoryImpl;
import baekgwa.proxypattern.web.app.TestService;
import baekgwa.proxypattern.web.app.TestServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class ProxyFactoryConfig {

    private final Logger logger;

    @Bean
    public TestService testService(){
        TestServiceImpl testService = new TestServiceImpl(testRepository());
        ProxyFactory factory = new ProxyFactory(testService);
        factory.addAdvisor(getAdvisor());

        TestService proxy = (TestService) factory.getProxy();
        log.info("TestService 프록시 객체 생성 완료");
        return proxy;
    }

    @Bean
    public TestRepository testRepository() {
        TestRepositoryImpl testRepository = new TestRepositoryImpl(); //실제 동작할 구현체
        ProxyFactory factory = new ProxyFactory(testRepository);
        factory.addAdvisor(getAdvisor());

        TestRepository proxy = (TestRepository) factory.getProxy();
        log.info("TestRepository 프록시 객체 생성 완료");
        return proxy;
    }

    private Advisor getAdvisor(){

        //Pointcut 생성
        //포인트 컷은, 필터와 같은 역할을 한다.
        //다양한 포인트 컷이 있다,
        // NameMatchMethodPointcut 같은 경우, 메서드와 매칭된 이름을 기준으로 필터링 한다.
//        Pointcut pointcut = Pointcut.TRUE; //무조건 통과하는 Pointcut
        NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
        pointcut.setMappedNames("*Name");

        //Advice
        //필터링 되고 실제로 프록시 객체가 생성될 때 실행될 로직
        //MethodInterceptor 를 구현한 객체가 들어가면 된다.
        LoggerAdvice advice = new LoggerAdvice(logger);

        return new DefaultPointcutAdvisor(pointcut, advice);
    }
}
