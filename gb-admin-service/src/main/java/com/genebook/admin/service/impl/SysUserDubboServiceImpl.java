package com.genebook.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.genebook.admin.service.SysUserDubboService;
import com.genebook.auth.dto.SysUserDTO;
import com.genebook.auth.service.SysUserService;

@Service
public class SysUserDubboServiceImpl implements SysUserDubboService{

	@Autowired
	private SysUserService sysUserService;

	@Override
	public SysUserDTO queryByUsername(String username) {
		return sysUserService.queryByUsername(username);
	}
}
