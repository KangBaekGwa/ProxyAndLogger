package baekgwa.proxypattern.web.app;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TestServiceImpl implements TestService{

    private final TestRepository testRepository;

    @Override
    public void saveName(String name) {
        testRepository.save(name);
    }
}
