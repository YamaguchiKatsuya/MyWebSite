package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class userdate {

	private int id;
	private String user_name;
	private String address;
	private String birth_date;
	private String password;
	private String create_date;
	private Date update_date;




	public userdate(String user_name, String address, String birth_date, String password) {
		super();
		this.user_name = user_name;
		this.address = address;
		this.birth_date = birth_date;
		this.password = password;
	}
	public userdate(int id, String user_name, String password) {
		super();
		this.id = id;
		this.user_name = user_name;
		this.password = password;
	}
	public userdate(String user_name, String password) {
		super();
		this.user_name = user_name;
		this.password = password;
	}
	public userdate() {
		super();
	}
	public userdate(int id, String user_name, String address, String birth_date, String password, String create_date,
			Date update_date) {
		super();
		this.id = id;
		this.user_name = user_name;
		this.address = address;
		this.birth_date = birth_date;
		this.password = password;
		this.create_date = create_date;
		this.update_date = update_date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBirth_date() {
		return birth_date;
	}
	public void setBirth_date(String birth_date) {
		this.birth_date = birth_date;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCreate_date() {
		return create_date;
	}
	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}
	public Date getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}
	public String getFormatDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH時mm分");
		return sdf.format(update_date);
	}
}

