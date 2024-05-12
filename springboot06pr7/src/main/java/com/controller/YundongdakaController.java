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

import com.entity.YundongdakaEntity;
import com.entity.view.YundongdakaView;

import com.service.YundongdakaService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 运动打卡
 * 后端接口
 * @author 
 * @email 
 * @date 2023-03-12 23:08:30
 */
@RestController
@RequestMapping("/yundongdaka")
public class YundongdakaController {
    @Autowired
    private YundongdakaService yundongdakaService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YundongdakaEntity yundongdaka,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			yundongdaka.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<YundongdakaEntity> ew = new EntityWrapper<YundongdakaEntity>();

		PageUtils page = yundongdakaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yundongdaka), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YundongdakaEntity yundongdaka, 
		HttpServletRequest request){
        EntityWrapper<YundongdakaEntity> ew = new EntityWrapper<YundongdakaEntity>();

		PageUtils page = yundongdakaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yundongdaka), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YundongdakaEntity yundongdaka){
       	EntityWrapper<YundongdakaEntity> ew = new EntityWrapper<YundongdakaEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yundongdaka, "yundongdaka")); 
        return R.ok().put("data", yundongdakaService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YundongdakaEntity yundongdaka){
        EntityWrapper< YundongdakaEntity> ew = new EntityWrapper< YundongdakaEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yundongdaka, "yundongdaka")); 
		YundongdakaView yundongdakaView =  yundongdakaService.selectView(ew);
		return R.ok("查询运动打卡成功").put("data", yundongdakaView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YundongdakaEntity yundongdaka = yundongdakaService.selectById(id);
        return R.ok().put("data", yundongdaka);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YundongdakaEntity yundongdaka = yundongdakaService.selectById(id);
        return R.ok().put("data", yundongdaka);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YundongdakaEntity yundongdaka, HttpServletRequest request){
    	yundongdaka.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yundongdaka);
        yundongdakaService.insert(yundongdaka);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YundongdakaEntity yundongdaka, HttpServletRequest request){
    	yundongdaka.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yundongdaka);
        yundongdakaService.insert(yundongdaka);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody YundongdakaEntity yundongdaka, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yundongdaka);
        yundongdakaService.updateById(yundongdaka);//全部更新
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yundongdakaService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<YundongdakaEntity> wrapper = new EntityWrapper<YundongdakaEntity>();
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

		int count = yundongdakaService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	









}
