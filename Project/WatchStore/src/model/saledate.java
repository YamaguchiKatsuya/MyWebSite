package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class saledate {

	private int id;
	private String brandName;
	private String itemName;
	private String detail;
	private String price;
	private String fileName;
	private String fileName2;
	private String createDate;
	private Date updateDate;
	private String sale;
	private String startDate;
	private String finishDate;
	private int saleprice;




	public saledate(int id, String itemName, String detail, String price, String fileName2, String createDate,
			Date updateDate, String sale, String startDate, String finishDate, int saleprice) {
		super();
		this.id = id;
		this.itemName = itemName;
		this.detail = detail;
		this.price = price;
		this.fileName2 = fileName2;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.sale = sale;
		this.startDate = startDate;
		this.finishDate = finishDate;
		this.saleprice = saleprice;
	}

	public saledate(int id, String itemName, String detail, String price, String fileName2, String createDate,
			Date updateDate, String sale, String startDate, String finishDate) {
		super();
		this.id = id;
		this.itemName = itemName;
		this.detail = detail;
		this.price = price;
		this.fileName2 = fileName2;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.sale = sale;
		this.startDate = startDate;
		this.finishDate = finishDate;
	}

	public saledate(int id, String brandName, String sale, String startDate, String finishDate) {
		super();
		this.id = id;
		this.brandName = brandName;
		this.sale = sale;
		this.startDate = startDate;
		this.finishDate = finishDate;
	}
	public saledate(String brandName, String sale, String startDate, String finishDate) {
		super();
		this.brandName = brandName;
		this.sale = sale;
		this.startDate = startDate;
		this.finishDate = finishDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
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
	public String getSale() {
		return sale;
	}
	public void setSale(String sale) {
		this.sale = sale;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getFinishDate() {
		return finishDate;
	}
	public void setFinishDate(String finishDate) {
		this.finishDate = finishDate;
	}
	public int getSaleprice() {
		return saleprice;
	}
	public void setSaleprice(int saleprice) {
		this.saleprice = saleprice;
	}
	public String getFormatDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH時mm分");
		return sdf.format(updateDate);
	}

	public String getFileName2() {
		return fileName2;
	}

	public void setFileName2(String fileName2) {
		this.fileName2 = fileName2;
	}



}
