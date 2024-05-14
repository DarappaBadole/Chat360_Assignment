import java.time.LocalDateTime;

public class LogEntry {
    private String level;
    private String logString;
    private LocalDateTime timestamp;
    private String source;

    public LogEntry(String level, String logString, LocalDateTime timestamp, String source) {
        this.level = level;
        this.logString = logString;
        this.timestamp = timestamp;
        this.source = source;
    }

    public String getLevel() {
        return level;
    }

    public String getLogString() {
        return logString;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getSource() {
        return source;
    }

    @Override
    public String toString() {
        return "LogEntry{" +
                "level='" + level + '\'' +
                ", logString='" + logString + '\'' +
                ", timestamp=" + timestamp +
                ", source='" + source + '\'' +
                '}';
    }
}
