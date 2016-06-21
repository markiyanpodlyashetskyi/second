package com.buy_it.controller;

import com.buy_it.entity.Commodity;
import com.buy_it.service.CommodityService;
import com.buy_it.serviceImpl.CommodityServiceImpl;
import com.buy_it.serviceImpl.SubCategoryServiceImpl;
import com.fasterxml.jackson.core.sym.Name;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by koko on 22.05.16.
 */
@Controller
public class CommodityController {

    @Autowired
    private CommodityServiceImpl commodityServiceImpl;
    @Autowired
    private SubCategoryServiceImpl subCategoryServiceImpl;

    @RequestMapping(value = "/saveCommodity", method = RequestMethod.GET)
    public String saveCommodity(Model model){
        model.addAttribute("commodities", commodityServiceImpl.getAll());
        model.addAttribute("subCategories", subCategoryServiceImpl.getAll());
        return "saveCommodity";
    }

    @RequestMapping(value = "/saveCommodity", method = RequestMethod.POST)
    public String saveCommodity(@RequestParam String commodityName, @RequestParam String commodityPrice, @RequestParam String subCategoryId){
        Commodity commodity = new Commodity(commodityName, Integer.parseInt(commodityPrice));
        commodity.setSubCategory(subCategoryServiceImpl.findOne(Integer.parseInt(subCategoryId)));
        commodityServiceImpl.save(commodity);
        return "redirect:/saveCommodity";
    }

    @RequestMapping("/deleteCommodity")
    public String deleteCommodity(@RequestParam String nameCommodity){
        commodityServiceImpl.deleteByName(nameCommodity);
        return "redirect:/saveCommodity";
    }



}
