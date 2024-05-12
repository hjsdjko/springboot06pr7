package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YihuanjiaoliuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.YihuanjiaoliuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YihuanjiaoliuView;


/**
 * 医患交流
 *
 * @author 
 * @email 
 * @date 2023-03-12 23:08:30
 */
public interface YihuanjiaoliuService extends IService<YihuanjiaoliuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YihuanjiaoliuVO> selectListVO(Wrapper<YihuanjiaoliuEntity> wrapper);
   	
   	YihuanjiaoliuVO selectVO(@Param("ew") Wrapper<YihuanjiaoliuEntity> wrapper);
   	
   	List<YihuanjiaoliuView> selectListView(Wrapper<YihuanjiaoliuEntity> wrapper);
   	
   	YihuanjiaoliuView selectView(@Param("ew") Wrapper<YihuanjiaoliuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YihuanjiaoliuEntity> wrapper);
   	

}

