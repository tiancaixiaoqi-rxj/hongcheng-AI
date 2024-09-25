package org.example.hongchengai.controller;

import org.example.hongchengai.pojo.dto.ReceiveMessageDto;
import org.example.hongchengai.pojo.dto.ReturnMessageDto;
import org.example.hongchengai.service.IReturnService;
import org.example.hongchengai.service.ReturnService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;


@RestController
@RequestMapping("/api")
public class AskAndAnswerController {
    int answerTimes = 0;
    IReturnService returnService = new ReturnService();

    @PostMapping(value = "/upload", consumes = "multipart/form-data")
    public ReturnMessageDto handleFileUpload(
            @RequestParam(value = "files", required = false) MultipartFile file, // 设置为可选
            @RequestParam("message") String message // 始终接收
    ) throws IOException {
        // 检查文件是否存在
        ReceiveMessageDto receiveMessageDto = new ReceiveMessageDto();
        receiveMessageDto.setMessage(message);


        if (file != null && !file.isEmpty()) {
            receiveMessageDto.setFiles(file);

            String infoPath = "F:\\AI\\files\\info.txt";
            Path filePath = Paths.get(infoPath);
            Path directoryPath = filePath.getParent();
            if (!Files.exists(directoryPath)) {
                Files.createDirectories(directoryPath);
            }
            if (!Files.exists(filePath)) {
                Files.createFile(filePath);
            }

            BufferedWriter writer = Files.newBufferedWriter(Paths.get(infoPath));
            String infos = "Received file: " + file.getOriginalFilename() + "\nFile type: "+ file.getContentType();
            writer.write(infos);
            writer.close();
            System.out.println("Received file: " + file.getOriginalFilename());
            System.out.println("File type: " + file.getContentType());
        } else {
            System.out.println("No file received.");
        }

        System.out.println("Received message: " + message);

        // 处理文件（如果有）
        if (file != null && !file.isEmpty()) {
            String originalFilename = file.getOriginalFilename();
            String filePath = "F:\\AI\\files\\";
            Files.createDirectories(Paths.get(filePath));
            File destFile = new File(filePath + originalFilename);
            file.transferTo(destFile);
            // 进行文件处理
            // file.getBytes() 或 file.transferTo() 等
        }

        answerTimes++;
        System.out.println(receiveMessageDto);
        try {
            return returnService.returnResult(receiveMessageDto, answerTimes);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}