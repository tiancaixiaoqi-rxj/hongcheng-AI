package org.example.hongchengai.pojo.dto;

public class UploadedFileDto {
    private String fileName;
    private String fileContent;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileContent() {
        return fileContent;
    }

    public void setFileContent(String fileContent) {
        this.fileContent = fileContent;
    }

    @Override
    public String toString() {
        return "UploadedFileDto{" +
                "fileName='" + fileName + '\'' +
                ", fileContent='" + fileContent + '\'' +
                '}';
    }
}
