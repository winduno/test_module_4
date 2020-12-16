package com.testpassmodul4.minh.controller;

import com.testpassmodul4.minh.model.Nation;
import com.testpassmodul4.minh.model.Province;
import com.testpassmodul4.minh.repository.INationRepo;
import com.testpassmodul4.minh.service.nation.INationService;
import com.testpassmodul4.minh.service.province.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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
    public ModelAndView openHomePage(@RequestParam (name = "message", required = false) String message) {
        ModelAndView modelAndView = new ModelAndView("home");
        Iterable<Province> provinces = provinceService.findAll();
        modelAndView.addObject("provinces", provinces);
        modelAndView.addObject("message", message);
        return modelAndView;
    }

    @GetMapping("/addprovince")
    public ModelAndView showFormCreate() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("province", new Province());
        Iterable<Nation> nations = nationService.findAll();
        modelAndView.addObject("nations", nations);
        return modelAndView;
    }

    @PostMapping("/province/save")
    public ModelAndView create(@ModelAttribute Province province) {
        provinceService.save(province);
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("message", "Thêm thành công");
        Iterable<Nation> nations = nationService.findAll();
        modelAndView.addObject("nations", nations);
        modelAndView.addObject("province", new Province());
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable (name = "id") int id){
        Province province = provinceService.findById(id);
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("province", province);
        Iterable<Nation> nations = nationService.findAll();
        modelAndView.addObject("nations", nations);
        return modelAndView;
    }

    @PostMapping("/edit/{id}")
    public ModelAndView edit(@ModelAttribute Province province) {
        provinceService.save(province);
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("message", "Sửa thành công");
        modelAndView.addObject("province", province);
        Iterable<Nation> nations = nationService.findAll();
        modelAndView.addObject("nations", nations);
        return modelAndView;
    }

    @GetMapping("/detail/{id}")
    public ModelAndView view(@PathVariable int id){
        Province province = provinceService.findById(id);
        ModelAndView modelAndView = new ModelAndView("view");
        modelAndView.addObject("province", province);
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable int id){
        provinceService.remove(id);
        ModelAndView modelAndView = new ModelAndView("redirect:/home");
        Iterable<Province> provinces = provinceService.findAll();
        modelAndView.addObject("provinces", provinces);
        modelAndView.addObject("message", "Xóa thành công");
        return modelAndView;
    }
}
