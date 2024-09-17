package org.example.hongchengai.pojo.dto;

/**
 * 该类用于返回ai的回答给前段
 */
public class MessageDto {
    private int id;
    private String sender;
    private String text;
    private boolean hasText;
    private boolean hasChart;
    private boolean hasImage;

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
