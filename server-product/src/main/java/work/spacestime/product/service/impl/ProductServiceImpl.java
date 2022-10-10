package work.spacestime.product.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import work.spacestime.core.page.MybatisPageHelper;
import work.spacestime.core.page.PageRequest;
import work.spacestime.core.page.PageResult;
import work.spacestime.product.dao.SysProductMapper;
import work.spacestime.product.model.SysProduct;
import work.spacestime.product.service.ProductService;
import work.spacestime.utils.StringUtils;


@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private SysProductMapper mapper;

	@Override
	public int deleteByPrimaryKey(Long id) {
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	public SysProduct insert(SysProduct record) {
		try {
			mapper.insert(record);
		} catch (Exception e) {
			return null;
		}
		return record;
	}

	@Override
	public int insertSelective(SysProduct record) {
		return mapper.insertSelective(record);
	}

	@Override
	public SysProduct selectByPrimaryKey(Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(SysProduct record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKeyWithBLOBs(SysProduct record) {
		return mapper.updateByPrimaryKeyWithBLOBs(record);
	}

	@Override
	public int updateByPrimaryKey(SysProduct record) {
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public PageResult findPage(PageRequest pageRequest) {
		Object name = pageRequest.getParamValue("name");
		if(name!=null && name != "") {
			return MybatisPageHelper.findPage(pageRequest, mapper, "findPageByName", name);
		}
		return MybatisPageHelper.findPage(pageRequest, mapper);
	}

}
