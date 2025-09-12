package top.wby.boot.config.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.wby.boot.config.enums.DrinkType;

@RestController
@RequestMapping("/drink")
public class DrinkController {
    @GetMapping("/{type}")
    public String drink(@PathVariable DrinkType type) {
        String s = "您点的是" + type + "，价格是" + type.getPrice();
        return s;
    }
}
