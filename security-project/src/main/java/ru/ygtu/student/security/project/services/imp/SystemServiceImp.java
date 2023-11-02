package ru.ygtu.student.security.project.services.imp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.ygtu.student.security.project.services.SystemService;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

@Service
@Slf4j
public class SystemServiceImp implements SystemService {
    @Value("${pathScript}")
    private String pathScript;
    @Value("${pathDump}")
    private String pathDump;
    @Value("${commandScript}")
    private List<String> commandScript;


    @Override
    public void rebootBd() {
        try {

            ProcessBuilder processBuilder;
            if (!pathScript.isBlank()) {
                processBuilder = new ProcessBuilder(pathScript);
                processBuilder.directory(new File(pathDump));
            }
            else {
                processBuilder = new ProcessBuilder(commandScript);
            }
            processBuilder.redirectErrorStream(true);
            processBuilder.redirectOutput(ProcessBuilder.Redirect.PIPE);
            Process process = processBuilder.start();

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    log.info(line);
                }
            }
        } catch (IOException e) {
            log.error("Exception in rebootBd: " + e.getMessage());
        }
    }
}
