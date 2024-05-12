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


import com.dao.YinshidakaDao;
import com.entity.YinshidakaEntity;
import com.service.YinshidakaService;
import com.entity.vo.YinshidakaVO;
import com.entity.view.YinshidakaView;

@Service("yinshidakaService")
public class YinshidakaServiceImpl extends ServiceImpl<YinshidakaDao, YinshidakaEntity> implements YinshidakaService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YinshidakaEntity> page = this.selectPage(
                new Query<YinshidakaEntity>(params).getPage(),
                new EntityWrapper<YinshidakaEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YinshidakaEntity> wrapper) {
		  Page<YinshidakaView> page =new Query<YinshidakaView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<YinshidakaVO> selectListVO(Wrapper<YinshidakaEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YinshidakaVO selectVO(Wrapper<YinshidakaEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YinshidakaView> selectListView(Wrapper<YinshidakaEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YinshidakaView selectView(Wrapper<YinshidakaEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
