package org.example.hongchengai.pojo.dto;


import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;

/**
 * 用于接收前段传来的用户数据
 */
public class ReceiveMessageDto {
    private String message;
    private MultipartFile files;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public MultipartFile getFiles() {
        return files;
    }

    public void setFiles(MultipartFile files) {
        this.files = files;
    }

    @Override
    public String toString() {
        return "ReceiveMessageDto{" +
                "message='" + message + '\'' +
                ", files=" + files +
                '}';
    }
}
