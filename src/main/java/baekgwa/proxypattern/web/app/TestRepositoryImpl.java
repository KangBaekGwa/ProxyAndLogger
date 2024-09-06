package baekgwa.proxypattern.web.app;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TestRepositoryImpl implements TestRepository {

    @Override
    public void save(String name){

        //저장 로직 구현 필요
        sleep(1000); //현재 저장하는데 1초가 실행된다고 가정.

    }

    private void sleep(long ms){
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
