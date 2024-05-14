# Chat360_Assignment
The Assignment given by Chat360 Company for the job role of SDE as a intern
This project implements a log control system with a log ingestor and a query interface. The log ingestor generates log files with random log entries, and the query interface provides functionality to search through these logs based on various criteria.

## How to Run
# commands to run the files 
run the below command on CMD
1) javac LogEntry.java LogIngestor.java LogQueryInterface.java LogEntryParser.java
2) java LogIngestor
3) java LogQueryInterface

# System Design:
The system consists of classes for logging (LogIngestor), querying (QueryInterface), and a main class to run the program (LogQueryInterface).
Logs are stored in separate log files based on their source.
The QueryInterface class loads logs from all log files and provides methods to search logs based on various criteria.

# Features Implemented:
Log ingestion with support for multiple log files.
Querying logs based on level, log string, timestamp, and source.

#Identified Issues:
No real-time log ingestion.
Error handling is minimal.
No support for advanced features like search within specific date ranges or combining multiple filters.
