package com.spring.dbs.ctrl;

import com.spring.dbs.service.MyService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * <p>
 *
 * @author cs12110 create at 2020-03-28 12:41
 * <p>
 * @since 1.0.0
 */
@Controller
@RequestMapping("/my")
public class MyCtrl {

    @Resource
    private MyService myService;


    @RequestMapping("/findInfo")
    @ResponseBody
    public Object findInfo(String orderNo) {
        return myService.findInfo(orderNo);
    }


    @RequestMapping("/saveInfo")
    @ResponseBody
    public Object saveInfo(int operation, boolean rollback) {
        if (1 == operation) {
            return myService.saveOrderInfo(rollback);
        } else if (2 == operation) {
            return myService.saveProductInfo(rollback);
        } else {
            return myService.saveBothInfo(rollback);
        }
    }
}
