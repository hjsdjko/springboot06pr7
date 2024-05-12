package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YundongdakaEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.YundongdakaVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YundongdakaView;


/**
 * 运动打卡
 *
 * @author 
 * @email 
 * @date 2023-03-12 23:08:30
 */
public interface YundongdakaService extends IService<YundongdakaEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YundongdakaVO> selectListVO(Wrapper<YundongdakaEntity> wrapper);
   	
   	YundongdakaVO selectVO(@Param("ew") Wrapper<YundongdakaEntity> wrapper);
   	
   	List<YundongdakaView> selectListView(Wrapper<YundongdakaEntity> wrapper);
   	
   	YundongdakaView selectView(@Param("ew") Wrapper<YundongdakaEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YundongdakaEntity> wrapper);
   	

}

