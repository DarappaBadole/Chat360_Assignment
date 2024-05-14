import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class LogQueryInterface {

    public List<LogEntry> searchLogs(String level, String logString, LocalDateTime startTime, LocalDateTime endTime, String source) {
        List<LogEntry> results = new ArrayList<>();
        try {
            for (int i = 1; i <= 9; i++) {
                BufferedReader reader = new BufferedReader(new FileReader("log" + i + ".log"));
                String line;
                while ((line = reader.readLine()) != null) {
                    LogEntry entry = LogEntryParser.parseLogEntry(line);
                    if ((level == null || entry.getLevel().equals(level)) &&
                        (logString == null || entry.getLogString().contains(logString)) &&
                        (startTime == null || entry.getTimestamp().isAfter(startTime)) &&
                        (endTime == null || entry.getTimestamp().isBefore(endTime)) &&
                        (source == null || entry.getSource().equals(source))) {
                        results.add(entry);
                    }
                }
                reader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return results;
    }

    public static void main(String[] args) {
        LogQueryInterface queryInterface = new LogQueryInterface();
        List<LogEntry> results = queryInterface.searchLogs("error", "Inside the Search API", null, null, "log1.log");
        for (LogEntry result : results) {
            System.out.println(result);
        }
    }
}
