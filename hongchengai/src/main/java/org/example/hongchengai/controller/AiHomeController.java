package org.example.hongchengai.controller;


import org.example.hongchengai.pojo.dto.MessageDto;
import org.example.hongchengai.service.AiService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.example.hongchengai.service.IAiService;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AiHomeController {
    IAiService ai = new AiService();
    /**
     *  用户提出的问
     * @return  AI的回答
     */

    @PostMapping("/home")
    public MessageDto homePost(@RequestBody MessageDto messageDto){
        System.out.println(messageDto);
        String aiResponse = ai.ask(messageDto) + "成功处理";
        MessageDto response = new MessageDto();
        response.setText(aiResponse);
        return response;
        //System.out.println(formData);
        //return formData + "解决";
    }
//    @PostMapping("/")
//    public String sendData(@RequestBody MyData data){
//        System.out.println(data);
//        return "success";
//    }
}
