package com.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.service.ProductService;
import com.service.PurchaseService;
import com.service.UserService;

@Controller
public class SportyShoesController {

    @Autowired
    ProductService productService;
    @Autowired
    UserService userService; 
    @Autowired
    PurchaseService purchaseService; 

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "redirect:/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model) {
        return "loginPage";
    }

    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String login(String email, String password, Model model) {
        if (("admin@email.com".equals(email) && "password".equals(password))|| ((userService.isAdmin(email)))) {
            return "redirect:admin";
        } else if (userService.isUser(email)){ // add password check
            return "redirect:user";
        } else {
            model.addAttribute("error", "Invalid email or password");
            return "loginPage";
        }
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String userDashboard(Model model) {
        model.addAttribute("message", "");
        model.addAttribute("products",productService.getAllProducts());
        return "userDashboard";
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String addUserPurchase(int userId, int productId, int quantity, Model model) {
        
        model.addAttribute("message", purchaseService.addPurchase(userId, productId, quantity));
        model.addAttribute("products",productService.getAllProducts());
        return "userDashboard";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminDashboard(Model model) {
        return "adminDashboard";
    }
    
    @RequestMapping(value = "/admin/products", method = RequestMethod.GET)
    public String manageProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "manageProducts";
    }

    @RequestMapping(value = "/admin/products/update", method = RequestMethod.POST)
    public String updateProduct(Model model, int productId, String category) {
        model.addAttribute("products", productService.updateProductCategory(productId, category));
        return "redirect:/admin/products";
    }

    @RequestMapping(value = "/admin/products/add", method = RequestMethod.POST)
    public String addProduct(Model model, String prodName, String prodCat, float prodPrice) {
        productService.addProduct(prodName, prodCat, prodPrice);
        model.addAttribute("products", productService.getAllProducts());
        return "redirect:/admin/products";
    }

    @RequestMapping(value = "/admin/users", method = RequestMethod.GET)
    public String browseUsers(Model model, String search) {
        if (search != null && !search.isEmpty()) {
            model.addAttribute(
                "users",
                userService.getUserNameContaining(search)
            );
        } else {
            model.addAttribute(
                "users",
                userService.getAllUsers()
            );
        }
        return "browseUsers";
    }

    @RequestMapping(value = "/admin/users", method = RequestMethod.POST)
    public String addUser(String name, String role, String email, Model model) {
        userService.addUser(name, role, email);
        model.addAttribute("message", "User added successfully");
        model.addAttribute("users", userService.getAllUsers());
        return "browseUsers";
    }

    @RequestMapping(value = "/admin/purchases", method = RequestMethod.GET)
    public String purchaseReports(Model model, String date, String category) {
        if(date != null && !date.isEmpty()){
            LocalDate localDate = LocalDate.parse(date); 
            model.addAttribute("reports", purchaseService.getPurchasesOn(localDate));
            model.addAttribute("message", "Reports on "+ date + " date fetched successfully");
        }
        else if(category!=null && !category.isEmpty()){
            model.addAttribute("reports",purchaseService.getPurchaseByCategory(category));
            model.addAttribute("message", "Reports on "+ category + " purchases fetched successfully");
        }
        else{
            model.addAttribute("reports",purchaseService.getAllPurchases());
        }
        return "purchaseReports";
    }

    @RequestMapping(value = "/admin/purchases", method = RequestMethod.POST)
    public String addAdminPurchase(int userId, int productId, int quantity, Model model) {
        
        model.addAttribute("message", purchaseService.addPurchase(userId, productId, quantity));
        model.addAttribute("reports",purchaseService.getAllPurchases());
        return "purchaseReports";
    }


}
