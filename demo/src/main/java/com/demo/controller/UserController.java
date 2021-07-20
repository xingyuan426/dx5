package com.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：xingyuan.zhang
 * @date ：Created in 2021/7/17 15:04
 * @description：
 * @version:
 */
@RestController
public class UserController {

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(){
        return "成功";
    }
}
