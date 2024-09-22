package org.example.hongchengai.service;

import org.example.hongchengai.pojo.dto.ReceiveMessageDto;
import org.example.hongchengai.pojo.dto.ReturnMessageDto;



public interface IReturnService {
    public ReturnMessageDto returnResult(ReceiveMessageDto receiveMessageDto,int answerTimes) throws Exception;
}
