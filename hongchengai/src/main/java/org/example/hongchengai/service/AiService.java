package org.example.hongchengai.service;

import org.example.hongchengai.pojo.dto.MessageDto;

public class AiService implements IAiService {

    /**
     *
     * @param message-用户的问题
     * @return  通过ai返回回答
     */
    @Override
    public String ask(MessageDto message) {
        return message.getText();
    }
}
