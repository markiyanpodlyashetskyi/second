package com.buy_it.controller;

import com.buy_it.serviceImpl.CommodityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by koko on 30.05.16.
 */
@Controller
public class HomeController {

    @Autowired
    private CommodityServiceImpl commodityServiceImpl;


    @RequestMapping("/")
    public String home(Model model){
        model.addAttribute("commodities", commodityServiceImpl.getAll());
        return "home";
    }


}
