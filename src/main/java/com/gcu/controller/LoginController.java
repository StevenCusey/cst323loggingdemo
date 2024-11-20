package com.gcu.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.validation.BindingResult;
import org.springframework.ui.Model;

import com.gcu.business.OrdersBusinessServiceInterface;
import com.gcu.business.SecurityBusinessService;
import com.gcu.model.LoginModel;

import jakarta.validation.Valid;

@Controller
public class LoginController {

	private static final Logger logger = LogManager.getLogger(LoginController.class);

	
    @Autowired
    private OrdersBusinessServiceInterface ordersService;

    @Autowired
    private SecurityBusinessService securityService;

    @GetMapping("/login/")
    public String showLoginForm(Model model) {
    	logger.info("login method accessed");
        model.addAttribute("loginModel", new LoginModel());
        return "login";
    }

    @PostMapping("/doLogin")
    public String doLogin(@Valid @ModelAttribute("loginModel") LoginModel loginModel, BindingResult bindingResult, Model model) {
        logger.info("doLogin method invoked with username: {}", loginModel.getUsername());
        
        if (bindingResult.hasErrors()) {
            logger.warn("Validation errors found for login attempt by username: {}", loginModel.getUsername());
            model.addAttribute("title", "Login Form");
            return "login";
        }

        if (securityService.authenticate(loginModel.getUsername(), loginModel.getPassword())) {
            logger.info("Authentication successful for username: {}", loginModel.getUsername());
            model.addAttribute("title", "My Orders");
            model.addAttribute("orders", ordersService.getOrders());
            return "orders";
        } else {
            logger.error("Authentication failed for username: {}", loginModel.getUsername());
            model.addAttribute("title", "Login Form");
            model.addAttribute("loginError", "Invalid username or password");
            return "login";
        }
    }
    
}
