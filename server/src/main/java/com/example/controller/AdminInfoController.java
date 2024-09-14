package com.example.controller;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.example.common.Result;
import com.example.common.ResultCode;
import com.example.entity.UserInfo;
import com.example.exception.CustomException;
import com.example.service.AdminInfoService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/adminInfo")
public class AdminInfoController {
    @Resource
    private AdminInfoService adminInfoService;

    @PostMapping
    public Result<UserInfo> add(@RequestBody UserInfo userInfo) {
        adminInfoService.add(userInfo);
        return Result.success(userInfo);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        adminInfoService.delete(id);
        return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody UserInfo userInfo) {
        adminInfoService.update(userInfo);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result<UserInfo> detail(@PathVariable Long id) {
        UserInfo userInfo = adminInfoService.findById(id);
        return Result.success(userInfo);
    }

    @GetMapping
    public Result<List<UserInfo>> all() {
        return Result.success(adminInfoService.findAll());
    }

    @GetMapping("/page/{name}")
    public Result<PageInfo<UserInfo>> page(@RequestParam(defaultValue = "1") Integer pageNum,
                                           @RequestParam(defaultValue = "10") Integer pageSize,
                                           @PathVariable String name) {
        return Result.success(adminInfoService.findPage(pageNum, pageSize, name));
    }

    /**
     * 注册
     */
    @PostMapping("/register")
    public Result<UserInfo> register(@RequestBody UserInfo userInfo) {
        if (StrUtil.isBlank(userInfo.getYonghuming()) || StrUtil.isBlank(userInfo.getMima())) {
            throw new CustomException(ResultCode.PARAM_ERROR);
        }
        return Result.success(adminInfoService.add(userInfo));
    }

    /**
     * 登录
     */
    @PostMapping("/login")
    public Result<UserInfo> login(@RequestBody UserInfo userInfo) {
        if (StrUtil.isBlank(userInfo.getYonghuming()) || StrUtil.isBlank(userInfo.getMima())) {
            throw new CustomException(ResultCode.USER_ACCOUNT_ERROR);
        }
        return Result.success(adminInfoService.login(userInfo.getYonghuming(), userInfo.getMima()));
    }

    /**
     * 重置密码为123456
     */
    @PutMapping("/resetPassword")
    public Result<UserInfo> resetPassword(@RequestParam String name) {
        return Result.success(adminInfoService.resetMima(name));
    }

    /**
     * 修改密码
     */
    @PutMapping("/changePassword")
    public Result<Boolean> changePassword(@RequestParam Long id,
                                          @RequestParam String newPassword) {
        return Result.success(adminInfoService.changePassword(id, newPassword));
    }
}
