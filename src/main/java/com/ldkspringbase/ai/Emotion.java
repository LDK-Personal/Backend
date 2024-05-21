package com.ldkspringbase.ai;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.PumpStreamHandler;

import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;

//@Service
public class Emotion {
    public static void main(String[] args) {
        executeEmotions(null);
    }

    public static MultipartFile executeEmotions(MultipartFile multipartFile) {
        System.out.println("face predict");
        String root = "C:/Users/Osstem/Desktop/LDK-SpringBase-C-R-U-D/src/main/java/com/ldkspringbase/ai/python/";

        String[] command = new String[7];
        command[0] = "conda";
        command[1] = "activate";
        command[2] = "myenv";
        command[3] = "&&";
        command[4] = "python";
        command[5] = root + "prediction_face.py";
        command[6] = root + "dog.jpg";

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

            /*String[] word = new String(outputStream.toByteArray(), StandardCharsets.UTF_8).split("\n");
            if (word[2].equals("MJ\r")) {
                int styleNum = (int) (Math.random() * 21 + 1);
                System.out.println("---SUCCESS--- Detectived HandTracking");

            }*/
        } catch (Exception e) {
            throw new RuntimeException("Failed Face Prediction", e);
        }
        return null;
    }
}
