package com.dao;

import com.entity.XiuxidakaEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.XiuxidakaVO;
import com.entity.view.XiuxidakaView;


/**
 * 休息打卡
 * 
 * @author 
 * @email 
 * @date 2023-03-12 23:08:30
 */
public interface XiuxidakaDao extends BaseMapper<XiuxidakaEntity> {
	
	List<XiuxidakaVO> selectListVO(@Param("ew") Wrapper<XiuxidakaEntity> wrapper);
	
	XiuxidakaVO selectVO(@Param("ew") Wrapper<XiuxidakaEntity> wrapper);
	
	List<XiuxidakaView> selectListView(@Param("ew") Wrapper<XiuxidakaEntity> wrapper);

	List<XiuxidakaView> selectListView(Pagination page,@Param("ew") Wrapper<XiuxidakaEntity> wrapper);
	
	XiuxidakaView selectView(@Param("ew") Wrapper<XiuxidakaEntity> wrapper);
	

}
