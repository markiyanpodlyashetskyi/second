package com.buy_it.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.buy_it.entity.User;
import com.buy_it.serviceImpl.UserServiceImpl;

/**
 * Created by koko on 24.05.16.
 */
@Controller
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @RequestMapping(value = "/saveUser", method = RequestMethod.GET)
    public String saveUser(Model model){
        model.addAttribute("users", userServiceImpl.getAll());
        model.addAttribute("user", new User());
        return "saveUser";
    }

    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute User user, Model model){
        userServiceImpl.save(user);
        model.addAttribute("user", user);
        return "profile";
    }

    @RequestMapping(value = "/deleteUsers", method = RequestMethod.POST)
    public String deleteUsers(@RequestParam String usernames){
    		userServiceImpl.delete(usernames);
        return "redirect:/saveUser";
    }

    
    /*@RequestMapping(value = "/deleteUsers", method = RequestMethod.POST)
    public String deleteUsers(@RequestParam String usernames){
    	String [] usern = usernames.split(",");
    	for (String string : usern) {
    		userServiceImpl.delete(string);
		}
        
        return "redirect:/saveUser";
    }*/
    
    @RequestMapping("/login")
    public String login(){
        return "loginpage";
    }

    @RequestMapping(value="/loginUser", method=RequestMethod.POST)
    public String loginUser(@RequestParam String userName,@RequestParam String password){
    	
        return "home";
    }
    
    
    @RequestMapping ("/logout")
    public String logout(){
    	return "redirect:/";
    }
    
    
    

}
