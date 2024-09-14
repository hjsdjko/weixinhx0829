package com.example.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "zuoweixinxi")
public class Zuoweixinxi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	private String leixing;
	private String zuoweihao;
	private String zhuangtai;

    private String louhao;
    private String fangjianhao;



    private String addtime;



    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
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
	public String getZhuangtai() {
        return zhuangtai;
    }
    public void setZhuangtai(String zhuangtai) {
        this.zhuangtai = zhuangtai == null ? null : zhuangtai.trim();
    }


    public String getLouhao() {
        return louhao;
    }

    public void setLouhao(String louhao) {
        this.louhao = louhao;
    }



    public String getFangjianhao() {
        return fangjianhao;
    }

    public void setFangjianhao(String fangjianhao) {
        this.fangjianhao = fangjianhao;
    }












    public String getAddtime() {
        return addtime;
    }
    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }
}
//   设置字段信息
