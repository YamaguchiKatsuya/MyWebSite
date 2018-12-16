package model;

public class buyDetail {

	private int id;
	private int buyId;
	private int itemId;


	public buyDetail() {
		super();
	}
	public buyDetail(int id, int buyId, int itemId) {
		super();
		this.id = id;
		this.buyId = buyId;
		this.itemId = itemId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBuyId() {
		return buyId;
	}
	public void setBuyId(int buyId) {
		this.buyId = buyId;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}



}
