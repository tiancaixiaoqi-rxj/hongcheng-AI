package org.example.hongchengai.pojo.dto;


/**
 * 用于接收前段传来的用户数据
 */
public class ReceiveMessageDto {
    private String message;
    private String file;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return "ReceiveMessageDto{" +
                "message='" + message + '\'' +
                ", file='" + file + '\'' +
                '}';
    }
}
