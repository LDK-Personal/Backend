package com.ldkspringbase.ai;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.PumpStreamHandler;

import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;

@Service
public class Emotion {

    public MultipartFile executeEmotions(MultipartFile multipartFile) {
        System.out.println("tracking");
        String root = "src/main/java/com/ldkspringbase/ai";

        String[] command = new String[2];
        command[0] = "python3";
        command[1] = root + "motions.py";

        CommandLine commandLine = CommandLine.parse(command[0]);
        for (int i = 1, n = command.length; i < n; i++) {
            commandLine.addArgument(command[i]);
        }

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PumpStreamHandler pumpStreamHandler = new PumpStreamHandler(outputStream);
        DefaultExecutor executor = new DefaultExecutor();
        executor.setStreamHandler(pumpStreamHandler);
        System.out.println(commandLine);

        try {
            int result = executor.execute(commandLine);
            System.out.println("result: " + result);
            /* System.out.println("output: " + outputStream); */

            String[] word = new String(outputStream.toByteArray(), StandardCharsets.UTF_8).split("\n");
            if (word[2].equals("MJ\r")) {
                int styleNum = (int) (Math.random() * 21 + 1);
                System.out.println("---SUCCESS--- Detectived HandTracking");

            }
        } catch (Exception e) {
            // 실패 시 예외 처리
            throw new RuntimeException("보드 생성에 실패하였습니다.", e);
        }
        return null;
    }
}
