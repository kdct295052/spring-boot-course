package top.wby.boot.mp.controller;

import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.wby.boot.mp.entity.UserAccount;
import top.wby.boot.mp.mapper.UserAccountMapper;

@RestController
@RequestMapping("/userAccount")
@Validated
public class UserAccountController {
    @Resource
    private UserAccountMapper userAccountMapper;
    @GetMapping("/{id}")
    public UserAccount getUserAccount(@PathVariable Long id) {
        return userAccountMapper.selectById(id);

    }

    @PostMapping("/insert")
    public int insertUserAccount(@RequestBody UserAccount userAccount) {
        return userAccountMapper.insert(userAccount);

    }
}
