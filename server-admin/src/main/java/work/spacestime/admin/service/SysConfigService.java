package work.spacestime.admin.service;

import java.util.List;

import work.spacestime.admin.model.SysConfig;
import work.spacestime.core.service.CurdService;

/**
 * 系统配置管理
 */
public interface SysConfigService extends CurdService<SysConfig> {

	/**
	 * 根据名称查询
	 * @param lable
	 * @return
	 */
	List<SysConfig> findByLable(String lable);
}
