package com.x3800.store.controller;

import com.x3800.store.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MenuController {

    @Autowired
    MenuRepository menuRepository;

    @RequestMapping(method = RequestMethod.GET, path = "/menus/goodmenu")
    public String goodMenu() {
        return "good menu~~";
    }

}
