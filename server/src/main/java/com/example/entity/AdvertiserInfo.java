package com.example.entity;

import javax.persistence.*;
import java.util.List;

@Table(name = "advertiser_info")
public class AdvertiserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column(name = "name")
	private String name;
	@Column(name = "content")
	private String content;
	@Column(name = "time")
	private String time;
	@Column(name = "description")
	private String description;
	@Transient
	private List<Long> fileList;

	@Column(name = "fileIds")
	private String fileIds;

	public List<Long> getFileList() {
		return fileList;
	}

	public void setFileList(List<Long> fileList) {
		this.fileList = fileList;
	}

	public String getFileIds() {
		return fileIds;
	}

	public void setFileIds(String fileIds) {
		this.fileIds = fileIds;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return this.id;
    }

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
