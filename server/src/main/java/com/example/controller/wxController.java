package com.example.controller;


import com.example.entity.*;
import com.example.service.*;
import com.example.vo.ZuoweileixingVo;
import com.example.vo.ZuoweixinxiVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class wxController {
    @Resource
    private UserInfoService userInfoService;
    @Resource
    private AdvertiserInfoService advertiserInfoService;
    @Resource
    private ZuoweileixingService zuoweileixingService;
    @Resource
    private ZuoweixinxiService zuoweixinxiService;
    @Resource
    private YuyuezuoweiService yuyuezuoweiService;
    @RequestMapping(value="/user/login",method= RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> userlogin(@RequestBody UserInfo allusers){
        try {
            UserInfo u = userInfoService.login(allusers.getYonghuming(),allusers.getMima());
            Map<String,Object> ret = new HashMap<String,Object>();
            if (u == null) {
                ret.put("code", -1);
                ret.put("msg", "用户名或密码不正确");
                return ret;
            }
            ret.put("code", 0);
            ret.put("msg", "登录成功");
            ret.put("user", u);
            return ret;
        } catch (Exception e) {
            Map<String,Object> ret = new HashMap<String,Object>();
            ret.put("code", -2);
            ret.put("msg", "系统繁忙，请稍后再试");
            return ret;
        }
    }
    @RequestMapping(value="/user/reg",method= RequestMethod.POST,produces = "application/json;charset=utf-8")
    @ResponseBody
    public Map<String,Object> register(@RequestBody UserInfo  allusers){
        try {
            Timestamp time=new Timestamp(System.currentTimeMillis());
            allusers.setAddtime(time.toString().substring(0, 19));
            UserInfo userInfo = userInfoService.add(allusers);
            Map<String,Object> ret = new HashMap<String,Object>();
            if (userInfo.getId() == null) {
                ret.put("code", -1);
                ret.put("msg", "操作失败");
                return ret;
            }
            ret.put("code", 0);
            ret.put("msg", "注册成功");
            ret.put("user", allusers);
            return ret;
        } catch (Exception e) {
            Map<String,Object> ret = new HashMap<String,Object>();
            ret.put("code", -2);
            ret.put("msg", e.getMessage());
            return ret;
        }
    }
    @RequestMapping(value="/user/userInfo",method= RequestMethod.POST,produces = "application/json;charset=utf-8")
    @ResponseBody
    public Map<String,Object> yhDetail(@RequestBody UserInfo yonghu){
        yonghu=userInfoService.findById(yonghu.getId());
        Map<String,Object> ret = new HashMap<String,Object>();
        ret.put("code", 0);
        ret.put("msg", "查询成功");
        ret.put("user", yonghu);
        return ret;
    }
    @RequestMapping(value="/user/updateInfo",method= RequestMethod.POST,produces = "application/json;charset=utf-8")
    @ResponseBody
    public Map<String,Object> updateInfo(@RequestBody UserInfo yonghu){
        userInfoService.update(yonghu);
        Map<String,Object> ret = new HashMap<String,Object>();
        ret.put("code", 0);
        ret.put("msg", "修改成功");
        ret.put("user", yonghu);
        return ret;
    }
    @RequestMapping(value="/index/xinwentongzhiList",method= RequestMethod.POST,produces = "application/json;charset=utf-8")
    @ResponseBody
    public Map<String,Object> shangjiaxinxiList(){
        List<AdvertiserInfo> list=advertiserInfoService.findAll();
        Map<String,Object> ret = new HashMap<String,Object>();
        ret.put("code", 0);
        ret.put("msg", "查询成功");
        ret.put("list", list);
        return ret;
    }
    @RequestMapping(value="/index/zuoweileixingList",method= RequestMethod.POST,produces = "application/json;charset=utf-8")
    @ResponseBody
    public Map<String,Object> zuoweileixingList(){
        List<ZuoweileixingVo> list=zuoweileixingService.findAll();
        Map<String,Object> ret = new HashMap<String,Object>();
        ret.put("code", 0);
        ret.put("msg", "查询成功");
        ret.put("list", list);
        return ret;
    }
    @RequestMapping(value="/index/xinwentongzhiDetail",method= RequestMethod.POST,produces = "application/json;charset=utf-8")
    @ResponseBody
    public Map<String,Object> shangjiaxinxiList(@RequestBody AdvertiserInfo advertiserInfo){
        AdvertiserInfo list=advertiserInfoService.findById(advertiserInfo.getId());
        Map<String,Object> ret = new HashMap<String,Object>();
        ret.put("code", 0);
        ret.put("msg", "查询成功");
        ret.put("data", list);
        return ret;
    }
    @RequestMapping(value="/index/zuoweiYuyueList",method= RequestMethod.POST,produces = "application/json;charset=utf-8")
    @ResponseBody
    public Map<String,Object> zuoweiYuyueList(@RequestBody Zuoweileixing zuoweileixing){
        Map<String, Object> pmap=new HashMap<String,Object>();
        pmap.put("userId",zuoweileixing.getUserId());
        UserInfo yonghu = userInfoService.findById(zuoweileixing.getUserId());
        pmap.put("leixing",zuoweileixing.getLeixing());
        pmap.put("yonghuming",yonghu.getYonghuming());
        pmap.put("zhuangtai","占用");
        List<ZuoweixinxiVo> zhanyong = zuoweixinxiService.getAll(pmap);
        pmap.put("starttime",zuoweileixing.getStartTime());
        List<Yuyuezuowei> yiYuyue = yuyuezuoweiService.getAllYiYuyue(pmap);
        List<Yuyuezuowei> myYuyue = yuyuezuoweiService.getAllMyYUyue(pmap);
        Map<String,Object> ret = new HashMap<String,Object>();
        ret.put("code", 0);
        ret.put("msg", "查询成功");
        ret.put("zhanyong", zhanyong);
        ret.put("yiYuyue", yiYuyue);
        ret.put("myYuyue", myYuyue);
        return ret;
    }
    @RequestMapping(value="/index/yuyueZuowei",method= RequestMethod.POST,produces = "application/json;charset=utf-8")
    @ResponseBody
    public Map<String,Object> yuyueZuowei(@RequestBody Yuyuezuowei yuyuezuowei){
        yuyuezuowei.setYuyuehao(UUID.randomUUID().toString());
        yuyuezuoweiService.add(yuyuezuowei);
        Map<String,Object> ret = new HashMap<String,Object>();
        ret.put("code", 0);
        ret.put("msg", "预约成功");
        return ret;
    }
    @RequestMapping(value="/index/quxiao",method= RequestMethod.POST,produces = "application/json;charset=utf-8")
    @ResponseBody
    public Map<String,Object> quxiao(@RequestBody Zuoweileixing zuoweileixing){
        Map<String, Object> pmap=new HashMap<String,Object>();
        pmap.put("userId",zuoweileixing.getUserId());
        UserInfo yonghu = userInfoService.findById(zuoweileixing.getUserId());
        yonghu.setJifen(yonghu.getJifen()-10);
        userInfoService.update(yonghu);
        pmap.put("leixing",zuoweileixing.getLeixing());
        pmap.put("yonghuming",yonghu.getYonghuming());
        pmap.put("starttime",zuoweileixing.getStartTime());
        List<Yuyuezuowei> myYuyue = yuyuezuoweiService.getAllMyYUyue(pmap);
        if(myYuyue.size()>0){
            for (Yuyuezuowei yuyuezuowei : myYuyue) {
                yuyuezuoweiService.delete(yuyuezuowei.getId());
            }
        }
        Map<String,Object> ret = new HashMap<String,Object>();
        ret.put("code", 0);
        ret.put("msg", "取消成功");
        return ret;
    }
    @RequestMapping(value="/index/qiandao",method= RequestMethod.POST,produces = "application/json;charset=utf-8")
    @ResponseBody
    public Map<String,Object> qiandao(@RequestBody Zuoweileixing zuoweileixing) throws ParseException {
        Map<String, Object> pmap=new HashMap<String,Object>();
        Yuyuezuowei yuyuezuowei = yuyuezuoweiService.findById(zuoweileixing.getId());
        pmap.put("yonghuming",yuyuezuowei.getYonghuming());
        pmap.put("xingming",yuyuezuowei.getXingming());
        pmap.put("shoujihao",yuyuezuowei.getShoujihao());
        List<UserInfo> yonghulist = userInfoService.getAll(pmap);;
        if(yonghulist.size()>0){
            UserInfo yonghu = yonghulist.get(0);
                yuyuezuowei.setIssh("签到");
                String quxiaoshijian = yuyuezuowei.getQuxiaoyuyueshijian();
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date qiandaoshijian = format.parse(zuoweileixing.getStartTime());
                Date bijiao = format.parse(quxiaoshijian);
                int compareTo = qiandaoshijian.compareTo(bijiao);
                if(compareTo == -1){

                }else {
                    yonghu.setJifen(yonghu.getJifen()-5);
                    userInfoService.update(yonghu);
                }
                yuyuezuowei.setQuxiaoyuyueshijian(format.format(new Date()));
                yuyuezuoweiService.update(yuyuezuowei);
        }
        Map<String,Object> ret = new HashMap<String,Object>();
        ret.put("code", 0);
        ret.put("msg", "签到成功");
        return ret;
    }
    @RequestMapping(value="/index/tuichi",method= RequestMethod.POST,produces = "application/json;charset=utf-8")
    @ResponseBody
    public Map<String,Object> tuichi(@RequestBody Zuoweileixing zuoweileixing) throws ParseException {
        Map<String, Object> pmap=new HashMap<String,Object>();
        Yuyuezuowei yuyuezuowei = yuyuezuoweiService.findById(zuoweileixing.getId());
        pmap.put("yonghuming",yuyuezuowei.getYonghuming());
        pmap.put("xingming",yuyuezuowei.getXingming());
        pmap.put("shoujihao",yuyuezuowei.getShoujihao());
        List<UserInfo> yonghulist = userInfoService.getAll(pmap);
        if(yonghulist.size()>0){
            UserInfo yonghu = yonghulist.get(0);
            String quxiaoshijian = yuyuezuowei.getQuxiaoyuyueshijian();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date bijiao = format.parse(quxiaoshijian);
            bijiao = new Date(bijiao.getTime()+15*60*1000);
            yuyuezuowei.setQuxiaoyuyueshijian(format.format(bijiao));
            yuyuezuoweiService.update(yuyuezuowei);
            yonghu.setJifen(yonghu.getJifen()-20);
            userInfoService.update(yonghu);
        }
        Map<String,Object> ret = new HashMap<String,Object>();
        ret.put("code", 0);
        ret.put("msg", "推迟成功");
        return ret;
    }
    @RequestMapping(value="/index/tuizuo",method= RequestMethod.POST,produces = "application/json;charset=utf-8")
    @ResponseBody
    public Map<String,Object> tuizuo(@RequestBody Zuoweileixing zuoweileixing) throws ParseException {
        Map<String, Object> pmap=new HashMap<String,Object>();
        Yuyuezuowei yuyuezuowei = yuyuezuoweiService.findById(zuoweileixing.getId());
        pmap.put("yonghuming",yuyuezuowei.getYonghuming());
        pmap.put("xingming",yuyuezuowei.getXingming());
        pmap.put("shoujihao",yuyuezuowei.getShoujihao());
        List<UserInfo> yonghulist = userInfoService.getAll(pmap);
        if(yonghulist.size()>0){
            UserInfo yonghu = yonghulist.get(0);
                String quxiaoshijian = yuyuezuowei.getQuxiaoyuyueshijian();
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date quxiao = format.parse(quxiaoshijian);
                Date tuizuoshijian = format.parse(zuoweileixing.getStartTime());
                int jifen = (int)((tuizuoshijian.getTime()-quxiao.getTime())/(1000 * 60 * 60));
                double hours = ((tuizuoshijian.getTime()-quxiao.getTime())/(1000 * 60 * 60));
                yuyuezuowei.setIssh("退座");
                yuyuezuoweiService.update(yuyuezuowei);
                yonghu.setJifen(yonghu.getJifen()+jifen);
                yonghu.setXuexizongshijian(yonghu.getXuexizongshijian()+hours);
                userInfoService.update(yonghu);
            }
        Map<String,Object> ret = new HashMap<String,Object>();
        ret.put("code", 0);
        ret.put("msg", "退座成功");
        return ret;
    }
    @RequestMapping(value="/index/myYuyue",method= RequestMethod.POST,produces = "application/json;charset=utf-8")
    @ResponseBody
    public Map<String,Object> myYuyue(@RequestBody Zuoweileixing zuoweileixing){
        Map<String, Object> pmap=new HashMap<String,Object>();
        pmap.put("userId",zuoweileixing.getUserId());
        UserInfo yonghu = userInfoService.findById(zuoweileixing.getUserId());
        pmap.put("yonghuming",yonghu.getYonghuming());
        pmap.put("starttime",zuoweileixing.getStartTime());
        List<Yuyuezuowei> myYuyue = yuyuezuoweiService.getAllMyYUyue(pmap);
        Map<String,Object> ret = new HashMap<String,Object>();
        ret.put("code", 0);
        ret.put("list", myYuyue);
        return ret;
    }
    @RequestMapping(value="/index/myAllYuyue",method= RequestMethod.POST,produces = "application/json;charset=utf-8")
    @ResponseBody
    public Map<String,Object> myAllYuyue(@RequestBody Zuoweileixing zuoweileixing){
        Map<String, Object> pmap=new HashMap<String,Object>();
        pmap.put("userId",zuoweileixing.getUserId());
        UserInfo yonghu = userInfoService.findById(zuoweileixing.getUserId());
        pmap.put("yonghuming",yonghu.getYonghuming());
        List<Yuyuezuowei> myYuyue = yuyuezuoweiService.getAllMyYUyueHis(pmap);
        Map<String,Object> ret = new HashMap<String,Object>();
        ret.put("code", 0);
        ret.put("list", myYuyue);
        return ret;
    }

}
