package com.genebook.admin.controller;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.genebook.admin.service.SysUserDubboService;

/**
 * 
 * @description
 *
 * @author   wind
 * @version  [1.0, 2016年1月22日]
 * @see      [相关类/方法]
 * @since    [产品/模块版本]
 */
@Controller
public class IndexController {
	
    @Autowired  
    private RedisTemplate<Serializable, Serializable> redisTemplate;  
    
    @Autowired
    private SysUserDubboService sysUserDubboService;
	
	/**
	 * 进入登录页面
	 * <一句话功能简述>
	 * <功能详细描述>
	 * @return
	 * @see [类、类#方法、类#成员]
	 */
	@RequestMapping("login")
	public String login(){
		
		return "login";
	}
	
	/**
	 * 进入首页
	 * <一句话功能简述>
	 * <功能详细描述>
	 * @return
	 * @see [类、类#方法、类#成员]
	 */
	@RequestMapping("index")
//	@RequiresPermissions(value="index")
	public String index(){
//		redisTemplate.execute(new RedisCallback<Boolean>() {  
//            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {  
//                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();  
//                byte[] key  = serializer.serialize("username_1");  
//                byte[] name = serializer.serialize("admin");  
//                return connection.setNX(key, name);  
//            }  
//        });  
		String username = "admin";
		sysUserDubboService.queryByUsername(username);
		return "index";
	}
	
	@RequestMapping("index_layout")
	public String index_layout(){
		return "index_layout";
	}
}
