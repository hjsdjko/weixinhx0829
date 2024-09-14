package com.example.controller;

import com.example.common.Result;
import com.example.entity.Zuoweixinxi;
import com.example.service.ZuoweixinxiService;
import com.example.vo.ZuoweixinxiVo;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/zuoweixinxi")
public class ZuoweixinxiController {
    @Resource
    private ZuoweixinxiService zuoweixinxiService;

    @PostMapping
    public Result<Zuoweixinxi> add(@RequestBody ZuoweixinxiVo zuoweixinxi) {
        zuoweixinxiService.add(zuoweixinxi);
        return Result.success(zuoweixinxi);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        zuoweixinxiService.delete(id);
        return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody ZuoweixinxiVo zuoweixinxi) {
        zuoweixinxiService.update(zuoweixinxi);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result<Zuoweixinxi> detail(@PathVariable Long id) {
        Zuoweixinxi zuoweixinxi = zuoweixinxiService.findById(id);
        return Result.success(zuoweixinxi);
    }

    @GetMapping
    public Result<List<ZuoweixinxiVo>> all() {
        return Result.success(zuoweixinxiService.findAll());
    }

    @GetMapping("/page/{name}")
    public Result<PageInfo<ZuoweixinxiVo>> page(@PathVariable String name,
                                               @RequestParam(defaultValue = "1") Integer pageNum,
                                               @RequestParam(defaultValue = "5") Integer pageSize,
                                               HttpServletRequest request) {
        return Result.success(zuoweixinxiService.findPage(name, pageNum, pageSize, request));
    }
}
