package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.TizhilvDao;
import com.entity.TizhilvEntity;
import com.service.TizhilvService;
import com.entity.vo.TizhilvVO;
import com.entity.view.TizhilvView;

@Service("tizhilvService")
public class TizhilvServiceImpl extends ServiceImpl<TizhilvDao, TizhilvEntity> implements TizhilvService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<TizhilvEntity> page = this.selectPage(
                new Query<TizhilvEntity>(params).getPage(),
                new EntityWrapper<TizhilvEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<TizhilvEntity> wrapper) {
		  Page<TizhilvView> page =new Query<TizhilvView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<TizhilvVO> selectListVO(Wrapper<TizhilvEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public TizhilvVO selectVO(Wrapper<TizhilvEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<TizhilvView> selectListView(Wrapper<TizhilvEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public TizhilvView selectView(Wrapper<TizhilvEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
