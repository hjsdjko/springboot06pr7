package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YinshidakaEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.YinshidakaVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YinshidakaView;


/**
 * 饮食打卡
 *
 * @author 
 * @email 
 * @date 2023-03-12 23:08:30
 */
public interface YinshidakaService extends IService<YinshidakaEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YinshidakaVO> selectListVO(Wrapper<YinshidakaEntity> wrapper);
   	
   	YinshidakaVO selectVO(@Param("ew") Wrapper<YinshidakaEntity> wrapper);
   	
   	List<YinshidakaView> selectListView(Wrapper<YinshidakaEntity> wrapper);
   	
   	YinshidakaView selectView(@Param("ew") Wrapper<YinshidakaEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YinshidakaEntity> wrapper);
   	

}

