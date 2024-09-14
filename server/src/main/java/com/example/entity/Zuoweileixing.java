package com.example.entity;

import org.omg.PortableInterceptor.INACTIVE;

import javax.persistence.*;

@Table(name = "zuoweileixing")
public class Zuoweileixing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private String leixing;

    private String addtime;

    @Transient
    private Long userId;
    @Transient
    private String startTime;

    private Integer pai;
    private Integer lie;

    public Integer getPai() {
        return pai;
    }

    public void setPai(Integer pai) {
        this.pai = pai;
    }

    public Integer getLie() {
        return lie;
    }

    public void setLie(Integer lie) {
        this.lie = lie;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLeixing() {
        return leixing;
    }
    public void setLeixing(String leixing) {
        this.leixing = leixing == null ? null : leixing.trim();
    }



    public String getAddtime() {
        return addtime;
    }
    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }
}
//   设置字段信息
