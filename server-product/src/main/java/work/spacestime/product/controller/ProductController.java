package work.spacestime.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import work.spacestime.core.http.HttpResult;
import work.spacestime.core.page.PageRequest;
import work.spacestime.product.model.SysProduct;
import work.spacestime.product.service.ProductService;



@RestController
//@RequestMapping("product")
public class ProductController {
	
	

	@Autowired
	private ProductService productService;
	
	
	
	@PostMapping(value="/save")
	public HttpResult insert(@RequestBody SysProduct record) {
		return HttpResult.ok(productService.insert(record));
	}
	
	
	@PostMapping(value="/update")
	public HttpResult update(@RequestBody SysProduct record) {
		return HttpResult.ok(productService.updateByPrimaryKey(record));
	}

	@GetMapping(value="/delete")
	public HttpResult delete(@RequestParam(value="id", required=true)Long id) {
		return HttpResult.ok(productService.deleteByPrimaryKey(id));
	}

	@PostMapping(value="/findPage")
	public HttpResult findPage(@RequestBody PageRequest pageRequest) {
		return HttpResult.ok(productService.findPage(pageRequest));
	}
	
	
}