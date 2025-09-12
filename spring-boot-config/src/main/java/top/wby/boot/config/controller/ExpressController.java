package top.wby.boot.config.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.wby.boot.config.enums.ExpressStatus;

/**
 * @author YUU
 */
@RestController
@RequestMapping("/express")
public class ExpressController {
    @GetMapping("/{status}")
    public String express(@PathVariable ExpressStatus  status) {
        return status.getLable();
    }

}

