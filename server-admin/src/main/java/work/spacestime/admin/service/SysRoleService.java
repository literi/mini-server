package work.spacestime.admin.service;

import java.util.List;

import work.spacestime.admin.model.SysMenu;
import work.spacestime.admin.model.SysRole;
import work.spacestime.admin.model.SysRoleMenu;
import work.spacestime.core.service.CurdService;

/**
 * 角色管理
 */
public interface SysRoleService extends CurdService<SysRole> {

	/**
	 * 查询全部
	 * @return
	 */
	List<SysRole> findAll();

	/**
	 * 查询角色菜单集合
	 * @return
	 */
	List<SysMenu> findRoleMenus(Long roleId);

	/**
	 * 保存角色菜单
	 * @param records
	 * @return
	 */
	int saveRoleMenus(List<SysRoleMenu> records);

	/**
	 * 根据名称查询
	 * @param name
	 * @return
	 */
	List<SysRole> findByName(String name);

}
