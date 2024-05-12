package com.dao;

import com.entity.YinshidakaEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.YinshidakaVO;
import com.entity.view.YinshidakaView;


/**
 * 饮食打卡
 * 
 * @author 
 * @email 
 * @date 2023-03-12 23:08:30
 */
public interface YinshidakaDao extends BaseMapper<YinshidakaEntity> {
	
	List<YinshidakaVO> selectListVO(@Param("ew") Wrapper<YinshidakaEntity> wrapper);
	
	YinshidakaVO selectVO(@Param("ew") Wrapper<YinshidakaEntity> wrapper);
	
	List<YinshidakaView> selectListView(@Param("ew") Wrapper<YinshidakaEntity> wrapper);

	List<YinshidakaView> selectListView(Pagination page,@Param("ew") Wrapper<YinshidakaEntity> wrapper);
	
	YinshidakaView selectView(@Param("ew") Wrapper<YinshidakaEntity> wrapper);
	

}
