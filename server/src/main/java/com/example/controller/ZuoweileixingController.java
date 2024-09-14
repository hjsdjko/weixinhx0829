package com.example.controller;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.example.common.Result;
import com.example.entity.Zuoweileixing;
import com.example.service.ZuoweileixingService;
import com.example.vo.ZuoweileixingVo;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/zuoweileixing")
public class ZuoweileixingController {
    @Resource
    private ZuoweileixingService zuoweileixingService;

    @PostMapping
    public Result<Zuoweileixing> add(@RequestBody ZuoweileixingVo zuoweileixing) {
        zuoweileixingService.add(zuoweileixing);
        return Result.success(zuoweileixing);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        zuoweileixingService.delete(id);
        return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody ZuoweileixingVo zuoweileixing) {
        zuoweileixingService.update(zuoweileixing);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result<Zuoweileixing> detail(@PathVariable Long id) {
        Zuoweileixing zuoweileixing = zuoweileixingService.findById(id);
        return Result.success(zuoweileixing);
    }

    @GetMapping
    public Result<List<ZuoweileixingVo>> all() {
        return Result.success(zuoweileixingService.findAll());
    }

    @GetMapping("/page/{name}")
    public Result<PageInfo<ZuoweileixingVo>> page(@PathVariable String name,
                                               @RequestParam(defaultValue = "1") Integer pageNum,
                                               @RequestParam(defaultValue = "5") Integer pageSize,
                                               HttpServletRequest request) {
        return Result.success(zuoweileixingService.findPage(name, pageNum, pageSize, request));
    }
}
