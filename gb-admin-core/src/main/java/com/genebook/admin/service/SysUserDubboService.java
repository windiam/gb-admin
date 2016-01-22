package com.genebook.admin.service;

import com.genebook.auth.dto.SysUserDTO;
/**
 * 后台管理员Service层
 * @description
 *
 * @author   wind
 * @version  [1.0, 2016年1月22日]
 * @see      [相关类/方法]
 * @since    [产品/模块版本]
 */
public interface SysUserDubboService {

	public SysUserDTO queryByUsername(String username);
}
