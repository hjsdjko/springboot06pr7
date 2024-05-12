package com.entity.view;

import com.entity.TizhilvEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 体脂率
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-03-12 23:08:30
 */
@TableName("tizhilv")
public class TizhilvView  extends TizhilvEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public TizhilvView(){
	}
 
 	public TizhilvView(TizhilvEntity tizhilvEntity){
 	try {
			BeanUtils.copyProperties(this, tizhilvEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
