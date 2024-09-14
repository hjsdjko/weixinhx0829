package com.example.entity;

import javax.persistence.*;

@Table(name = "yuyuezuowei")
public class Yuyuezuowei {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private String yuyuehao;
	private String leixing;
	private String zuoweihao;
	private String yuyueshijian;
	private String yonghuming;
	private String xingming;
	private String shoujihao;
	private String quxiaoyuyueshijian;
	private String issh;
	private String shhf;

    private String addtime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getYuyuehao() {
        return yuyuehao;
    }
    public void setYuyuehao(String yuyuehao) {
        this.yuyuehao = yuyuehao == null ? null : yuyuehao.trim();
    }
	public String getLeixing() {
        return leixing;
    }
    public void setLeixing(String leixing) {
        this.leixing = leixing == null ? null : leixing.trim();
    }
	public String getZuoweihao() {
        return zuoweihao;
    }
    public void setZuoweihao(String zuoweihao) {
        this.zuoweihao = zuoweihao == null ? null : zuoweihao.trim();
    }
	public String getYuyueshijian() {
        return yuyueshijian;
    }
    public void setYuyueshijian(String yuyueshijian) {
        this.yuyueshijian = yuyueshijian == null ? null : yuyueshijian.trim();
    }
	public String getYonghuming() {
        return yonghuming;
    }
    public void setYonghuming(String yonghuming) {
        this.yonghuming = yonghuming == null ? null : yonghuming.trim();
    }
	public String getXingming() {
        return xingming;
    }
    public void setXingming(String xingming) {
        this.xingming = xingming == null ? null : xingming.trim();
    }
	public String getShoujihao() {
        return shoujihao;
    }
    public void setShoujihao(String shoujihao) {
        this.shoujihao = shoujihao == null ? null : shoujihao.trim();
    }
	public String getQuxiaoyuyueshijian() {
        return quxiaoyuyueshijian;
    }
    public void setQuxiaoyuyueshijian(String quxiaoyuyueshijian) {
        this.quxiaoyuyueshijian = quxiaoyuyueshijian == null ? null : quxiaoyuyueshijian.trim();
    }
	public String getIssh() {
        return issh;
    }
    public void setIssh(String issh) {
        this.issh = issh == null ? null : issh.trim();
    }
	public String getShhf() {
        return shhf;
    }
    public void setShhf(String shhf) {
        this.shhf = shhf == null ? null : shhf.trim();
    }



    public String getAddtime() {
        return addtime;
    }
    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }
}
//   设置字段信息
