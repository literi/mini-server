package work.spacestime.product.po;

import work.spacestime.product.model.SysProduct;

public class Product extends SysProduct{

	private static final long serialVersionUID = 1L;
	
	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	

}
