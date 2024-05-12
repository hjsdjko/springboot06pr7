package com.entity.view;

import com.entity.YinshidakaEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 饮食打卡
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-03-12 23:08:30
 */
@TableName("yinshidaka")
public class YinshidakaView  extends YinshidakaEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public YinshidakaView(){
	}
 
 	public YinshidakaView(YinshidakaEntity yinshidakaEntity){
 	try {
			BeanUtils.copyProperties(this, yinshidakaEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
