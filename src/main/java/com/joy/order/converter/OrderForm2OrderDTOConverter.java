package com.joy.order.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.joy.order.dataobject.OrderDetail;
import com.joy.order.dto.OrderDTO;
import com.joy.order.enums.ResultEnum;
import com.joy.order.exception.OrderException;
import com.joy.order.form.OrderForm;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class OrderForm2OrderDTOConverter {

    public static OrderDTO convert(OrderForm orderForm) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());

        List<OrderDetail> orderDetailList = new ArrayList<>();

        Gson gson = new Gson();
        try {
            orderDetailList = gson.fromJson(orderForm.getItems(),
                    new TypeToken<List<OrderDetail>>(){}.getType());
        } catch (Exception e) {
            log.error("【json 转换】 错误, string={}", orderForm.getItems());
            throw new OrderException(ResultEnum.PARAM_ERROR);
        }

        orderDTO.setOrderDetailList(orderDetailList);

        return orderDTO;
    }

}
