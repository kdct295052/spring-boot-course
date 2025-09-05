package top.wby.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String index() {
        return "Hello World!";
    }
    @GetMapping("/string")
    public List<String> strings() {
        return List.of("string1", "string2");
    }
}
