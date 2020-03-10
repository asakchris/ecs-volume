package com.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

@RestController
@RequestMapping(value = "log")
public class ReadController {
    private static Logger log = LoggerFactory.getLogger(ReadController.class);

    @Value("${app.file.path}")
    private String fileName;

    @GetMapping
    public ResponseEntity<String> getLog() {
        String message = readLog();
        log.info("message: {}", message);
        return ResponseEntity.ok(message);
    }

    private String readLog() {
        StringBuilder contentBuilder = new StringBuilder();
        log.info("fileName: {}", fileName);
        try (Stream<String> stream = Files.lines(Paths.get(fileName), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contentBuilder.toString();
    }
}
