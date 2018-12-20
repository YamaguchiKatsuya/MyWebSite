package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class itemdate {

	private int id;
	private int buy_id;
	private int item_id;
	private String brandName;
	private String itemName;
	private String detail;
	private String price;
	private String fileName;
	private String fileName2;
	private String createDate;
	private Date updateDate;





	public itemdate(int id,String itemName, String detail, String price, String fileName,
			 String createDate, Date updateDate,String fileName2) {
		super();
		this.id = id;
		this.itemName = itemName;
		this.detail = detail;
		this.price = price;
		this.fileName = fileName;
		this.fileName2 = fileName2;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}

	public itemdate(String brandName, String itemName, String detail, String price, String fileName, String fileName2) {
		super();
		this.brandName = brandName;
		this.itemName = itemName;
		this.detail = detail;
		this.price = price;
		this.fileName = fileName;
		this.fileName2 = fileName2;
	}

	public itemdate(String brandName, String itemName, String detail, String price, String fileName) {
		super();
		this.brandName = brandName;
		this.itemName = itemName;
		this.detail = detail;
		this.price = price;
		this.fileName = fileName;
	}

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
			Date updateDate) {
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
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
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
	public String getFileName2() {
		return fileName2;
	}
	public void setFileName2(String fileName2) {
		this.fileName2 = fileName2;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getFormatDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH時mm分");
		return sdf.format(updateDate);
	}

}
