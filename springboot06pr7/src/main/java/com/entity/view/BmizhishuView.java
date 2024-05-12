package com.entity.view;

import com.entity.BmizhishuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * bmi指数
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-03-12 23:08:31
 */
@TableName("bmizhishu")
public class BmizhishuView  extends BmizhishuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public BmizhishuView(){
	}
 
 	public BmizhishuView(BmizhishuEntity bmizhishuEntity){
 	try {
			BeanUtils.copyProperties(this, bmizhishuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
