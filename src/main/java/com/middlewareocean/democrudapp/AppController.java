package com.middlewareocean.democrudapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class AppController {
    Logger logger = LoggerFactory.getLogger(AppController.class);

    @Autowired
    private ProductService productService;

    @RequestMapping("/")
    public String viewHomePage(Model model){
        List<Product> products = productService.listAll();
        model.addAttribute("listProducts", products);
        return "index";
    }

    @RequestMapping("/new")
    public String showNewProductForm(Model model){
        Product product = new Product();
        model.addAttribute( "product", product);
        return "new_product";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("product") Product product){
        productService.save(product);
        return "redirect:/";
    }

}
