package com.ldkspringbase.ai;

import java.io.ByteArrayOutputStream;
import java.io.File;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.PumpStreamHandler;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ldkspringbase.entity.PredictionDTO;

@Service
public class PredictionFace {
    final String HOME_PATH = "/home/ubuntu/ty";
    final String PYTHON_PATH = HOME_PATH + "/python";
    final String IMG_FOLDER_PATH = HOME_PATH + "/imgs";
    final String RESULT_FOLDER_PATH = HOME_PATH + "/result";
    final String JPG = ".jpg";
    final String TEXT = ".txt";

    int INDEX = 1;

    public PredictionDTO executeEmotions(MultipartFile multipartFile) {
        String originalFilename = getOriginalFilename(multipartFile);

        saveFile(multipartFile, IMG_FOLDER_PATH, originalFilename + JPG);

        CommandLine commandLine = getCommandLine(originalFilename + JPG);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PumpStreamHandler pumpStreamHandler = new PumpStreamHandler(outputStream);
        DefaultExecutor executor = new DefaultExecutor();
        executor.setStreamHandler(pumpStreamHandler);
        try {
            executor.execute(commandLine);
        } catch (Exception e) {
            throw new RuntimeException("Failed Face Prediction", e);
        }

        PredictionDTO predictionDTO = getJsonToDTO(originalFilename + TEXT);
        System.out.println(predictionDTO);
        return predictionDTO;
    }

    private String getOriginalFilename(MultipartFile multipartFile) {
        String originalFilename = multipartFile.getOriginalFilename();
        if (originalFilename.contains("."))
            originalFilename = originalFilename.substring(0, originalFilename.lastIndexOf(".")) + "_" + INDEX++;
        return "/" + originalFilename;
    }

    private void saveFile(MultipartFile multipartFile, String folderPath, String fileName) {
        try {
            File directory = new File(folderPath);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            File uploadFile = new File(folderPath + fileName);
            multipartFile.transferTo(uploadFile);
        } catch (Exception e) {
            throw new RuntimeException("Failed Save", e);
        }
    }

    private CommandLine getCommandLine(String originalFilename) {
        String[] command = new String[3];
        command[0] = "python3";
        command[1] = PYTHON_PATH + "/prediction_face.py";
        command[2] = IMG_FOLDER_PATH + originalFilename;

        CommandLine commandLine = CommandLine.parse(command[0]);
        for (int i = 1, n = command.length; i < n; i++) {
            commandLine.addArgument(command[i]);
        }

        for (String s : command) {
            System.out.println(s);
        }

        return commandLine;
    }

    private PredictionDTO getJsonToDTO(String originalFilename) {
        try {
            File file = new File(RESULT_FOLDER_PATH + originalFilename);
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(file, PredictionDTO.class);
        } catch (Exception e) {
            throw new RuntimeException("Failed to map JSON to PredictionDTO", e);
        }
    }
}
