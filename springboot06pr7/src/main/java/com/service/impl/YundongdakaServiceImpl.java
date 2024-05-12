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


import com.dao.YundongdakaDao;
import com.entity.YundongdakaEntity;
import com.service.YundongdakaService;
import com.entity.vo.YundongdakaVO;
import com.entity.view.YundongdakaView;

@Service("yundongdakaService")
public class YundongdakaServiceImpl extends ServiceImpl<YundongdakaDao, YundongdakaEntity> implements YundongdakaService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YundongdakaEntity> page = this.selectPage(
                new Query<YundongdakaEntity>(params).getPage(),
                new EntityWrapper<YundongdakaEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YundongdakaEntity> wrapper) {
		  Page<YundongdakaView> page =new Query<YundongdakaView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<YundongdakaVO> selectListVO(Wrapper<YundongdakaEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YundongdakaVO selectVO(Wrapper<YundongdakaEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YundongdakaView> selectListView(Wrapper<YundongdakaEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YundongdakaView selectView(Wrapper<YundongdakaEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
