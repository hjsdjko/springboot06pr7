package com.dao;

import com.entity.YundongdakaEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.YundongdakaVO;
import com.entity.view.YundongdakaView;


/**
 * 运动打卡
 * 
 * @author 
 * @email 
 * @date 2023-03-12 23:08:30
 */
public interface YundongdakaDao extends BaseMapper<YundongdakaEntity> {
	
	List<YundongdakaVO> selectListVO(@Param("ew") Wrapper<YundongdakaEntity> wrapper);
	
	YundongdakaVO selectVO(@Param("ew") Wrapper<YundongdakaEntity> wrapper);
	
	List<YundongdakaView> selectListView(@Param("ew") Wrapper<YundongdakaEntity> wrapper);

	List<YundongdakaView> selectListView(Pagination page,@Param("ew") Wrapper<YundongdakaEntity> wrapper);
	
	YundongdakaView selectView(@Param("ew") Wrapper<YundongdakaEntity> wrapper);
	

}
