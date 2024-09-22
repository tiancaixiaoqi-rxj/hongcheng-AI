package org.example.hongchengai.controller;


import org.example.hongchengai.pojo.dto.ReceiveMessageDto;
import org.example.hongchengai.pojo.dto.ReturnMessageDto;


import org.example.hongchengai.service.IReturnService;
import org.example.hongchengai.service.ReturnService;

import org.springframework.web.bind.annotation.*;


@RestController
public class AiHomeController {
    int answerTimes = 0;

    IReturnService returnService = new ReturnService();
    /**
     *  用户提出的问
     * @return  AI的回答
     */

//    @PostMapping("/home")
//    public ReturnMessageDto homePost(@RequestBody ReceiveMessageDto receiveMessageDto){
//        System.out.println(receiveMessageDto);
//        String aiResponse = "成功处理";
//        ReturnMessageDto returnMessageDto = new ReturnMessageDto();
//        returnMessageDto.setText(aiResponse);
//        return returnMessageDto;
//
//    }
    @PostMapping("/send")
    public ReturnMessageDto homePost(@ModelAttribute ReceiveMessageDto receiveMessageDto){
        answerTimes++;
        try {
            return returnService.returnResult(receiveMessageDto, answerTimes);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

}
