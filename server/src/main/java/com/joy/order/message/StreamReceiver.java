package com.joy.order.message;

import com.joy.order.dto.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.ast.Or;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 * Created by Ai Lun on 2019-08-02.
 */
@Component
@EnableBinding(StreamClient.class)
@Slf4j
public class StreamReceiver {

    //@StreamListener(value = StreamClient.INPUT)
    //public void process(Object message) {
    //    log.info("StreamReceiver: {}", message);
    //}

    //@StreamListener(value = StreamClient.INPUT)
    //public void process(OrderDTO message) {
    //    log.info("StreamReceiver: {}", message);
    //}

    @StreamListener(value = StreamClient.INPUT)
    @SendTo(StreamClient.INPUT2)
    public String process(OrderDTO orderDTO) {
        log.info("StreamReceive: {}", orderDTO);
        // 发送 mq 消息
        return "received.";
    }

    @StreamListener(value = StreamClient.INPUT2)
    public void process2(String message) {
        log.info("StreamReceiver2: {}", message);
        // 发送 mq 消息
    }


}
