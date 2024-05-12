package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.BmizhishuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.BmizhishuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.BmizhishuView;


/**
 * bmi指数
 *
 * @author 
 * @email 
 * @date 2023-03-12 23:08:31
 */
public interface BmizhishuService extends IService<BmizhishuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<BmizhishuVO> selectListVO(Wrapper<BmizhishuEntity> wrapper);
   	
   	BmizhishuVO selectVO(@Param("ew") Wrapper<BmizhishuEntity> wrapper);
   	
   	List<BmizhishuView> selectListView(Wrapper<BmizhishuEntity> wrapper);
   	
   	BmizhishuView selectView(@Param("ew") Wrapper<BmizhishuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<BmizhishuEntity> wrapper);
   	

}

