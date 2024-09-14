package com.example.controller;

import com.example.common.Result;
import com.example.entity.Yuyuezuowei;
import com.example.service.YuyuezuoweiService;
import com.example.vo.YuyuezuoweiVo;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/yuyuezuowei")
public class YuyuezuoweiController {
    @Resource
    private YuyuezuoweiService yuyuezuoweiService;

    @PostMapping
    public Result<Yuyuezuowei> add(@RequestBody YuyuezuoweiVo yuyuezuowei) {
        yuyuezuoweiService.add(yuyuezuowei);
        return Result.success(yuyuezuowei);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        yuyuezuoweiService.delete(id);
        return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody YuyuezuoweiVo yuyuezuowei) {
        yuyuezuoweiService.update(yuyuezuowei);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result<Yuyuezuowei> detail(@PathVariable Long id) {
        Yuyuezuowei yuyuezuowei = yuyuezuoweiService.findById(id);
        return Result.success(yuyuezuowei);
    }

    @GetMapping
    public Result<List<Yuyuezuowei>> all() {
        return Result.success(yuyuezuoweiService.findAll());
    }

    @GetMapping("/page")
    public Result<PageInfo<Yuyuezuowei>> page(
                                               @RequestParam(defaultValue = "1") Integer pageNum,
                                               @RequestParam(defaultValue = "5") Integer pageSize,
                                               HttpServletRequest request) {
        return Result.success(yuyuezuoweiService.findPage(pageNum, pageSize, request));
    }
}
