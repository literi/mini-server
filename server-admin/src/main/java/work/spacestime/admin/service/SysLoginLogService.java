package work.spacestime.admin.service;

import work.spacestime.admin.model.SysLoginLog;
import work.spacestime.core.service.CurdService;

/**
 * 登录日志
 */
public interface SysLoginLogService extends CurdService<SysLoginLog> {

	/**
	 * 记录登录日志
	 * @param userName
	 * @param ip
	 * @return
	 */
	int writeLoginLog(String userName, String ip);
}
