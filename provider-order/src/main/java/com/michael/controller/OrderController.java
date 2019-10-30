package com.michael.controller;

import com.github.pagehelper.PageInfo;
import com.michael.entity.OrderExpressDetail;
import com.michael.entity.OrderMaster;
import com.michael.entity.OrderMasterDetail;
import com.michael.service.OrderService;
import com.michael.util.RedisUtil;
import com.michael.util.UUIDUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * produces = MediaType.APPLICATION_JSON_UTF8_VALUE 当SpringBoot2.0集成eureka使用时需要指定返回的数据类型
 */
@RestController
@RequestMapping(value="/order",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    RedisUtil redisUtil;

    Logger logger = LoggerFactory.getLogger(getClass());

    String userName = "userName";




    //redis test ok
    @GetMapping("/testRedis")
    public String testRedis(){
        return redisUtil.ping();
    }

    @GetMapping("/setName/{name}")
    public String setName(@PathVariable("name") String name){
       return redisUtil.set(userName,name);
    }

    @GetMapping("/getName")
    public String getName(){
        return redisUtil.get(userName);
    }





    @PostMapping("/insertOrder")
    @HystrixCommand //HystrixDashboard监控接口的调用
    public Integer insertOrder(@RequestBody OrderMaster orderInfo) {
        orderInfo.setUserId(UUIDUtil.createUserId());
        return orderService.insertOrder(orderInfo);
    }

    @GetMapping("/getAllOrderInfo/{curPage}/{pageSize}")
    @HystrixCommand
    public PageInfo<OrderMaster> getAllOrderInfo(@PathVariable("curPage") Integer curPage, @PathVariable("pageSize") Integer pageSize) {
        return orderService.getAllOrderInfo(curPage,pageSize);
    }

    @GetMapping("/getOrderInfoByUserId/{curPage}/{pageSize}/{userId}")
    @HystrixCommand
    public PageInfo<OrderMaster> getOrderInfoByUserId(@PathVariable("curPage") Integer curPage, @PathVariable("pageSize") Integer pageSize,
                                                      @PathVariable("userId") String userId) {
        return orderService.getOrderInfoByUserId(curPage,pageSize,userId);
    }


    @GetMapping("/getOrderInfoByOrderNo/{orderNo}")
    @HystrixCommand
    public OrderMaster getOrderInfoByOrderNo(@PathVariable("orderNo") String orderNo) {
        return orderService.getOrderInfoByOrderNo(orderNo);
    }

    @GetMapping("/getOrderInfoByTime/{startTime}/{endTime}")
    @HystrixCommand
    public List<OrderMaster> getOrderInfoByTime(@PathVariable("startTime") String startTime,
                                                @PathVariable("endTime") String endTime) throws ParseException {
        logger.info("服务提供者收到参数: startTime:  "+startTime+" endTime : "+endTime);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date startDate = simpleDateFormat.parse(startTime);
        Date endDate = simpleDateFormat.parse(endTime);
        return orderService.getOrderInfoByTime(startDate,endDate);
    }


    /**
     * 一对多查询
     * @param orderNo
     * @return
     */
    @GetMapping("/getOrderDetailInfo/{orderNo}")
    public OrderMasterDetail getOrderDetailInfo(@PathVariable("orderNo") String orderNo){
        return orderService.getOrderDetailInfo(orderNo);
    }

    /**
     * 一对一
     * @param orderNo
     * @return
     */
    @GetMapping("/getOrderExpressDetailInfo/{orderNo}")
    public OrderExpressDetail getOrderExpressDetailInfo(@PathVariable("orderNo") String orderNo){
        logger.info("=============getOrderExpressDetailInfo========"+orderNo);
        return orderService.getOrderExpressDetailInfo(orderNo);
    }


    @PostMapping("/updateOrderInfo")
    public Integer updateOrderInfo(@RequestBody OrderMaster orderMaster) {
        return orderService.updateOrderInfo(orderMaster);
    }

}
