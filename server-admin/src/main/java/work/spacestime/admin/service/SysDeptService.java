package work.spacestime.admin.service;

import java.util.List;

import work.spacestime.admin.model.SysDept;
import work.spacestime.core.service.CurdService;

/**
 * 机构管理
 */
public interface SysDeptService extends CurdService<SysDept> {

	/**
	 * 查询机构树
	 * @param userId 
	 * @return
	 */
	List<SysDept> findTree();
}
