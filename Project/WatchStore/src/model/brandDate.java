package model;

public class brandDate {

	private int id;
	private String brandName;
	private String fileName;
	private String fileName2;


	public brandDate(String brandName) {
		super();
		this.brandName = brandName;
	}
	public brandDate(String brandName, String fileName, String fileName2) {
		super();
		this.brandName = brandName;
		this.fileName = fileName;
		this.fileName2 = fileName2;
	}
	public brandDate(int id, String brandName, String fileName, String fileName2) {
		super();
		this.id = id;
		this.brandName = brandName;
		this.fileName = fileName;
		this.fileName2 = fileName2;
	}
	public brandDate() {
		super();
	}
	public brandDate(String brandName, String fileName) {
		super();
		this.brandName = brandName;
		this.fileName = fileName;
	}
	public brandDate(int id, String brandName, String fileName) {
		super();
		this.id = id;
		this.brandName = brandName;
		this.fileName = fileName;
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
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileName2() {
		return fileName2;
	}
	public void setFileName2(String fileName2) {
		this.fileName2 = fileName2;
	}



}
