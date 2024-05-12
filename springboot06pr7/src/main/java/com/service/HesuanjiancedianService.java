package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.HesuanjiancedianEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.HesuanjiancedianVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.HesuanjiancedianView;


/**
 * 核酸检测点
 *
 * @author 
 * @email 
 * @date 2023-03-12 23:08:30
 */
public interface HesuanjiancedianService extends IService<HesuanjiancedianEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<HesuanjiancedianVO> selectListVO(Wrapper<HesuanjiancedianEntity> wrapper);
   	
   	HesuanjiancedianVO selectVO(@Param("ew") Wrapper<HesuanjiancedianEntity> wrapper);
   	
   	List<HesuanjiancedianView> selectListView(Wrapper<HesuanjiancedianEntity> wrapper);
   	
   	HesuanjiancedianView selectView(@Param("ew") Wrapper<HesuanjiancedianEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<HesuanjiancedianEntity> wrapper);
   	

}

