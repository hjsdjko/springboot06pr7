package com.dao;

import com.entity.YihuanjiaoliuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.YihuanjiaoliuVO;
import com.entity.view.YihuanjiaoliuView;


/**
 * 医患交流
 * 
 * @author 
 * @email 
 * @date 2023-03-12 23:08:30
 */
public interface YihuanjiaoliuDao extends BaseMapper<YihuanjiaoliuEntity> {
	
	List<YihuanjiaoliuVO> selectListVO(@Param("ew") Wrapper<YihuanjiaoliuEntity> wrapper);
	
	YihuanjiaoliuVO selectVO(@Param("ew") Wrapper<YihuanjiaoliuEntity> wrapper);
	
	List<YihuanjiaoliuView> selectListView(@Param("ew") Wrapper<YihuanjiaoliuEntity> wrapper);

	List<YihuanjiaoliuView> selectListView(Pagination page,@Param("ew") Wrapper<YihuanjiaoliuEntity> wrapper);
	
	YihuanjiaoliuView selectView(@Param("ew") Wrapper<YihuanjiaoliuEntity> wrapper);
	

}
