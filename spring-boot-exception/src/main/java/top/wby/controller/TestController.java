package top.wby.controller;

import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import top.wby.common.Result;
import top.wby.entity.User;
import top.wby.service.ExceptionService;
@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {
    @Resource
    private ExceptionService exceptionService;
    @RequestMapping("/{id}")
    public Result<String> test(@PathVariable int id) {
      if (id==0){
          exceptionService.unAuthorized();
      }else if (id==1){
          exceptionService.systemError();
      }else {
          int n=1/0;
          return Result.ok("查询成功");
      }
        return Result.ok("查询成功");
    }
    @PostMapping("/user")
    public Result<?> addUser(@Valid @RequestBody User user, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            log.info("参数错误");
            return Result.error(bindingResult.getAllErrors().get(0).getDefaultMessage());
        }
        return Result.ok(user);
    }

}
