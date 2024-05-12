package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 核酸检测点
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2023-03-12 23:08:30
 */
@TableName("hesuanjiancedian")
public class HesuanjiancedianEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public HesuanjiancedianEntity() {
		
	}
	
	public HesuanjiancedianEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 检测点名称
	 */
					
	private String jiancedianmingcheng;
	
	/**
	 * 检测点位置
	 */
					
	private String jiancedianweizhi;
	
	/**
	 * 可预约时段
	 */
					
	private String keyuyueshiduan;
	
	/**
	 * 封面图片
	 */
					
	private String fengmiantupian;
	
	/**
	 * 检测费用
	 */
					
	private Float jiancefeiyong;
	
	/**
	 * 负责人
	 */
					
	private String fuzeren;
	
	/**
	 * 联系电话
	 */
					
	private String lianxidianhua;
	
	/**
	 * 详情
	 */
					
	private String xiangqing;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：检测点名称
	 */
	public void setJiancedianmingcheng(String jiancedianmingcheng) {
		this.jiancedianmingcheng = jiancedianmingcheng;
	}
	/**
	 * 获取：检测点名称
	 */
	public String getJiancedianmingcheng() {
		return jiancedianmingcheng;
	}
	/**
	 * 设置：检测点位置
	 */
	public void setJiancedianweizhi(String jiancedianweizhi) {
		this.jiancedianweizhi = jiancedianweizhi;
	}
	/**
	 * 获取：检测点位置
	 */
	public String getJiancedianweizhi() {
		return jiancedianweizhi;
	}
	/**
	 * 设置：可预约时段
	 */
	public void setKeyuyueshiduan(String keyuyueshiduan) {
		this.keyuyueshiduan = keyuyueshiduan;
	}
	/**
	 * 获取：可预约时段
	 */
	public String getKeyuyueshiduan() {
		return keyuyueshiduan;
	}
	/**
	 * 设置：封面图片
	 */
	public void setFengmiantupian(String fengmiantupian) {
		this.fengmiantupian = fengmiantupian;
	}
	/**
	 * 获取：封面图片
	 */
	public String getFengmiantupian() {
		return fengmiantupian;
	}
	/**
	 * 设置：检测费用
	 */
	public void setJiancefeiyong(Float jiancefeiyong) {
		this.jiancefeiyong = jiancefeiyong;
	}
	/**
	 * 获取：检测费用
	 */
	public Float getJiancefeiyong() {
		return jiancefeiyong;
	}
	/**
	 * 设置：负责人
	 */
	public void setFuzeren(String fuzeren) {
		this.fuzeren = fuzeren;
	}
	/**
	 * 获取：负责人
	 */
	public String getFuzeren() {
		return fuzeren;
	}
	/**
	 * 设置：联系电话
	 */
	public void setLianxidianhua(String lianxidianhua) {
		this.lianxidianhua = lianxidianhua;
	}
	/**
	 * 获取：联系电话
	 */
	public String getLianxidianhua() {
		return lianxidianhua;
	}
	/**
	 * 设置：详情
	 */
	public void setXiangqing(String xiangqing) {
		this.xiangqing = xiangqing;
	}
	/**
	 * 获取：详情
	 */
	public String getXiangqing() {
		return xiangqing;
	}

}
