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


import com.dao.YihuanjiaoliuDao;
import com.entity.YihuanjiaoliuEntity;
import com.service.YihuanjiaoliuService;
import com.entity.vo.YihuanjiaoliuVO;
import com.entity.view.YihuanjiaoliuView;

@Service("yihuanjiaoliuService")
public class YihuanjiaoliuServiceImpl extends ServiceImpl<YihuanjiaoliuDao, YihuanjiaoliuEntity> implements YihuanjiaoliuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YihuanjiaoliuEntity> page = this.selectPage(
                new Query<YihuanjiaoliuEntity>(params).getPage(),
                new EntityWrapper<YihuanjiaoliuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YihuanjiaoliuEntity> wrapper) {
		  Page<YihuanjiaoliuView> page =new Query<YihuanjiaoliuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<YihuanjiaoliuVO> selectListVO(Wrapper<YihuanjiaoliuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YihuanjiaoliuVO selectVO(Wrapper<YihuanjiaoliuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YihuanjiaoliuView> selectListView(Wrapper<YihuanjiaoliuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YihuanjiaoliuView selectView(Wrapper<YihuanjiaoliuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
