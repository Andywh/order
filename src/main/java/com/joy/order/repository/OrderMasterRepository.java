package com.joy.order.repository;

import com.joy.order.dataobject.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Ai Lun on 2019-07-24.
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {
}
