package model;

public class itemdate {

	private int id;
	private String itemName;
	private String detail;
	private int price;
	private String fileName;
	private String createDate;
	private String updateDate;


	public itemdate(int id, String itemName, String detail, int price, String fileName, String createDate,
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
	public itemdate(int id, String itemName, String detail, int price, String fileName) {
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
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

}
