package baekgwa.proxypattern.gloabl.logger;

public interface Logger {

    LogInfo start(String message);

    void end(LogInfo logInfo);
}
