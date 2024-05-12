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


import com.dao.BmizhishuDao;
import com.entity.BmizhishuEntity;
import com.service.BmizhishuService;
import com.entity.vo.BmizhishuVO;
import com.entity.view.BmizhishuView;

@Service("bmizhishuService")
public class BmizhishuServiceImpl extends ServiceImpl<BmizhishuDao, BmizhishuEntity> implements BmizhishuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<BmizhishuEntity> page = this.selectPage(
                new Query<BmizhishuEntity>(params).getPage(),
                new EntityWrapper<BmizhishuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<BmizhishuEntity> wrapper) {
		  Page<BmizhishuView> page =new Query<BmizhishuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<BmizhishuVO> selectListVO(Wrapper<BmizhishuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public BmizhishuVO selectVO(Wrapper<BmizhishuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<BmizhishuView> selectListView(Wrapper<BmizhishuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public BmizhishuView selectView(Wrapper<BmizhishuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
