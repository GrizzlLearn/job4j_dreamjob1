package ru.job4j.dreamjob1.controller;

import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author dl
 * @date 15.12.2024 18:42
 */

@Controller
@ThreadSafe
@SuppressWarnings("unused")
public class IndexController {
    @GetMapping("/index")
    public String getIndex() {
        return "index";
    }
}
