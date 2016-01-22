package com.genebook.admin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.genebook.admin.params.LoginParams;
import com.genebook.admin.utils.MyRealm.ShiroUser;

/**
 * 后台管理员控制层
 * @description
 *
 * @author   wind
 * @version  [1.0, 2016年1月22日]
 * @see      [相关类/方法]
 * @since    [产品/模块版本]
 */
@Controller
public class AdminController {

	/**
	 * 登录
	 * <一句话功能简述>
	 * <功能详细描述>
	 * @param params
	 * @param request
	 * @return
	 * @see [类、类#方法、类#成员]
	 */
	@RequestMapping("checkin")
	public String checkin(LoginParams params, HttpServletRequest request){
		String username = params.getUsername();
		String password = params.getPassword();
		/*用户安全*/
		AuthenticationToken token = new UsernamePasswordToken(username, password);
        Subject currentUser = SecurityUtils.getSubject(); 
        
        try{
        	currentUser.login(token);
        	ShiroUser user = (ShiroUser)currentUser.getPrincipal();
        	HttpSession session = request.getSession();
        	session.setAttribute("loginAdmin", user);
        }catch(Exception e){
        	e.printStackTrace();
        }
        return "redirect:/index.html";
	}
}
