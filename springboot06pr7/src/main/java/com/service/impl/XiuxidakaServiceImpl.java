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


import com.dao.XiuxidakaDao;
import com.entity.XiuxidakaEntity;
import com.service.XiuxidakaService;
import com.entity.vo.XiuxidakaVO;
import com.entity.view.XiuxidakaView;

@Service("xiuxidakaService")
public class XiuxidakaServiceImpl extends ServiceImpl<XiuxidakaDao, XiuxidakaEntity> implements XiuxidakaService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XiuxidakaEntity> page = this.selectPage(
                new Query<XiuxidakaEntity>(params).getPage(),
                new EntityWrapper<XiuxidakaEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XiuxidakaEntity> wrapper) {
		  Page<XiuxidakaView> page =new Query<XiuxidakaView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<XiuxidakaVO> selectListVO(Wrapper<XiuxidakaEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public XiuxidakaVO selectVO(Wrapper<XiuxidakaEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<XiuxidakaView> selectListView(Wrapper<XiuxidakaEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XiuxidakaView selectView(Wrapper<XiuxidakaEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
