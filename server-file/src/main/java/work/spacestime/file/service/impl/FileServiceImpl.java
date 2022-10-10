package work.spacestime.file.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import work.spacestime.core.page.MybatisPageHelper;
import work.spacestime.core.page.PageRequest;
import work.spacestime.core.page.PageResult;
import work.spacestime.file.dao.SysFileMapper;
import work.spacestime.file.model.SysFile;
import work.spacestime.file.service.FileService;


@Service
public class FileServiceImpl implements FileService{
	
	@Autowired
	private SysFileMapper mapper;

	@Override
	public int deleteByPrimaryKey(Long id) {
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(SysFile record) {
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(SysFile record) {
		return mapper.insertSelective(record);
	}

	@Override
	public SysFile selectByPrimaryKey(Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(SysFile record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKeyWithBLOBs(SysFile record) {
		return mapper.updateByPrimaryKeyWithBLOBs(record);
	}

	@Override
	public int updateByPrimaryKey(SysFile record) {
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public PageResult findPage(PageRequest pageRequest) {
		return MybatisPageHelper.findPage(pageRequest, mapper);
	}
	


}
