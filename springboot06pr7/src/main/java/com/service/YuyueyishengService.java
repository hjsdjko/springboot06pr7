package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YuyueyishengEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.YuyueyishengVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YuyueyishengView;


/**
 * 预约医生
 *
 * @author 
 * @email 
 * @date 2023-03-12 23:08:30
 */
public interface YuyueyishengService extends IService<YuyueyishengEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YuyueyishengVO> selectListVO(Wrapper<YuyueyishengEntity> wrapper);
   	
   	YuyueyishengVO selectVO(@Param("ew") Wrapper<YuyueyishengEntity> wrapper);
   	
   	List<YuyueyishengView> selectListView(Wrapper<YuyueyishengEntity> wrapper);
   	
   	YuyueyishengView selectView(@Param("ew") Wrapper<YuyueyishengEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YuyueyishengEntity> wrapper);
   	

}

