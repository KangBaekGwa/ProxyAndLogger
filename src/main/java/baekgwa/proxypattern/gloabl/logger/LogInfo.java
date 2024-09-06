package baekgwa.proxypattern.gloabl.logger;

import lombok.Getter;

public class LogInfo {

    private Long startTime;
    private String message;

    public LogInfo(Long startTime, String message) {
        this.startTime = startTime;
        this.message = message;
    }

    public Long getStartTime() {
        return startTime;
    }

    public String getMessage() {
        return message;
    }
}
