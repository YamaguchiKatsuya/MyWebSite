package model;

public class itemdate {

	private int id;
	private int buy_id;
	private int item_id;
	private String itemName;
	private String detail;
	private String price;
	private String fileName;
	private String createDate;
	private String updateDate;



	public itemdate(int id, int buy_id, int item_id, String itemName, String detail, String price, String fileName) {
		super();
		this.id = id;
		this.buy_id = buy_id;
		this.item_id = item_id;
		this.itemName = itemName;
		this.detail = detail;
		this.price = price;
		this.fileName = fileName;
	}
	public itemdate(String itemName, String detail, String price, String fileName) {
		super();
		this.itemName = itemName;
		this.detail = detail;
		this.price = price;
		this.fileName = fileName;
	}
	public itemdate(int id, String itemName, String detail, String price, String fileName, String createDate,
			String updateDate) {
		super();
		this.id = id;
		this.itemName = itemName;
		this.detail = detail;
		this.price = price;
		this.fileName = fileName;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}
	public itemdate() {
		super();
	}
	public itemdate(int id, String itemName, String detail, String price, String fileName) {
		super();
		this.id = id;
		this.itemName = itemName;
		this.detail = detail;
		this.price = price;
		this.fileName = fileName;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	public int getBuy_id() {
		return buy_id;
	}
	public void setBuy_id(int buy_id) {
		this.buy_id = buy_id;
	}
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

}
