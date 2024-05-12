package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.XiuxidakaEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.XiuxidakaVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.XiuxidakaView;


/**
 * 休息打卡
 *
 * @author 
 * @email 
 * @date 2023-03-12 23:08:30
 */
public interface XiuxidakaService extends IService<XiuxidakaEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XiuxidakaVO> selectListVO(Wrapper<XiuxidakaEntity> wrapper);
   	
   	XiuxidakaVO selectVO(@Param("ew") Wrapper<XiuxidakaEntity> wrapper);
   	
   	List<XiuxidakaView> selectListView(Wrapper<XiuxidakaEntity> wrapper);
   	
   	XiuxidakaView selectView(@Param("ew") Wrapper<XiuxidakaEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XiuxidakaEntity> wrapper);
   	

}

