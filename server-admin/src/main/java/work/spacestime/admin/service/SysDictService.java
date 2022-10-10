package work.spacestime.admin.service;

import java.util.List;

import work.spacestime.admin.model.SysDict;
import work.spacestime.core.service.CurdService;

/**
 * 字典管理
 */
public interface SysDictService extends CurdService<SysDict> {

	/**
	 * 根据名称查询
	 * @param lable
	 * @return
	 */
	List<SysDict> findByLable(String lable);
}
