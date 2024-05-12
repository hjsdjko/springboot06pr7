package com.dao;

import com.entity.TizhilvEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.TizhilvVO;
import com.entity.view.TizhilvView;


/**
 * 体脂率
 * 
 * @author 
 * @email 
 * @date 2023-03-12 23:08:30
 */
public interface TizhilvDao extends BaseMapper<TizhilvEntity> {
	
	List<TizhilvVO> selectListVO(@Param("ew") Wrapper<TizhilvEntity> wrapper);
	
	TizhilvVO selectVO(@Param("ew") Wrapper<TizhilvEntity> wrapper);
	
	List<TizhilvView> selectListView(@Param("ew") Wrapper<TizhilvEntity> wrapper);

	List<TizhilvView> selectListView(Pagination page,@Param("ew") Wrapper<TizhilvEntity> wrapper);
	
	TizhilvView selectView(@Param("ew") Wrapper<TizhilvEntity> wrapper);
	

}
