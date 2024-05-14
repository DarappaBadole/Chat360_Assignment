import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogEntryParser {

    public static LogEntry parseLogEntry(String logString) {
        String[] parts = logString.split(",");
        String level = "";
        String logStringText = "";
        String timestampString = "";
        String source = "";
        for (String part : parts) {
            if (part.contains("level")) {
                level = part.split(":")[1].trim();
            } else if (part.contains("log_string")) {
                logStringText = part.split(":")[1].trim();
            } else if (part.contains("timestamp")) {
                timestampString = part.split(":")[1].trim();
            } else if (part.contains("source")) {
                source = part.split(":")[1].replaceAll("[\"}]","").trim();
            }
        }

        LocalDateTime timestamp;
        if (!timestampString.isEmpty()) {
            // Add seconds and milliseconds if missing from the timestamp string
            if (timestampString.length() < 19) {
                timestampString += ":00";
            }
            timestamp = LocalDateTime.parse(timestampString.replaceAll("[\"}]",""), DateTimeFormatter.ISO_DATE_TIME);
        } else {
            timestamp = LocalDateTime.now();
        }
        return new LogEntry(level, logStringText, timestamp, source);
    }
}
