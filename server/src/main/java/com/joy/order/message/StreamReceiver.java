package com.joy.order.message;

import com.joy.order.dto.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
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

}
