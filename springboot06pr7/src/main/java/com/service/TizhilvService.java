package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.TizhilvEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.TizhilvVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.TizhilvView;


/**
 * 体脂率
 *
 * @author 
 * @email 
 * @date 2023-03-12 23:08:30
 */
public interface TizhilvService extends IService<TizhilvEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<TizhilvVO> selectListVO(Wrapper<TizhilvEntity> wrapper);
   	
   	TizhilvVO selectVO(@Param("ew") Wrapper<TizhilvEntity> wrapper);
   	
   	List<TizhilvView> selectListView(Wrapper<TizhilvEntity> wrapper);
   	
   	TizhilvView selectView(@Param("ew") Wrapper<TizhilvEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<TizhilvEntity> wrapper);
   	

}

