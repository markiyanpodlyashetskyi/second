package com.buy_it.controller;

import com.buy_it.entity.Category;
import com.buy_it.entity.SubCategory;
import com.buy_it.serviceImpl.CategoryServiceImpl;
import com.buy_it.serviceImpl.SubCategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by koko on 25.05.16.
 */
@Controller
public class SubCategoryController {

    @Autowired
    private SubCategoryServiceImpl subCategoryServiceImpl;
    @Autowired
    private CategoryServiceImpl categoryServiceImpl;

    @RequestMapping("/saveSubCategory")
    public String saveSubCategory(Model model){
        model.addAttribute("subCategories", subCategoryServiceImpl.getAll());
        model.addAttribute("categories", categoryServiceImpl.getAll());
        model.addAttribute("subCategory", new SubCategory());
        return "saveSubCategory";
    }

    @RequestMapping(value = "/saveSubCategory",method = RequestMethod.POST)
    public String saveSubCategory(@ModelAttribute SubCategory subCategory, @RequestParam String categoryName){
        subCategory.setCategory(categoryServiceImpl.findCategoryByName(categoryName));
        subCategoryServiceImpl.saveSubCategoty(subCategory);
        return "redirect:/saveSubCategory";
    }

    @RequestMapping("deleteSubCategory/{id}")
    public String deleteSubCategory(@PathVariable String id){
        subCategoryServiceImpl.delete(Integer.parseInt(id));
        return "redirect:/saveSubCategory";
    }

}
