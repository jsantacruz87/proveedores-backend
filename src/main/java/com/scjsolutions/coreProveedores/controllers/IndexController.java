package com.scjsolutions.coreProveedores.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping("/")
    String Index() {
        return "index";
    }
}
