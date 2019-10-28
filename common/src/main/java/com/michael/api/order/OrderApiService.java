package com.michael.api.order;

import com.github.pagehelper.PageInfo;
import com.michael.api.fallback.OrderApiServiceFallBack;
import com.michael.entity.OrderInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;


@FeignClient(value = "PROVIDER-ORDER",fallbackFactory = OrderApiServiceFallBack.class)
public interface OrderApiService {

    @PostMapping("/order/insertOrder")
    Integer insertOrder(@RequestBody OrderInfo orderInfo);

    @GetMapping("/order/getAllOrderInfo/{curPage}/{pageSize}")
    PageInfo<OrderInfo> getAllOrderInfo(@PathVariable("curPage") Integer curPage, @PathVariable("pageSize") Integer pageSize);

    @GetMapping("/order/getOrderInfoByUserId/{curPage}/{pageSize}/{userId}")
    PageInfo getOrderInfoByUserId(@PathVariable("curPage") Integer curPage, @PathVariable("pageSize") Integer pageSize,
                                         @PathVariable("userId") String userId);

    @GetMapping("/order/getOrderInfoByOrderNo/{orderNo}")
    OrderInfo getOrderInfoByOrderNo(@PathVariable("orderNo") String orderNo);

    @GetMapping("/order/getOrderInfoByTime/{startTime}/{endTime}")
    List<OrderInfo> getOrderInfoByTime(@PathVariable("startTime") String startTime,
                                              @PathVariable("endTime") String endTime);
}
