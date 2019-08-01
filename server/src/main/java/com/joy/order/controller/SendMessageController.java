package com.joy.order.controller;

import com.joy.order.dto.OrderDTO;
import com.joy.order.message.StreamClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by Ai Lun on 2019-08-02.
 */
@RestController
public class SendMessageController {

    @Autowired
    private StreamClient streamClient;

    //@GetMapping("/sendMessage")
    //public void process() {
    //    String message = "stream now " + new Date();
    //    streamClient.output().send(MessageBuilder.withPayload(message).build());
    //}

    /**
     * 发送 OrderDTO 对象
     */
    @GetMapping("/sendMessage")
    public void process() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderId("123456");
        streamClient.output().send(MessageBuilder.withPayload(orderDTO).build());
    }
}
