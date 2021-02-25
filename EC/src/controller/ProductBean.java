package controller;

public class ProductBean {
	//product情報を入れるためpro_cd, pro_name, stock_no, pro_price, cat_id, pro_img, pro_msgをカプセル化する
	private int proCd;
	private String proName;
	private int stockNo;
	private int proPrice;
	private int catId;
	private String proImg;
	private String proMsg;

	public int getProCd() {
		return proCd;
	}
	public void setProCd(int proCd) {
		this.proCd = proCd;
	}


	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}


	public int getStockNo() {
		return stockNo;
	}
	public void setStockNo(int stockNo) {
		this.stockNo = stockNo;
	}


	public int getProPrice() {
		return proPrice;
	}
	public void setProPrice(int proPrice) {
		this.proPrice = proPrice;
	}


	public int getCatId() {
		return catId;
	}
	public void setCatId(int catId) {
		this.catId = catId;
	}


	public String getProImg() {
		return proImg;
	}
	public void setProImg(String proImg) {
		this.proImg = proImg;
	}


	public String getProMsg() {
		return proMsg;
	}
	public void setProMsg(String proMsg) {
		this.proMsg = proMsg;
	}


}
