package com.entity.view;

import com.entity.XiuxidakaEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 休息打卡
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-03-12 23:08:30
 */
@TableName("xiuxidaka")
public class XiuxidakaView  extends XiuxidakaEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public XiuxidakaView(){
	}
 
 	public XiuxidakaView(XiuxidakaEntity xiuxidakaEntity){
 	try {
			BeanUtils.copyProperties(this, xiuxidakaEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
