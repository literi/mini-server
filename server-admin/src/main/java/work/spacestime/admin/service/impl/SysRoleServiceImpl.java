package work.spacestime.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import work.spacestime.admin.constant.SysConstants;
import work.spacestime.admin.dao.SysMenuMapper;
import work.spacestime.admin.dao.SysRoleMapper;
import work.spacestime.admin.dao.SysRoleMenuMapper;
import work.spacestime.admin.model.SysMenu;
import work.spacestime.admin.model.SysRole;
import work.spacestime.admin.model.SysRoleMenu;
import work.spacestime.admin.service.SysRoleService;
import work.spacestime.core.page.MybatisPageHelper;
import work.spacestime.core.page.PageRequest;
import work.spacestime.core.page.PageResult;

@Service
public class SysRoleServiceImpl  implements SysRoleService {

	@Autowired
	private SysRoleMapper sysRoleMapper;
	@Autowired
	private SysRoleMenuMapper sysRoleMenuMapper;
	@Autowired
	private SysMenuMapper sysMenuMapper;

	@Override
	public int save(SysRole record) {
		if(record.getId() == null || record.getId() == 0) {
			return sysRoleMapper.insertSelective(record);
		}
		return sysRoleMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int delete(SysRole record) {
		return sysRoleMapper.deleteByPrimaryKey(record.getId());
	}

	@Override
	public int delete(List<SysRole> records) {
		for(SysRole record:records) {
			delete(record);
		}
		return 1;
	}

	@Override
	public SysRole findById(Long id) {
		return sysRoleMapper.selectByPrimaryKey(id);
	}

	@Override
	public PageResult findPage(PageRequest pageRequest) {
		Object label = pageRequest.getParamValue("name");
		if(label != null) {
			return MybatisPageHelper.findPage(pageRequest, sysRoleMapper, "findPageByName", label);
		}
		return MybatisPageHelper.findPage(pageRequest, sysRoleMapper);
	}

	@Override
	public List<SysRole> findAll() {
		return sysRoleMapper.findAll();
	}

	public SysRoleMapper getSysRoleMapper() {
		return sysRoleMapper;
	}

	public void setSysRoleMapper(SysRoleMapper sysRoleMapper) {
		this.sysRoleMapper = sysRoleMapper;
	}

	@Override
	public List<SysMenu> findRoleMenus(Long roleId) {
		SysRole sysRole = sysRoleMapper.selectByPrimaryKey(roleId);
		if(SysConstants.ADMIN.equalsIgnoreCase(sysRole.getName())) {
			// 如果是超级管理员，返回全部
			return sysMenuMapper.findAll();
		}
		return sysMenuMapper.findRoleMenus(roleId);
	}

	@Transactional
	@Override
	public int saveRoleMenus(List<SysRoleMenu> records) {
		if(records == null || records.isEmpty()) {
			return 1;
		}
		Long roleId = records.get(0).getRoleId(); 
		sysRoleMenuMapper.deleteByRoleId(roleId);
		for(SysRoleMenu record:records) {
			sysRoleMenuMapper.insertSelective(record);
		}
		return 1;
	}

	@Override
	public List<SysRole> findByName(String name) {
		return sysRoleMapper.findByName(name);
	}
	
}
