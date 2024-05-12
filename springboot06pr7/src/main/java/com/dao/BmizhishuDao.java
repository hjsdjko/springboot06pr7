package com.dao;

import com.entity.BmizhishuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.BmizhishuVO;
import com.entity.view.BmizhishuView;


/**
 * bmi指数
 * 
 * @author 
 * @email 
 * @date 2023-03-12 23:08:31
 */
public interface BmizhishuDao extends BaseMapper<BmizhishuEntity> {
	
	List<BmizhishuVO> selectListVO(@Param("ew") Wrapper<BmizhishuEntity> wrapper);
	
	BmizhishuVO selectVO(@Param("ew") Wrapper<BmizhishuEntity> wrapper);
	
	List<BmizhishuView> selectListView(@Param("ew") Wrapper<BmizhishuEntity> wrapper);

	List<BmizhishuView> selectListView(Pagination page,@Param("ew") Wrapper<BmizhishuEntity> wrapper);
	
	BmizhishuView selectView(@Param("ew") Wrapper<BmizhishuEntity> wrapper);
	

}
