package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.XiuxidakaEntity;
import com.entity.view.XiuxidakaView;

import com.service.XiuxidakaService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 休息打卡
 * 后端接口
 * @author 
 * @email 
 * @date 2023-03-12 23:08:30
 */
@RestController
@RequestMapping("/xiuxidaka")
public class XiuxidakaController {
    @Autowired
    private XiuxidakaService xiuxidakaService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,XiuxidakaEntity xiuxidaka,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			xiuxidaka.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<XiuxidakaEntity> ew = new EntityWrapper<XiuxidakaEntity>();

		PageUtils page = xiuxidakaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xiuxidaka), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,XiuxidakaEntity xiuxidaka, 
		HttpServletRequest request){
        EntityWrapper<XiuxidakaEntity> ew = new EntityWrapper<XiuxidakaEntity>();

		PageUtils page = xiuxidakaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xiuxidaka), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( XiuxidakaEntity xiuxidaka){
       	EntityWrapper<XiuxidakaEntity> ew = new EntityWrapper<XiuxidakaEntity>();
      	ew.allEq(MPUtil.allEQMapPre( xiuxidaka, "xiuxidaka")); 
        return R.ok().put("data", xiuxidakaService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(XiuxidakaEntity xiuxidaka){
        EntityWrapper< XiuxidakaEntity> ew = new EntityWrapper< XiuxidakaEntity>();
 		ew.allEq(MPUtil.allEQMapPre( xiuxidaka, "xiuxidaka")); 
		XiuxidakaView xiuxidakaView =  xiuxidakaService.selectView(ew);
		return R.ok("查询休息打卡成功").put("data", xiuxidakaView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        XiuxidakaEntity xiuxidaka = xiuxidakaService.selectById(id);
        return R.ok().put("data", xiuxidaka);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        XiuxidakaEntity xiuxidaka = xiuxidakaService.selectById(id);
        return R.ok().put("data", xiuxidaka);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody XiuxidakaEntity xiuxidaka, HttpServletRequest request){
    	xiuxidaka.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xiuxidaka);
        xiuxidakaService.insert(xiuxidaka);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody XiuxidakaEntity xiuxidaka, HttpServletRequest request){
    	xiuxidaka.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xiuxidaka);
        xiuxidakaService.insert(xiuxidaka);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody XiuxidakaEntity xiuxidaka, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xiuxidaka);
        xiuxidakaService.updateById(xiuxidaka);//全部更新
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        xiuxidakaService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<XiuxidakaEntity> wrapper = new EntityWrapper<XiuxidakaEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			wrapper.eq("yonghuzhanghao", (String)request.getSession().getAttribute("username"));
		}

		int count = xiuxidakaService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	









}
