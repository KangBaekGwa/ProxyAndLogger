package baekgwa.proxypattern.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class JustReflectionTest {

    @Test
    void 문제코드() {
        Printer printer = new Printer();

        log.info("시작");
        printer.printA();
        log.info("끝");

        log.info("시작");
        printer.printB();
        log.info("끝");
    }

    @Test
    void 공통_메서드로_처리()
            throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Printer printer = new Printer();
        Class printerClass = Class.forName(
                "baekgwa.proxypattern.reflection.JustReflectionTest$Printer");

        dynamicCall(printerClass.getMethod("printA"), printer);
        dynamicCall(printerClass.getMethod("printB"), printer);
    }

    private void dynamicCall(Method method, Object obj)
            throws InvocationTargetException, IllegalAccessException {
        log.info("시작");
        method.invoke(new Object());
        log.info("끝");
    }

    @Slf4j
    static class Printer {
        public void printA(){
            log.info("A");
        }

        public void printB(){
            log.info("B");
        }
    }
}
