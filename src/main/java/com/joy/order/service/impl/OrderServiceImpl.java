package com.joy.order.service.impl;

import com.joy.order.dataobject.OrderMaster;
import com.joy.order.dto.OrderDTO;
import com.joy.order.enums.OrderStatusEnum;
import com.joy.order.enums.PayStatusEnum;
import com.joy.order.repository.OrderDetailRepository;
import com.joy.order.repository.OrderMasterRepository;
import com.joy.order.service.OrderService;
import com.joy.order.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.rmi.CORBA.Util;
import java.math.BigDecimal;

/**
 * Created by Ai Lun on 2019-07-25.
 */
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Override
    public OrderDTO create(OrderDTO orderDTO) {
        // TODO 查询商品信息(调用商品服务)
        // TODO 计算总价
        // TODO 扣库存(调用商品服务)

        // 订单入库

        OrderMaster orderMaster = new OrderMaster();
        orderDTO.setOrderId(KeyUtil.genUniqueKey());
        BeanUtils.copyProperties(orderDTO, orderMaster);
        orderMaster.setOrderAmount(new BigDecimal(5));
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());

        orderMasterRepository.save(orderMaster);
        return orderDTO;
    }

}
