package com.joy.order.service;

import com.joy.order.dataobject.OrderDetail;
import com.joy.order.dataobject.OrderMaster;
import com.joy.order.dto.OrderDTO;

/**
 * Created by Ai Lun on 2019-07-25.
 */
public interface OrderService {

    /**
     * 创建订单
     * @param orderDTO
     * @return
     */
    OrderDTO create(OrderDTO orderDTO);
}
