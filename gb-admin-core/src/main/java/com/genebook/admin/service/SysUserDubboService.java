package com.genebook.admin.service;

import com.genebook.auth.dto.SysUserDTO;

public interface SysUserDubboService {

	public SysUserDTO queryByUsername(String username);
}
