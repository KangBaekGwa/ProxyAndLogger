package baekgwa.proxypattern;

import baekgwa.proxypattern.gloabl.config.ApplicationConfig;
import baekgwa.proxypattern.gloabl.config.v1_proxy.InterfaceProxyConfig;
import baekgwa.proxypattern.gloabl.config.v2_proxyfactory.ProxyFactoryConfig;
import baekgwa.proxypattern.gloabl.logger.Logger;
import baekgwa.proxypattern.gloabl.logger.LoggerImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@SpringBootApplication(scanBasePackages = "baekgwa.proxypattern.web")
//@Import(ApplicationConfig.class)
//@Import(InterfaceProxyConfig.class)
@Import(ProxyFactoryConfig.class)
public class ProxyPatternApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProxyPatternApplication.class, args);

    }

    @Bean
    public Logger logger(){
        return new LoggerImpl();
    }

}
