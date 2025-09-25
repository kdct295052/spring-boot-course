package top.wby.boot.mp.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import top.wby.boot.mp.common.ApiResponse;
import top.wby.boot.mp.entity.UserAccount;
import top.wby.boot.mp.service.UserAccountService;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserAccountController {
    private final UserAccountService userAccountService;
    @PostMapping
    public ApiResponse<UserAccount> createUserAccount(@Valid @RequestBody UserAccount useraccount){
        boolean saved = userAccountService.createUserAccount(useraccount);
        return saved?ApiResponse.success("创建成功"):ApiResponse.failed("创建失败");
    }
    @GetMapping("/{id}")
    public ApiResponse<UserAccount> getUserAccount(@PathVariable Long id){
        UserAccount useraccount = userAccountService.getById(id);
        return useraccount!=null?ApiResponse.success("查询成功",useraccount):ApiResponse.failed("查询失败");
    }
    @GetMapping
    public ApiResponse<List<UserAccount>> getAllUsers(){
        List<UserAccount> users = userAccountService.list();
        return users!=null?ApiResponse.success("查询成功",users):ApiResponse.failed("查询失败");
    }
    @GetMapping("/page")
    public ApiResponse<IPage<UserAccount>> getUsersPage(@RequestParam(defaultValue
            = "1") int current,@RequestParam(defaultValue="10") int size){
        Page<UserAccount> page =new Page<>(current,size);
        IPage<UserAccount> usersPage = userAccountService.page(page);
        return ApiResponse.success("查询成功",usersPage);
    }
    @GetMapping("username/{username}")
    public ApiResponse<UserAccount> getUserByUsername(@PathVariable String username){
        UserAccount useraccount = userAccountService.getOne(new LambdaQueryWrapper<UserAccount>()
                .eq(UserAccount::getUsername, username));
        return useraccount!=null?ApiResponse.success("查询成功",useraccount):ApiResponse.failed("查询失败");
    }
    @GetMapping("/search")
    public ApiResponse<List<UserAccount>> searchUsersByNickname(@RequestParam String nickname){
        List<UserAccount> list = userAccountService.list(new LambdaQueryWrapper<UserAccount>().like(UserAccount::getNickname, nickname));
        return list!=null?ApiResponse.success("查询成功",list):ApiResponse.failed("查询失败");

    }
    @PutMapping("/{id}")
    public ApiResponse<UserAccount> updateUserAccount(@PathVariable Long id,@Valid @RequestBody UserAccount useraccount){
        useraccount.setId(id);
        boolean updated = userAccountService.updateById(useraccount);
        return updated?ApiResponse.success("更新成功"):ApiResponse.failed("更新失败");
    }
    @DeleteMapping("/{id}")
    public ApiResponse<Void> deleteUserAccount(@PathVariable Long id){
        boolean deleted = userAccountService.removeById(id);
        return deleted?ApiResponse.success("删除成功"):ApiResponse.failed("删除失败");
    }
    @PostMapping("/batch")
    public ApiResponse<List<UserAccount>> createUsers(@Valid @RequestBody List<UserAccount> userAccounts){
        boolean saved = userAccountService.createUserAccount((UserAccount) userAccounts);
        return saved?ApiResponse.success("批量创建成功"):ApiResponse.failed("批量创建失败");
    }
    @DeleteMapping("/batch")
    public ApiResponse<Void> deleteUsers(@RequestBody List<UserAccount> userAccounts){
        boolean deleted = userAccountService.remove(new LambdaQueryWrapper<UserAccount>().in(UserAccount::getId, userAccounts));
        return deleted?ApiResponse.success("批量删除成功"):ApiResponse.failed("批量删除失败");
    }
    @GetMapping("/count")
    public ApiResponse<Long> countUsers(){
        long count = userAccountService.count();
        return ApiResponse.success("查询成功",count);
    }
    @GetMapping("count/active")
    public ApiResponse<Long> getActiveUserCount(){
        long count = userAccountService.count(new LambdaQueryWrapper<UserAccount>().eq(UserAccount::getStatus, 1));
        return ApiResponse.success("查询成功",count);
    }
    @PatchMapping("/{id}/status")
    public ApiResponse<UserAccount> updateUserStatus(@PathVariable Long id,@RequestParam Integer status){
        UserAccount useraccount = userAccountService.getById(id);
        if(useraccount==null){
            return ApiResponse.failed("用户不存在");
        }
        useraccount.setStatus(status);
        boolean updated = userAccountService.updateById(useraccount);
        return updated?ApiResponse.success("更新成功",useraccount):ApiResponse.failed("更新失败");
    }

}
