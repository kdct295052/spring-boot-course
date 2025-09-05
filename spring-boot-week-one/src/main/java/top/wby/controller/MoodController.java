package top.wby.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MoodController {
    @Value("${my.mood.today}")
    private String today;
    @Value("${my.mood.content}")
    private String content;
    @Value("${my.mood.author}")
    private String author;
    @Value("${my.feature.helloSwitch}")
    private boolean feature;
    @Value("${my.feature.closeMsg}")
    private String closeMsg;
    @GetMapping("/mood")
    public String mood() {
        return "Today is " + today + " and the mood is " + content + " and the author is " + author;
    }
    @GetMapping("/feature")
    public String feature() {
        if ( feature){
            return "interface is opening";
        }else {
            return closeMsg;
        }
    }
}
