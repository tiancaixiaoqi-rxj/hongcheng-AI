package org.example.hongchengai.pojo.dto;

/**
 * 将处理好的数据传回前段
 */
public class ReturnMessageDto {
    private int id;
    private String sender;
    private String text;
    private boolean hasText;
    private boolean hasChart;
    private boolean hasImage;

    public ReturnMessageDto(int id, String sender, String text, boolean hasText, boolean hasChart, boolean hasImage) {
        this.id = id;
        this.sender = sender;
        this.text = text;
        this.hasText = hasText;
        this.hasChart = hasChart;
        this.hasImage = hasImage;
    }

    public ReturnMessageDto() {
    }

    @Override
    public String toString() {
        return "MessageDto{" +
                "id=" + id +
                ", sender='" + sender + '\'' +
                ", text='" + text + '\'' +
                ", hasText=" + hasText +
                ", hasChart=" + hasChart +
                ", hasImage=" + hasImage +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isHasText() {
        return hasText;
    }

    public void setHasText(boolean hasText) {
        this.hasText = hasText;
    }

    public boolean isHasChart() {
        return hasChart;
    }

    public void setHasChart(boolean hasChart) {
        this.hasChart = hasChart;
    }

    public boolean isHasImage() {
        return hasImage;
    }

    public void setHasImage(boolean hasImage) {
        this.hasImage = hasImage;
    }
}
