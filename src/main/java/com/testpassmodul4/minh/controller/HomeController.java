package com.testpassmodul4.minh.controller;

import com.testpassmodul4.minh.model.Province;
import com.testpassmodul4.minh.repository.INationRepo;
import com.testpassmodul4.minh.service.nation.INationService;
import com.testpassmodul4.minh.service.province.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @Autowired
    private IProvinceService provinceService;
    @Autowired
    private INationService nationService;

    @Autowired
    Environment env;

    @GetMapping("/home")
    public ModelAndView openHomePage(){
        ModelAndView modelAndView = new ModelAndView("/home");
        Iterable<Province> provinces = provinceService.findAll();
        modelAndView.addObject("provinces", provinces);
        return modelAndView;
    }

    @GetMapping("/addprovince")
    public ModelAndView addProvince(){
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("nations", nationService.findAll());
        return modelAndView;
    }
}
