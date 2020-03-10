package com.example.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class ScheduledTasks {
    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss VV");

    @Value("${app.file.path}")
    private String fileName;

    @Scheduled(fixedRate = 60000)
    public void write() {
        log.info("Task started - {}", fileName);
        writeToFile();
        log.info("Task completed");
    }

    private void writeToFile() {
        try (FileWriter fileWriter = new FileWriter(fileName, true);
             BufferedWriter writer = new BufferedWriter(fileWriter)) {
            writer.write("Triggered at " + FORMATTER.format(ZonedDateTime.now()));
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
