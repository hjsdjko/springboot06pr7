package com.entity.vo;

import com.entity.HesuanjiancedianEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 核酸检测点
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2023-03-12 23:08:30
 */
public class HesuanjiancedianVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
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
