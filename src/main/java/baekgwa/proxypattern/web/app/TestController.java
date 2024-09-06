package baekgwa.proxypattern.web.app;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/v1")
@RestController
public class TestController {

    private final TestService testService;

    @GetMapping("/save")
    public String request(@RequestParam("name") String name){
        testService.saveName(name);
        return "ok";
    }

    @GetMapping("/health-check")
    public String healthCheck(){
        return "ok";
    }
}
