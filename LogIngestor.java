import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogIngestor {

    public static void main(String[] args) {
        for (int i = 1; i <= 9; i++) {
            String fileName = "log" + i + ".log";
            writeLogsToFile(fileName);
        }
    }

    private static void writeLogsToFile(String fileName) {
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            for (int i = 1; i <= 10; i++) {
                String logEntry = generateLogEntry();
                fileWriter.write(logEntry + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String generateLogEntry() {
        String[] levels = {"info", "error", "success"};
        String[] logStrings = {"Inside the Search API", "Failed to connect", "Operation completed successfully"};
        String[] sources = {"log1.log", "log2.log", "log3.log"};

        String level = levels[(int) (Math.random() * levels.length)];
        String logString = logStrings[(int) (Math.random() * logStrings.length)];
        LocalDateTime timestamp = LocalDateTime.now().minusDays((int) (Math.random() * 10));
        String source = sources[(int) (Math.random() * sources.length)];

        return "{\"level\": \"" + level + "\", \"log_string\": \"" + logString + "\", \"timestamp\": \"" +
                timestamp.format(DateTimeFormatter.ISO_DATE_TIME) + "\", \"metadata\": {\"source\": \"" + source + "\"}}";
    }
}
